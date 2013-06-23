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
 
	//list of categories
	static final String[] CATEGORIES = new String[] { "Dieren", "Natuur en milieu", "Ontwikkelingshulp", "Vluchtelingenhulp", "Ziekten en aandoeningen", "Overig" };

	//categories
	private static final int DIEREN = 1;
	private static final int NATUUR = 2;
	private static final int ONTWIKKELING = 3;
	private static final int VLUCHTELINGEN = 4;
	private static final int ZIEKTES = 5;
	private static final int OVERIG = 6;
	
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
				switch (position){
				case 0:
					Globals.getInstance().setCategory(DIEREN);
					Intent a = new Intent(ListCategoriesActivity.this, CategoryDierenActivity.class);
					startActivity(a);
					break;
				case 1:
					Globals.getInstance().setCategory(NATUUR);
					Intent b = new Intent(ListCategoriesActivity.this, CategoryNatuurEnMilieuActivity.class);
					startActivity(b);
					break;
				case 2:
					Globals.getInstance().setCategory(ONTWIKKELING);
					Intent c = new Intent(ListCategoriesActivity.this, CategoryOntwikkelingshulpActivity.class);
					startActivity(c);
					break;
				case 3:
					Globals.getInstance().setCategory(VLUCHTELINGEN);
					Intent d = new Intent(ListCategoriesActivity.this, CategoryVluchtelingenhulpActivity.class);
					startActivity(d);
					break;
				case 4:
					Globals.getInstance().setCategory(ZIEKTES);
					Intent e = new Intent(ListCategoriesActivity.this, CategoryZiektenEnAandoeningenActivity.class);
					startActivity(e);
					break;
				case 5:
					Globals.getInstance().setCategory(OVERIG);
					Intent f = new Intent(ListCategoriesActivity.this, CategoryOverigActivity.class);
					startActivity(f);
					break;
				}
			}
		});
		/* Einde knoppen */
		/* Einde lijst */
 
	}
 
}