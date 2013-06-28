package com.dpbsoft.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class CategoryOntwikkelingshulpActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category_ontwikkelingshulp);

		/* Knoppen */
		Button btnNieuws = (Button)findViewById(R.id.btnNieuws);
		Button btnGoedeDoelen = (Button)findViewById(R.id.btnGoedeDoelen);
		
		btnNieuws.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		    	  Intent intent = new Intent(CategoryOntwikkelingshulpActivity.this, NieuwsOverzichtActivity.class);
	    			intent.putExtra("newscategory","ontwikkeling");
		    	  startActivity(intent);
		      }
		});
		
		btnGoedeDoelen.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		    	  Intent intent = new Intent(CategoryOntwikkelingshulpActivity.this, ListCharitiesActivity.class);
		    	  startActivity(intent);
		      }
		});
		/* Einde knoppen */
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.categorie, menu);
		return true;
	}
	
	
}
