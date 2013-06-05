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
	static final String[] CHARITIES = new String[] { "WNF", "Charity 2", "Charity 3",
		"Charity 4", "Charity 5", "Charity 6", "Charity 7", "Charity 8",
		"Charity 9", "Charity 10", "Charity 11", "Charity 12", "Charity 13" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_list_categories,CHARITIES));

		ListView listView = getListView();
		listView.setTextFilterEnabled(true);
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(ListCharitiesActivity.this, CharityWNFMainActivity.class);
				startActivity(intent);
			}
		});

	}

}
