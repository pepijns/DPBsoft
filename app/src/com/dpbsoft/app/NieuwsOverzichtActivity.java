package com.dpbsoft.app;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.developerworks.android.FeedParserFactory;
import org.developerworks.android.Message;
import org.developerworks.android.ParserType;
import org.xmlpull.v1.XmlSerializer;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Xml;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.facebook.Session;
import com.facebook.SessionState;

public class NieuwsOverzichtActivity extends Activity implements AdapterView.OnItemClickListener{

	// Store the messages from the RSS
	private List<Message> messages = new ArrayList<Message>();
	
	// Store the extracted information from the messages
	static List<String> titles;
	static List<String> descriptions;
	static List<String> dates;
	static List<String> paths;
	static List<String> hosts;
	static List<String> protocols;
	
	private boolean mIsBackButtonPressed;
	private int group1Id = 1;
	private boolean isFBinstalled;
	private static Context context;
	static int ArrayPosition;
	
	public ListView lstTweets = null;
	String newscategory = new String();
	String rank1;
	String rank2;
	String rank3;
	String rank4;
	String rank5;
	String rank6;
	
	int nieuwsId = Menu.FIRST;
	int logoutId = Menu.FIRST +1;
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

	    menu.add(group1Id, nieuwsId, nieuwsId, "Categorieën");
	    if (!isFBinstalled) { 
	    	menu.add(group1Id, logoutId, logoutId, "Logout");
	    }

