package com.dpbsoft.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class CharityWNFMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_charity_wnfmain);
		
		/* Knoppen */
		Button btnInfo = (Button)findViewById(R.id.btnInfo);
		Button btnComments = (Button)findViewById(R.id.btnComments);
		Button btnSteun = (Button)findViewById(R.id.btnSteun);
		
		btnInfo.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		    	  Intent intent = new Intent(CharityWNFMainActivity.this, CharityWNFInfoActivity.class);
		    	  startActivity(intent);
		      }
		});
		
		btnComments.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		    	  Intent intent = new Intent(CharityWNFMainActivity.this, CharityWNFCommentActivity.class);
		    	  startActivity(intent);
		      }
		});
		
		btnSteun.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		    	  Intent intent = new Intent(CharityWNFMainActivity.this, CharityWNFSupportActivity.class);
		    	  startActivity(intent);
		      }
		});
		/* Einde knoppen */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.charity_wnfmain, menu);
		return true;
	}

}
