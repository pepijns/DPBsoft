package com.dpbsoft.app;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class CharityWNFMainActivity extends CharityMainActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_charity_wnfmain);
		
		Button btnInfo = (Button)findViewById(R.id.btnInfo);
		
		btnInfo.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		    	  Intent intent = new Intent(CharityWNFMainActivity.this, CharityWNFInfoActivity.class);
		    	  startActivity(intent);
		      }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.charity_wnfmain, menu);
		return true;
	}

}
