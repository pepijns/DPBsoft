package com.dpbsoft.app;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ListCharitiesActivity extends ListActivity {
	
	//Lists
	static final String[] DIERENCHARITIES = new String[] { "WNF", "WSPA", "Charity 3", "Charity 4", "Charity 5"};
	static final String[] NATUURCHARITIES = new String[] { "WNF", "WSPA", "Charity 3", "Charity 4", "Charity 5"};
	static final String[] NOODHULPCHARITIES = new String[] { "WNF", "WSPA", "Charity 3", "Charity 4", "Charity 5"};
	static final String[] ONTWIKKELINGSCHARITIES = new String[] { "WNF", "WSPA", "Charity 3", "Charity 4", "Charity 5"};
	static final String[] VLUCHTELINGENCHARITIES = new String[] { "WNF", "WSPA", "Charity 3", "Charity 4", "Charity 5"};
	static final String[] ZIEKTESCHARITIES = new String[] { "WNF", "WSPA", "Charity 3", "Charity 4", "Charity 5"};
	static final String[] OVERIGECHARITIES = new String[] { "WNF", "WSPA", "Charity 3", "Charity 4", "Charity 5"};
	
	//charities
	private static final int WNF = 1;
	private static final int WSPA = 2;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_charities, menu);
		return true;
	}
	
	private int category;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		category = Globals.getInstance().getCategory();
		
		setView(category);
	}
	
	private void setView(int category){
		/* Kijken welke lijst er weergegeven moeten worden */
		switch (category){
		case 1: /* dieren */
			setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_list_categories,DIERENCHARITIES));
			ListView dierenListView = getListView();
			dierenListView.setTextFilterEnabled(true);
			/* knoppen */
			dierenListView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					//welke knop?
					switch (position){
						case 0: //WNF
							Intent a = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		a.putExtra("charity",WNF);
							startActivity(a);
							break;
						case 1: //WSPA
							Intent b = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		b.putExtra("charity",WSPA);
							startActivity(b);
							break;
						default:
							break;
					}
				}
			});
			break;
		}
	}

}
