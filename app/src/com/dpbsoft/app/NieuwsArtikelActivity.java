package com.dpbsoft.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class NieuwsArtikelActivity extends Activity {
	
	private String titleString;
	private String descriptionString;
	private String dateString;
	private String linkPath;
	private String linkHost;
	private String linkProtocol;
	private int position = NieuwsOverzichtActivity.ArrayPosition;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nieuws_artikel);
		// Show the Up button in the action bar.
		setupActionBar();
		loadDescription();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nieuws_artikel, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void loadDescription() {
		
		// Extract the information from the RSS
		titleString = NieuwsOverzichtActivity.titles.get(position);
		descriptionString = NieuwsOverzichtActivity.descriptions.get(position);
		dateString = NieuwsOverzichtActivity.dates.get(position);
		linkHost = NieuwsOverzichtActivity.hosts.get(position);
		linkPath = NieuwsOverzichtActivity.paths.get(position);
		linkProtocol = NieuwsOverzichtActivity.protocols.get(position);

		// Create the text view for the title of the message
		TextView textView = (TextView) findViewById(R.id.textView1);
		textView.setTextSize(24);
		textView.setText(titleString);
		    
		// Create the text view for the publishing date of the message
		TextView textView2 = (TextView) findViewById(R.id.textView2);
		textView2.setTextSize(12);
		textView2.setText(dateString);
		
		// Create the text view for the description of the message
		TextView textView3 = (TextView) findViewById(R.id.textView3);
		textView3.setTextSize(16);
		textView3.setText(descriptionString);
		    
		// Create the text view with the URL to the full article
		TextView textView4 = (TextView) findViewById(R.id.textView4);  
		String linkText = "Voor het volledige artikel, klik <a href=\""+linkProtocol+"://"+linkHost+linkPath+"\">hier</a>";
		textView4.setMovementMethod(LinkMovementMethod.getInstance());
		textView4.setText(Html.fromHtml(linkText));
		    
	}
}
