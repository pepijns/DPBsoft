package com.dpbsoft.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.Session;
import com.facebook.SessionState;

public class MainActivity extends Activity {
	
	private static Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		MainActivity.context = getApplicationContext();
		
		/* Knoppen */
		Button loginButton = (Button)findViewById(R.id.loginButton);
		
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
		/* Einde knoppen */
	}
	
	public void fbLogin() {
		Session.openActiveSession(this, true, new Session.StatusCallback() {

	    	@Override
	    	public void call(Session session, SessionState state, Exception exception) {
	    		if (session.isOpened()) {
	    			
	    			//SharedPreferences prefs = getPreferences(0); 
	    			//String restoredText = prefs.getString("text", null);
	    			
	    			//if (restoredText == null) {
		    		//	SharedPreferences.Editor editor = getPreferences(0).edit();
		    		//	editor.putString("text", "KEIHARDE DREK");
		    		//	editor.commit();
		    		//	Toast.makeText(getApplicationContext(), "SHARED INGEVULD", Toast.LENGTH_LONG).show();
	    			//}
	    			
	    			SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(context);
	    			p.edit().putBoolean("loggedIn", true).commit();
	    			
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
