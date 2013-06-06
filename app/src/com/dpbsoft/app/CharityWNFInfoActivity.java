package com.dpbsoft.app;

import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class CharityWNFInfoActivity extends CharityInfoActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_charity_wnfinfo);
		
		TextView txtvURL = (TextView)findViewById(R.id.txtvURL);
		
		txtvURL.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		    	  Intent i = new Intent(Intent.ACTION_VIEW, 
		    		       Uri.parse("http://www.wnf.nl/"));
		    		startActivity(i);
		      }
		});
		
		TextView txtvDonate = (TextView)findViewById(R.id.txtvDonate);
		
		txtvDonate.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		    	  Intent i = new Intent(Intent.ACTION_VIEW, 
		    		       Uri.parse("https://www.wnf.nl/nl/hoe_kan_ik_helpen/giften/"));
		    		startActivity(i);
		      }
		});
	}
	
	@SuppressWarnings("unused")
	private void goToDonate(){
		
	}

}
