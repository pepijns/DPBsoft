package com.dpbsoft.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class CharityMainActivity extends Activity {

	private int charity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		charity = Globals.getInstance().getCharity();
		
		/* Kijken welke pagina er weergegeven moeten worden */
		switch (charity){
		case 1: /* wnf */
			setContentView(R.layout.activity_charity_wnfmain);
			break;
		case 2: /* wspa */
			setContentView(R.layout.activity_charity_wspamain);
			break;
		default:
			setContentView(R.layout.activity_charity_wnfmain);
			break;
		}
		
		/* Knoppen */
		Button btnInfo = (Button)findViewById(R.id.btnInfo);
		Button btnComments = (Button)findViewById(R.id.btnComments);
		Button btnSteun = (Button)findViewById(R.id.btnSteun);
		
		btnInfo.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		    	  Intent intent = new Intent(CharityMainActivity.this, CharityInfoActivity.class);
		    	  startActivity(intent);
		      }
		});
		
		btnComments.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		    	  Intent intent = new Intent(CharityMainActivity.this, CharityCommentActivity.class);
		    	  startActivity(intent);
		      }
		});
		
		btnSteun.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		    	  Intent intent = new Intent(CharityMainActivity.this, CharitySupportActivity.class);
		    	  startActivity(intent);
		      }
		});
		/* Einde knoppen */
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.charity_main, menu);
		return true;
	}

}
