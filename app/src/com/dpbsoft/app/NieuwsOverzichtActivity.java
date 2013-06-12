package com.dpbsoft.app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.util.Xml;
import android.view.Gravity;
import android.view.View;
import android.widget.*;
import android.app.Activity;
import android.view.Menu;
import org.developerworks.android.FeedParser;
import org.developerworks.android.FeedParserFactory;
import org.developerworks.android.Message;
import org.developerworks.android.ParserType;
import org.xmlpull.v1.XmlSerializer;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class NieuwsOverzichtActivity extends Activity implements AdapterView.OnItemClickListener{

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nieuws_overzicht, menu);
		return true;
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

}
