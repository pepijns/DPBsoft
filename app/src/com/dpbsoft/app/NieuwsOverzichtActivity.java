package com.dpbsoft.app;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.developerworks.android.FeedParser;
import org.developerworks.android.FeedParserFactory;
import org.developerworks.android.Message;
import org.developerworks.android.ParserType;
import org.xmlpull.v1.XmlSerializer;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
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

	private int group1Id = 1;
	
	int homeId = Menu.FIRST;
	//int profileId = Menu.FIRST +1;
	//int searchId = Menu.FIRST +2;
	//int dealsId = Menu.FIRST +3;
	//int helpId = Menu.FIRST +4;
	//int contactusId = Menu.FIRST +5;
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

	    menu.add(group1Id, homeId, homeId, "").setIcon(R.drawable.ic_launcher);
	    //menu.add(group1Id, profileId, profileId, "").setIcon(R.drawable.ic_launcher);
	    //menu.add(group1Id, searchId, searchId, "").setIcon(R.drawable.ic_launcher);
	    //menu.add(group1Id, dealsId, dealsId, "").setIcon(R.drawable.ic_launcher);
	    //menu.add(group1Id, helpId, helpId, "").setIcon(R.drawable.ic_launcher);
	   // menu.add(group1Id, contactusId, contactusId, "").setIcon(R.drawable.ic_launcher);

	    return super.onCreateOptionsMenu(menu); 
	    }

	   @Override
	    public boolean onOptionsItemSelected(MenuItem item) {

	    switch (item.getItemId()) {

			case 1:
				Intent intent = new Intent(NieuwsOverzichtActivity.this, ListCategoriesActivity.class);
		        startActivity(intent);
			    return true;
		
			//case 2:
			    //code here
			 //   return true;
		
			//case 3:
			           //code here
			 //   return true;
		
			//case 4:
			    //code here
			 //   return true;
		
			//case 5:
			    //code here
		
			  //  return true;
		
			//case 6:
			    //code here
			 //   return true;

			//default:
			  //  break;
			}
	    return super.onOptionsItemSelected(item);
	}
	
	 private List<Message> messages;
	    private List<String> titles;

	    //TweetsAdapter ta = new TweetsAdapter(this);
	    public ListView lstTweets = null;

	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_nieuw_overzicht);
	        
	        // load list of tweets
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
	                            Toast toast = Toast.makeText(NieuwsOverzichtActivity.this, "Sorry, could not connect the interwebz.", Toast.LENGTH_LONG);
	                            toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
	                            toast.show();
	                        }
	                    });

	                } else {
	                    ArrayAdapter<String> adapter =
	                        new ArrayAdapter<String>(NieuwsOverzichtActivity.this, R.layout.rss_list,titles);
	                    lstTweets.setAdapter(adapter);
	                }
	            }

	            @Override
	            protected void onPreExecute() {
	                p  = ProgressDialog.show(NieuwsOverzichtActivity.this,"Loading...","...please wait a moment.");
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
	  Intent viewMessage = new Intent(Intent.ACTION_VIEW,
	    Uri.parse(messages.get(position).getLink().toExternalForm()));
	  this.startActivity(viewMessage);
	    }


	 private void loadFeed(ParserType type){
	     try{
	      Log.i("AndroidNews", "ParserType="+type.name());
	      FeedParser parser = FeedParserFactory.getParser(type,"http://www.nu.nl/feeds/rss/games.rss");
	      long start = System.currentTimeMillis();
	      messages = parser.parse();
	      long duration = System.currentTimeMillis() - start;
	      String xml = writeXml();      
	      titles = new ArrayList<String>(messages.size());
	      for (Message msg : messages){
	       titles.add(msg.getTitle());
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

}
