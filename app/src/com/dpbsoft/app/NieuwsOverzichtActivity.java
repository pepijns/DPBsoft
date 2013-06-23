package com.dpbsoft.app;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.developerworks.android.FeedParser;
import org.developerworks.android.FeedParserFactory;
import org.developerworks.android.Message;
import org.developerworks.android.ParserType;
import org.xmlpull.v1.XmlSerializer;

import com.facebook.Session;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
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

public class NieuwsOverzichtActivity extends Activity implements AdapterView.OnItemClickListener{

	// Store the messages from the RSS
	private List<Message> messages;
	
	// Store the extracted information from the messages
	static List<String> titles;
	static List<String> descriptions;
	static List<String> dates;
	static List<String> paths;
	static List<String> hosts;
	static List<String> protocols;
	
	private int group1Id = 1;
	
	static int ArrayPosition;
	
	public ListView lstTweets = null;
	String newscategory = new String();
	
	int nieuwsId = Menu.FIRST;
	int logoutId = Menu.FIRST +1;
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

	    menu.add(group1Id, nieuwsId, nieuwsId, "Nieuwsoverzicht");
	    menu.add(group1Id, logoutId, logoutId, "Logout");

	    return super.onCreateOptionsMenu(menu); 
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
				    Toast.makeText(getApplicationContext(), "U bent uitgelogd.", Toast.LENGTH_LONG).show();
				    startActivity(new Intent(getApplicationContext(), MainActivity.class));
				    return true;
	
				default:
				    break;
				}
		   
	    return super.onOptionsItemSelected(item);
	    
	}

	 @Override
	 public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_nieuw_overzicht);
		 
		 
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

				 	NieuwsArtikelActivity naa = new NieuwsArtikelActivity();
				 	int rank = naa.getRanking();
				 	rank=+1;
				 	naa.setRanking(rank);
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
	    
	 @Override
		public void onBackPressed() {
		    // set the flag to true so the next activity won't start up
		 	Intent intent = new Intent(NieuwsOverzichtActivity.this, MainActivity.class);
			startActivity(intent);
	 }
	 
	 	private String feedWnf = "http://www.nu.nl/feeds/rss/tag/dieren.rss";
		private String feedWspa = "http://feeds.feedburner.com/OverzichtGoedeDoelen";
		private String[] feedDieren = {feedWnf,feedWspa};
		private String[] feedAlgemeen = {feedWnf,feedWspa};
		
		public String[] getFeeds(String cat){
			if(cat == "algemeen")
				return feedAlgemeen;
			else
				return feedDieren;
		}

}
