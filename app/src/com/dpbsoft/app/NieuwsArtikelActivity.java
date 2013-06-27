package com.dpbsoft.app;

import java.util.Arrays;
import java.util.List;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.facebook.Session;
import com.facebook.widget.WebDialog;

public class NieuwsArtikelActivity extends Activity implements OnClickListener{
	
	private String titleString;
	private String descriptionString;
	private String dateString;
	private String linkPath;
	private String linkHost;
	private String linkProtocol;
	private int position = NieuwsOverzichtActivity.ArrayPosition;
	private static final List<String> PERMISSIONS = Arrays.asList("publish_actions");
	private static final int REAUTH_ACTIVITY_CODE = 100;
	
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
	public void onClick(View v) {
		switch(v.getId()) {
    	case R.id.tvShare:
    		share(titleString, linkProtocol, linkHost, linkPath);
    		break;
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
	
private void share(String titleString, String linkProtocol, String linkHost, String linkPath) {
		requestPublishPermissions(Session.getActiveSession());
		Bundle bundle = new Bundle();
		bundle.putString("caption", "Lees ook eens dit artikel!");
		bundle.putString("description", "Gedeeld via Charitybook.");
		bundle.putString("link", ""+linkProtocol+"://"+linkHost+linkPath+"");
		bundle.putString("name", ""+titleString);
		new WebDialog.FeedDialogBuilder(NieuwsArtikelActivity.this, Session.getActiveSession(), bundle).build().show();
	}
	
	private void requestPublishPermissions(Session session) {
	    if (session != null) {
	        Session.NewPermissionsRequest newPermissionsRequest = new Session.NewPermissionsRequest(this, PERMISSIONS).setRequestCode(REAUTH_ACTIVITY_CODE);
	        session.requestNewPublishPermissions(newPermissionsRequest);
	    }
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);
	    switch(requestCode) {
	    default:
	        if(Session.getActiveSession() != null) 
	            Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
	        break;
	    }
	}
}
