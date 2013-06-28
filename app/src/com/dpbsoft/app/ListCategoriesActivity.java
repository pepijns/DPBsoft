package com.dpbsoft.app;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
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
					NieuwsOverzichtActivity ranknew = new NieuwsOverzichtActivity();
					int newRank1 = ranknew.getRankingDieren();
					newRank1+=1;
					ranknew.setRankingDieren(newRank1);
					ranknew.setRank();
					Globals.getInstance().setCategory(DIEREN);
					Intent a = new Intent(ListCategoriesActivity.this, CategoryDierenActivity.class);
					startActivity(a);
					break;
				case 1:
					NieuwsOverzichtActivity ranknew2 = new NieuwsOverzichtActivity();
					int newRank2 = ranknew2.getRankingDieren();
					newRank2+=1;
					ranknew2.setRankingDieren(newRank2);
					ranknew2.setRank();
					Globals.getInstance().setCategory(NATUUR);
					Intent b = new Intent(ListCategoriesActivity.this, CategoryNatuurEnMilieuActivity.class);
					startActivity(b);
					break;
				case 2:
					NieuwsOverzichtActivity ranknew3 = new NieuwsOverzichtActivity();
					int newRank3 = ranknew3.getRankingDieren();
					newRank3+=1;
					ranknew3.setRankingDieren(newRank3);
					ranknew3.setRank();
					Globals.getInstance().setCategory(ONTWIKKELING);
					Intent c = new Intent(ListCategoriesActivity.this, CategoryOntwikkelingshulpActivity.class);
					startActivity(c);
					break;
				case 3:
					NieuwsOverzichtActivity ranknew4 = new NieuwsOverzichtActivity();
					int newRank4 = ranknew4.getRankingDieren();
					newRank4+=1;
					ranknew4.setRankingDieren(newRank4);
					ranknew4.setRank();
					Globals.getInstance().setCategory(VLUCHTELINGEN);
					Intent d = new Intent(ListCategoriesActivity.this, CategoryVluchtelingenhulpActivity.class);
					startActivity(d);
					break;
				case 4:
					NieuwsOverzichtActivity ranknew5 = new NieuwsOverzichtActivity();
					int newRank5 = ranknew5.getRankingDieren();
					newRank5+=1;
					ranknew5.setRankingDieren(newRank5);
					ranknew5.setRank();
					Globals.getInstance().setCategory(ZIEKTES);
					Intent e = new Intent(ListCategoriesActivity.this, CategoryZiektenEnAandoeningenActivity.class);
					startActivity(e);
					break;
				case 5:
					NieuwsOverzichtActivity ranknew6 = new NieuwsOverzichtActivity();
					int newRank6 = ranknew6.getRankingDieren();
					newRank6+=1;
					ranknew6.setRankingDieren(newRank6);
					ranknew6.setRank();
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