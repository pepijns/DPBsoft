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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_charities, menu);
		return true;
	}
	static final String[] DIERENCHARITIES = new String[] { "WNF", "WSPA", "Charity 3",
		"Charity 4", "Charity 5", "Charity 6", "Charity 7", "Charity 8",
		"Charity 9", "Charity 10", "Charity 11", "Charity 12", "Charity 13" };
	
	private int category;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		category = Globals.getInstance().getCategory();
		
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
						case 0: //wnf
							Globals.getInstance().setCharity(1);
							Intent intent1 = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
							startActivity(intent1);
							break;
						case 1: //wspa
							Globals.getInstance().setCharity(2);
							Intent intent2 = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
							startActivity(intent2);
							break;
						default:
							break;
					}
				}
			});
			break;
		default:
			setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_list_categories,DIERENCHARITIES));
			ListView defaultListView = getListView();
			defaultListView.setTextFilterEnabled(true);
			/* knoppen */
			defaultListView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					//welke knop?
					switch (position){
						case 0: //wnf
							Globals.getInstance().setCharity(1);
							Intent intent1 = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
							startActivity(intent1);
							break;
						case 1: //wspa
							Globals.getInstance().setCharity(2);
							Intent intent2 = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
							startActivity(intent2);
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
