package com.dpbsoft.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

public class SplashActivity extends Activity {
    // used to know if the back button was pressed in the splash screen activity and avoid opening the next activity
    private boolean mIsBackButtonPressed;
    private static final int SPLASH_DURATION = 3000; // 3 seconds
    private static Context context;
    private Boolean loggedIn;
    private Boolean startedBefore;
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        SplashActivity.context = getApplicationContext();
        
        Handler handler = new Handler();
        // run a thread after 2 seconds to start the home screen
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // make sure we close the splash screen so the user won't come back when it presses back key
                finish();
                if (!mIsBackButtonPressed) {
                    // start the home screen if the back button wasn't pressed already
                	checkUser();
                    //Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    //SplashActivity.this.startActivity(intent);
               }  
            }
        }, SPLASH_DURATION); // time in milliseconds (1 second = 1000 milliseconds) until the run() method will be called
    }
 
    @Override
    public void onBackPressed() {
        // set the flag to true so the next activity won't start up
        mIsBackButtonPressed = true;
        super.onBackPressed();
    }
    
	public void checkUser(){
        SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(context);
        loggedIn = p.getBoolean("loggedIn", false);
        startedBefore = p.getBoolean("startedBefore", false);
		
		if (startedBefore == true && loggedIn == true) {
			Intent intent = new Intent(SplashActivity.this, NieuwsOverzichtActivity.class);
			intent.putExtra("newscategory","algemeen");
			startActivity(intent);
		}	
		else if (startedBefore == false) {
			Intent intent = new Intent(SplashActivity.this, MainActivity.class);
			intent.putExtra("newscategory","algemeen");
			startActivity(intent);
			p.edit().putBoolean("startedBefore", true).commit();
		}
	}
}