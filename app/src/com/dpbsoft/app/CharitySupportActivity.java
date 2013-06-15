package com.dpbsoft.app;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class CharitySupportActivity extends Activity {

	private int charity;
	
	Globals globalState = new Globals();

	String donateURL;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		charity = globalState.getCharity();

		/* Kijken welke pagina er weergegeven moeten worden */
		switch (charity){
		case 1: /* wnf */
			setContentView(R.layout.activity_charity_wnfsupport);
			donateURL = "https://www.wnf.nl/nl/hoe_kan_ik_helpen/giften/";
			break;
		case 2: /* wspa */
			setContentView(R.layout.activity_charity_wspasupport);
			donateURL = "http://www.wspa-doneren.nl/wspa/?kclid=ZGFpc3ljb24g";
			break;
		default:
			setContentView(R.layout.activity_charity_wnfsupport);
			donateURL = "https://www.wnf.nl/nl/hoe_kan_ik_helpen/giften/";
			break;
		}

		/* Knoppen */
		
		TextView txtvDonate = (TextView)findViewById(R.id.txtvDonate);
		
		txtvDonate.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		    	  Intent i = new Intent(Intent.ACTION_VIEW, 
		    		       Uri.parse(donateURL));
		    		startActivity(i);
		      }
		});
		
		/* Einde knoppen */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.charity_support, menu);
		return true;
	}

}