	    return super.onCreateOptionsMenu(menu); 
	    }
	
	private boolean appInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        boolean app_installed = false;
        try {
               pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
               app_installed = true;
        }
        catch (PackageManager.NameNotFoundException e){
               app_installed = false;
        }
        return app_installed ;
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		   switch (item.getItemId()) {

				case 1:
					Intent intent = new Intent(NieuwsOverzichtActivity.this, ListCategoriesActivity.class);
			        startActivity(intent);
			        return true;
			
				case 2:
					Session session = Session.getActiveSession();
					session.closeAndClearTokenInformation();
					
					SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(context);
	    			p.edit().putBoolean("loggedIn", false).commit();
	    			
					Toast.makeText(getApplicationContext(), "U bent uitgelogd.", Toast.LENGTH_LONG).show();
					startActivity(new Intent(NieuwsOverzichtActivity.this, MainActivity.class));

				default:
				    break;
				}
		   
	    return super.onOptionsItemSelected(item);
	    
	}
	@Override
	  public void onActivityResult(int requestCode, int resultCode, Intent data) {
	      super.onActivityResult(requestCode, resultCode, data);
	      Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);	
	}
	
	public void fbLogin() {
		Session.openActiveSession(this, true, new Session.StatusCallback() {
	    	@Override
	    	public void call(Session session, SessionState state, Exception exception) { 
	    	}
		});
	}

	 @Override
	 public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 addInt();
		 sortList();
		 algemeenOrder();
		 setContentView(R.layout.activity_nieuw_overzicht);
		 isFBinstalled = appInstalledOrNot("com.facebook.katana");
		 fbLogin();
		 NieuwsOverzichtActivity.context = getApplicationContext();
		 
		 Bundle extras = getIntent().getExtras();
		 if (extras != null) {
		     newscategory = extras.getString("newscategory");
		 }
		 else
			newscategory = "algemeen";
	        
		 // Load the list with messages
		 lstTweets = (ListView)findViewById(R.id.listViewRss);
		 lstTweets.setOnItemClickListener(this);

		 new AsyncTask<Void, Void, Void>() {

			 ProgressDialog p;
			 boolean success = false;

			 @Override
			 protected void onPostExecute(Void aVoid) {
				 p.dismiss();
				 if (!success) {

					 NieuwsOverzichtActivity.this.runOnUiThread(new Runnable() {
						 public void run() {
							 Toast toast = Toast.makeText(NieuwsOverzichtActivity.this, "Sorry, er kon geen verbinding met internet gemaakt worden.", Toast.LENGTH_LONG);
							 toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
							 toast.show();
						 }
					 });

				 } else {
					 ArrayAdapter<String> adapter = new ArrayAdapter<String>(NieuwsOverzichtActivity.this, R.layout.rss_list,titles);
					 lstTweets.setAdapter(adapter);
				 }
			 }

			 @Override
			 protected void onPreExecute() {
				 p  = ProgressDialog.show(NieuwsOverzichtActivity.this,"Laden...","...een ogenblik geduld alstublieft.");
			 }

			 @Override
			 protected Void doInBackground(Void... params) {
				 try {
					 loadFeed(ParserType.ANDROID_SAX);
					 if (messages!=null&&messages.size()>0) success = true;
				 } catch (RuntimeException e) {}
				 catch (Exception e) {}
				 return null;
			 }
		 }.execute();
	}

	public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
		 lstTweets.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			 @Override
			 public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				 	ArrayPosition = position;
				 	Intent intent = new Intent(NieuwsOverzichtActivity.this, NieuwsArtikelActivity.class);
				 	startActivity(intent);
			 		}
		 	}); 
	 }


	 private void loadFeed(ParserType type){
	     try{
	    	 
	      Log.i("AndroidNews", "ParserType="+type.name());
	      long start = System.currentTimeMillis();
	      
	      for(String s : getFeeds(newscategory))
	      {
	    	  messages.addAll(FeedParserFactory.getParser(type, s).parse());
	      }
	      
	      Collections.sort(messages, new CustomComparator());
	      Collections.reverse(messages);
	      
	      long duration = System.currentTimeMillis() - start;
	      String xml = writeXml();      
	      
	      // Initialize the ArrayLists
	      titles = new ArrayList<String>(messages.size());
	      descriptions = new ArrayList<String>(messages.size());
	      dates = new ArrayList<String>(messages.size());
	      paths = new ArrayList<String>(messages.size());
	      hosts = new ArrayList<String>(messages.size());
	      protocols = new ArrayList<String>(messages.size());
	      
	      // Extract and store the information
	      for (Message msg : messages){
	    	  titles.add(msg.getTitle());
	    	  descriptions.add(msg.getDescription());
	    	  dates.add(msg.getDate());
	    	  paths.add(msg.getLink().getPath());
	    	  hosts.add(msg.getLink().getHost());
	    	  protocols.add(msg.getLink().getProtocol());
	      }
	      
	      } catch (Throwable t){
	      Log.e("AndroidNews",t.getMessage(),t);
	      }
	}

	 private String writeXml(){
		 XmlSerializer serializer = Xml.newSerializer();
		 StringWriter writer = new StringWriter();
		 
		 	try {
		 		serializer.setOutput(writer);
		 		serializer.startDocument("UTF-8", true);
		 		serializer.startTag("", "messages");
		 		serializer.attribute("", "number", String.valueOf(messages.size()));
		 	for (Message msg: messages){
		 		serializer.startTag("", "message");
		 		serializer.attribute("", "date", msg.getDate());
		 		serializer.startTag("", "title");
		 		serializer.text(msg.getTitle());
		 		serializer.endTag("", "title");
		 		serializer.startTag("", "url");
		 		serializer.text(msg.getLink().toExternalForm());
		 		serializer.endTag("", "url");
		 		serializer.startTag("", "body");
		 		serializer.text(msg.getDescription());
		 		serializer.endTag("", "body");
		 		serializer.endTag("", "message");
		 }
		 	
		 serializer.endTag("", "messages");
		 serializer.endDocument();
		 return writer.toString();
		 } catch (Exception e) {
		 throw new RuntimeException(e);
		 }
	}
	    
		public class CustomComparator implements Comparator<Message> {
		     @Override
		     public int compare(Message o1, Message o2) {
		         return o1.getDate().compareTo(o2.getDate());
		     		}
		       }
	 
		public class CustomIntComparator implements Comparator<Integer> {
		     @Override
		     public int compare(Integer o1, Integer o2)
		        {
		            return o2.compareTo(o1);
		        }
		       }
	 
		public String[] getFeeds(String cat){
			if(cat == "algemeen")
				return feedAlgemeen;
			else
				return feedDieren;
		}
	 
	 	private String feedWnf = "http://www.nu.nl/feeds/rss/tag/dieren.rss";
		private String feedWspa = "http://feeds.feedburner.com/OverzichtGoedeDoelen";
		
		private String[] feedDieren = {feedWnf,feedWspa};
		
		//hier moeten nog feeds in:
		private String[] feedNatuur = {feedWnf,feedWspa};
		private String[] feedOntwikkeling = {feedWnf,feedWspa};
		private String[] feedVluchtelingen = {feedWnf,feedWspa};
		private String[] feedOverig = {feedWnf,feedWspa};
		private String[] feedZiektes = {feedWnf,feedWspa};
		
		private String[] feedAlgemeen = {rank1,rank2,rank3,rank4,rank5,rank6};

		ListCategoriesActivity lca = new ListCategoriesActivity();
		int dierenRank = lca.getRankingDieren();
		int natuurRank = lca.getRankingNatuur();
		int ontwikkelingRank = lca.getRankingOntwikkeling();
		int vluchtelingenRank = lca.getRankingVluchtelingen();
		int ziektesRank = lca.getRankingZiektes();
		int overigRank = lca.getRankingOverig();
		
		List<Integer> points = new ArrayList<Integer>();
		
		public void algemeenOrder(){
			
				 //rank1
			
				 if(points.get(1) == dierenRank)
					{
					rank1 = feedWnf;
					}
				 else if(points.get(1) == natuurRank)
				 {
					rank1 = feedWnf;
				 }
				 else if(points.get(1) == ontwikkelingRank)
					{
					rank1 = feedWnf;
					}
				 else if(points.get(1) == vluchtelingenRank)
				 {
					rank1 = feedWnf;
				 }
				 else if(points.get(1) == ziektesRank)
					{
					rank1 = feedWnf;
					}
				 else if(points.get(1) == overigRank)
				 {
					rank1 = feedWnf;
				 }
				 
				//rank2
				 
				 if(points.get(2) == dierenRank)
					{
					rank2 = feedWnf;
					}
				 else if(points.get(2) == natuurRank)
				 {
					rank2 = feedWnf;
				 }
				 else if(points.get(2) == ontwikkelingRank)
					{
					rank2 = feedWnf;
					}
				 else if(points.get(2) == vluchtelingenRank)
				 {
					rank2 = feedWnf;
				 }
				 else if(points.get(2) == ziektesRank)
					{
					rank2 = feedWnf;
					}
				 else if(points.get(2) == overigRank)
				 {
					rank2 = feedWnf;
				 }

				//rank3
				 
				 if(points.get(3) == dierenRank)
					{
					rank3 = feedWnf;
					}
				 else if(points.get(3) == natuurRank)
				 {
					rank3 = feedWnf;
				 }
				 else if(points.get(3) == ontwikkelingRank)
					{
					rank3 = feedWnf;
					}
				 else if(points.get(3) == vluchtelingenRank)
				 {
					rank3 = feedWnf;
				 }
				 else if(points.get(3) == ziektesRank)
					{
					rank3 = feedWnf;
					}
				 else if(points.get(3) == overigRank)
				 {
					rank3 = feedWnf;
				 }
				 
				//rank4
				 
				 if(points.get(4) == dierenRank)
					{
					rank4 = feedWnf;
					}
				 else if(points.get(4) == natuurRank)
				 {
					rank4 = feedWnf;
				 }
				 else if(points.get(4) == ontwikkelingRank)
					{
					rank4 = feedWnf;
					}
				 else if(points.get(4) == vluchtelingenRank)
				 {
					rank4 = feedWnf;
				 }
				 else if(points.get(4) == ziektesRank)
					{
					rank4 = feedWnf;
					}
				 else if(points.get(4) == overigRank)
				 {
					rank4 = feedWnf;
				 }
				 
				//rank5
				 
				 if(points.get(5) == dierenRank)
					{
					rank5 = feedWnf;
					}
				 else if(points.get(5) == natuurRank)
				 {
					rank5 = feedWnf;
				 }
				 else if(points.get(5) == ontwikkelingRank)
					{
					rank5 = feedWnf;
					}
				 else if(points.get(5) == vluchtelingenRank)
				 {
					rank5 = feedWnf;
				 }
				 else if(points.get(5) == ziektesRank)
					{
					rank5 = feedWnf;
					}
				 else if(points.get(5) == overigRank)
				 {
					rank5 = feedWnf;
				 }
				 
				//rank6
				 
				 if(points.get(6) == dierenRank)
					{
					rank6 = feedWnf;
					}
				 else if(points.get(6) == natuurRank)
				 {
					rank6 = feedWnf;
				 }
				 else if(points.get(6) == ontwikkelingRank)
					{
					rank6 = feedWnf;
					}
				 else if(points.get(6) == vluchtelingenRank)
				 {
					rank6 = feedWnf;
				 }
				 else if(points.get(6) == ziektesRank)
					{
					rank6 = feedWnf;
					}
				 else if(points.get(6) == overigRank)
				 {
					rank6 = feedWnf;
				 }
			 
		}
		
		
	
		public void addInt() {
			points.add(dierenRank);
			points.add(natuurRank);
			points.add(ontwikkelingRank);
			points.add(vluchtelingenRank);
			points.add(ziektesRank);
			points.add(overigRank);
		}
				
		public void sortList() {
			Collections.sort(points, new CustomIntComparator());
			Collections.reverse(points);
		}
		
		
		@Override
	    public void onBackPressed() {
	        // set the flag to true so the next activity won't start up
	        mIsBackButtonPressed = true;
	        super.onBackPressed();
	    }
}
