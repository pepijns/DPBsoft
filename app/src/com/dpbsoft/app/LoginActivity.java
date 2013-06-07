package com.dpbsoft.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;

public class LoginActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		setContentView(R.layout.activity_login);
		super.onCreate(savedInstanceState);
		
		Parse.initialize(this, "B6hZvvU0sVgaDY7a9hpYvntoE5rWPHECMJ8PQxkx", "KIsuKwb6sPQO5STRqL4PmN3EqjyoEPRyxLaDhRi9"); 
		ParseFacebookUtils.initialize("172436992923336");		

		ParseFacebookUtils.logIn(this, new LogInCallback() {
			@Override
			  public void done(ParseUser user, ParseException err) {
			    if (user == null) {
			    	Toast.makeText(getApplicationContext(), "Log in om deze applicatie te gebruiken. Voor deze applicatie is een internetverbinding vereist.", Toast.LENGTH_LONG).show();
			    	Intent intent = new Intent(LoginActivity.this, MainActivity.class);
			        startActivity(intent);
			    } else if (user.isNew()) {
			    	Intent intent = new Intent(LoginActivity.this, NieuwsOverzichtActivity.class);
			        startActivity(intent);
			    } else {
			    	Intent intent = new Intent(LoginActivity.this, NieuwsOverzichtActivity.class);
			        startActivity(intent);
			    }
			  }
			});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	  super.onActivityResult(requestCode, resultCode, data);
	  ParseFacebookUtils.finishAuthentication(requestCode, resultCode, data);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
}
