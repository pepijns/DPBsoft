package com.dpbsoft.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class CharityMainActivity extends Activity implements OnClickListener {
	
	//charities
	private static final int WNF = 1;
	private static final int WSPA = 2;
	
	//view strings
	private static final int WNF_TITLE = R.string.wnf_title;
	private static final int WSPA_TITLE = R.string.wspa_title;

	private int charity; //Charity selected in the list
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_charity_main);
		
		charity = Globals.getInstance().getCharity();
		
		setView(charity);	
	}
	
	private void setView(int charity){
		TextView tv =(TextView)findViewById(R.id.tvTitleMain); 
		
		switch (charity){
		case WNF:
		    tv.setText(WNF_TITLE);
			break;
		case WSPA:
		    tv.setText(WSPA_TITLE);
			break;
		}
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()) {
        	case R.id.btnInfo:
		    	Intent a = new Intent(CharityMainActivity.this, CharityInfoActivity.class);
		    	startActivity(a);
        		break;
        	case R.id.btnSteun:
		    	Intent b = new Intent(CharityMainActivity.this, CharitySupportActivity.class);
		    	startActivity(b);
        		break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.charity_main, menu);
		return true;
	}

	

}
