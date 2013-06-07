package com.dpbsoft.app;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class CategoryDierenActivity extends CategoryActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category_dieren);

		Button btnNieuws = (Button)findViewById(R.id.btnNieuws);
		Button btnGoedeDoelen = (Button)findViewById(R.id.btnGoedeDoelen);
		
		btnNieuws.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		    	  Intent intent = new Intent(CategoryDierenActivity.this, CategoryNewsDierenActivity.class);
		    	  startActivity(intent);
		      }
		});
		
		btnGoedeDoelen.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		    	  Intent intent = new Intent(CategoryDierenActivity.this, ListCharitiesActivity.class);
		    	  startActivity(intent);
		      }
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.categorie, menu);
		return true;
	}
	
	
}
