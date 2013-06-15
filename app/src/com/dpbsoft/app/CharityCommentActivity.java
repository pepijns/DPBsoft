package com.dpbsoft.app;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CharityCommentActivity extends Activity {

	private int charity;
	
	Globals globalState = new Globals();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		charity = globalState.getCharity();

		/* Kijken welke pagina er weergegeven moeten worden */
		switch (charity){
		case 1: /* wnf */
			setContentView(R.layout.activity_charity_wnfcomment);
			break;
		case 2: /* wspa */
			setContentView(R.layout.activity_charity_wspacomment);
			break;
		default:
			setContentView(R.layout.activity_charity_wnfcomment);
			break;
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.charity_comment, menu);
		return true;
	}

}
