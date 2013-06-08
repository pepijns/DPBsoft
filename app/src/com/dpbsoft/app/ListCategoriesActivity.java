package com.dpbsoft.app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
 
public class ListCategoriesActivity extends ListActivity {
 
	static final String[] CATEGORIES = new String[] { "Dieren", "Natuur en milieu", "Noodhulp", "Ontwikkelingshulp", "Vluchtelingenhulp", "Ziekten en aandoeningen", "Overig" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		
		/* Lijst */
		
		setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_list_categories,CATEGORIES));
 
		ListView listView = getListView();
		listView.setTextFilterEnabled(true);
		
		/* Lijst knoppen */
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(ListCategoriesActivity.this, CategoryDierenActivity.class);
		        startActivity(intent);
			}
		});
		/* Einde knoppen */
		/* Einde lijst */
 
	}
 
}