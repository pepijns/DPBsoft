package com.dpbsoft.app;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class NieuwsOverzichtActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nieuw_overzicht);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nieuws_overzicht, menu);
		return true;
	}

}
