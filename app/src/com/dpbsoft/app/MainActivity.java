package com.dpbsoft.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.Session;
import com.facebook.SessionState;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/* Knoppen */
		Button loginButton = (Button)findViewById(R.id.loginButton);
		Button aboutButton = (Button)findViewById(R.id.aboutButton);
		
		loginButton.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		    	  ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
		    	      if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED || 
		    	              connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
		    	    	  fbLogin();
		    	      }
		    	      else
		    	    	  Toast.makeText(getApplicationContext(), "Om deze applicatie te gebruiken dient u over een actieve internetverbinding te beschikken.", Toast.LENGTH_LONG).show();  
		      }
		});
		
		aboutButton.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
		        startActivity(intent);
		      }
		});
		/* Einde knoppen */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void aboutScreen(View view) {
	}
	
	public void fbLogin() {
		Session.openActiveSession(this, true, new Session.StatusCallback() {

	    	@Override
	    	public void call(Session session, SessionState state, Exception exception) {
	    		if (session.isOpened()) {
	    			Intent intent = new Intent(MainActivity.this, NieuwsOverzichtActivity.class);
	    			intent.putExtra("newscategory","algemeen");
	    			startActivity(intent);
	    		}     
	    	}
		});
	}
	
	@Override
	  public void onActivityResult(int requestCode, int resultCode, Intent data) {
	      super.onActivityResult(requestCode, resultCode, data);
	      Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
	  }
}
