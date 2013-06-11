package com.dpbsoft.app;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class CharityWNFSupportActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_charity_wnfsupport);
		
		/* Knoppen */
		
		TextView txtvDonate = (TextView)findViewById(R.id.txtvDonate);
		
		txtvDonate.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		    	  Intent i = new Intent(Intent.ACTION_VIEW, 
		    		       Uri.parse("https://www.wnf.nl/nl/hoe_kan_ik_helpen/giften/"));
		    		startActivity(i);
		      }
		});
		
		/* Einde knoppen */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.charity_wnfsupport, menu);
		return true;
	}

}
