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
	static final String[] DIERENCHARITIES = new String[] { "WNF", "WSPA", "Sophia Kattenbond", "Sophia Vereeniging", "Stichting DierenLot", "Brooke Hospital"};
	static final String[] NATUURCHARITIES = new String[] { "Greenpeace", "Natuurmonumenten", "Milieudefensie"};
	//static final String[] NOODHULPCHARITIES = new String[] { "Charity 1", "Charity 2", "Charity 3", "Charity 4", "Charity 5"};
	static final String[] ONTWIKKELINGSCHARITIES = new String[] { "UNICEF", "Het Leger des Heils", "Terre des Hommes", "SOS Kinderdorpen", "Plan Nederland"};
	static final String[] VLUCHTELINGENCHARITIES = new String[] { "VluchtelingenWerk Nederland", "War Child"};
	static final String[] ZIEKTESCHARITIES = new String[] { "KWF Kankerbestrijding", "Longfonds", "Reumafonds", "Alzheimer Nederland", "Nationaal Epilepsie Fonds", "Hartstichting", "Vereniging de Zonnebloem", "KiKa", "Maag Lever Darm Stichting", "Fight Cancer", "Diabetes Fonds", "NSGK", "STOP AIDS NOW!", "Nierstichting"};
	static final String[] OVERIGECHARITIES = new String[] { "Amnesty International", "CliniClowns Nederland", "Independer.nl"};
	
	//categories
	private static final int DIEREN = 1;
	private static final int NATUUR = 2;
	private static final int ONTWIKKELING = 3;
	private static final int VLUCHTELINGEN = 4;
	private static final int ZIEKTES = 5;
	private static final int OVERIG = 6;
	
	//charities
	private static final int WNF = 1;
	private static final int WSPA = 2;
	private static final int SOPHIA_KATTENBOND = 3;
	private static final int SOPHIA_VEREENIGING = 4;
	private static final int STICHTING_DIERENLOT = 5;
	private static final int BROOKE_HOSPITAL = 6;
	private static final int GREENPEACE = 7;
	private static final int NATUURMONUMENTEN = 8;
	private static final int MILIEUDEFENSIE = 9;
	private static final int UNICEF = 10;
	private static final int LEGER_DES_HEILS = 11;
	private static final int TERRE_DES_HOMMES = 12;
	private static final int SOS_KINDERDORPEN = 13;
	private static final int PLAN_NEDERLAND = 14;
	private static final int VLUCHTELINGENWERK_NEDERLAND = 15;
	private static final int WAR_CHILD = 16;
	private static final int KWF_KANKERBESTRIJDING = 17;
	private static final int LONGFONDS = 18;
	private static final int REUMAFONDS = 19;
	private static final int ALZHEIMER_NEDERLAND = 20;
	private static final int NATIONAAL_EPILEPSIE_FONDS = 21;
	private static final int HARTSTICHTING = 22;
	private static final int VERENIGING_DE_ZONNEBLOEM = 23;
	private static final int KIKA = 24;
	private static final int MAAG_LEVER_DARM_STICHTING = 25;
	private static final int FIGHT_CANCER = 26;
	private static final int DIABETES_FONDS = 27;
	private static final int NSGK = 28;
	private static final int STOP_AIDS_NOW = 29;
	private static final int NIERSTICHTING = 30;
	private static final int AMNESTY_INTERNATIONAL = 31;
	private static final int CLINICLOWNS_NEDERLAND = 32;
	private static final int INDEPENDER_NL = 33;

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
		case DIEREN:
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
				    		a.putExtra("charity", WNF);
							startActivity(a);
							break;
						case 1: //WSPA
							Intent b = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		b.putExtra("charity", WSPA);
							startActivity(b);
							break;
						case 2: //Sophia Kattenbond
							Intent c = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		c.putExtra("charity", SOPHIA_KATTENBOND);
							startActivity(c);
							break;
						case 3: //Sophia Vereeniging
							Intent d = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		d.putExtra("charity", SOPHIA_VEREENIGING);
							startActivity(d);
							break;
						case 4: //Stichting DierenLot
							Intent e = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		e.putExtra("charity", STICHTING_DIERENLOT);
							startActivity(e);
							break;
						case 5: //Brooke Hospital
							Intent f = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		f.putExtra("charity", BROOKE_HOSPITAL);
							startActivity(f);
							break;
					}
				}
			});
			break;
		case NATUUR:
			setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_list_categories,NATUURCHARITIES));
			ListView natuurListView = getListView();
			natuurListView.setTextFilterEnabled(true);
			/* knoppen */
			natuurListView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					//welke knop?
					switch (position){
						case 0: //Greenpeace
							Intent a = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		a.putExtra("charity", GREENPEACE);
							startActivity(a);
							break;
						case 1: //Natuurmonumenten
							Intent b = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		b.putExtra("charity", NATUURMONUMENTEN);
							startActivity(b);
							break;
						case 2: //Milieudefensie
							Intent c = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		c.putExtra("charity", MILIEUDEFENSIE);
							startActivity(c);
							break;
					}
				}
			});
			break;
		case ONTWIKKELING: 
			setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_list_categories,ONTWIKKELINGSCHARITIES));
			ListView ontwikkelingListView = getListView();
			ontwikkelingListView.setTextFilterEnabled(true);
			/* knoppen */
			ontwikkelingListView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					//welke knop?
					switch (position){
						case 0: //UNICEF
							Intent a = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		a.putExtra("charity", UNICEF);
							startActivity(a);
							break;
						case 1: //Het Leger des Heils
							Intent b = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		b.putExtra("charity", LEGER_DES_HEILS);
							startActivity(b);
							break;
						case 2: //Terre des Hommes
							Intent c = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		c.putExtra("charity", TERRE_DES_HOMMES);
							startActivity(c);
							break;
						case 3: //SOS Kinderdorpen
							Intent d = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		d.putExtra("charity", SOS_KINDERDORPEN);
							startActivity(d);
							break;
						case 4: //Plan Nederland
							Intent e = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		e.putExtra("charity", PLAN_NEDERLAND);
							startActivity(e);
							break;
					}
				}
			});
			break;
		case VLUCHTELINGEN:
			setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_list_categories,VLUCHTELINGENCHARITIES));
			ListView vluchtelingenListView = getListView();
			vluchtelingenListView.setTextFilterEnabled(true);
			/* knoppen */
			vluchtelingenListView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					//welke knop?
					switch (position){
						case 0: //VluchtelingenWerk Nederland
							Intent a = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		a.putExtra("charity", VLUCHTELINGENWERK_NEDERLAND);
							startActivity(a);
							break;
						case 1: //War Child
							Intent b = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		b.putExtra("charity", WAR_CHILD);
							startActivity(b);
							break;
					}
				}
			});
			break;
		case ZIEKTES: 
			setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_list_categories,ZIEKTESCHARITIES));
			ListView ziektesListView = getListView();
			ziektesListView.setTextFilterEnabled(true);
			/* knoppen */
			ziektesListView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					//welke knop?
					switch (position){
						case 0: //KWF Kankerbestrijding
							Intent a = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		a.putExtra("charity", KWF_KANKERBESTRIJDING);
							startActivity(a);
							break;
						case 1: //Longfonds
							Intent b = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		b.putExtra("charity", LONGFONDS);
							startActivity(b);
							break;
						case 2: //Reumafonds
							Intent c = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		c.putExtra("charity", REUMAFONDS);
							startActivity(c);
							break;
						case 3: //Alzheimer Nederland
							Intent d = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		d.putExtra("charity", ALZHEIMER_NEDERLAND);
							startActivity(d);
							break;
						case 4: //Nationaal Epilepsie Fonds
							Intent e = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		e.putExtra("charity", NATIONAAL_EPILEPSIE_FONDS);
							startActivity(e);
							break;
						case 5: //Hartsticthing
							Intent f = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		f.putExtra("charity", HARTSTICHTING);
							startActivity(f);
							break;
						case 6: // Vereniging de Zonnebloem
							Intent g = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		g.putExtra("charity", VERENIGING_DE_ZONNEBLOEM);
							startActivity(g);
							break;
						case 7: // KiKa
							Intent h = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		h.putExtra("charity", KIKA);
							startActivity(h);
							break;
						case 8: // Maag Lever Darm Stichting
							Intent i = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		i.putExtra("charity", MAAG_LEVER_DARM_STICHTING);
							startActivity(i);
							break;
						case 9: // Fight Cancer
							Intent j = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		j.putExtra("charity", FIGHT_CANCER);
							startActivity(j);
							break;
						case 10: // Diabetes Fonds
							Intent k = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		k.putExtra("charity", DIABETES_FONDS);
							startActivity(k);
							break;
						case 11: // NSGK
							Intent l = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		l.putExtra("charity", NSGK);
							startActivity(l);
							break;
						case 12: // STOP AIDS NOW!
							Intent m = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		m.putExtra("charity", STOP_AIDS_NOW);
							startActivity(m);
							break;
						case 13: //  Nierstichting
							Intent n = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		n.putExtra("charity", NIERSTICHTING);
							startActivity(n);
							break;
					}
				}
			});
			break;
		case OVERIG: 
			setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_list_categories,OVERIGECHARITIES));
			ListView overigListView = getListView();
			overigListView.setTextFilterEnabled(true);
			/* knoppen */
			overigListView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					//welke knop?
					switch (position){
						case 0: //Amnesty International
							Intent a = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		a.putExtra("charity", AMNESTY_INTERNATIONAL);
							startActivity(a);
							break;
						case 1: //CliniClowns Nederland
							Intent b = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		b.putExtra("charity", CLINICLOWNS_NEDERLAND);
							startActivity(b);
							break;
						case 2: //Independer.nl
							Intent c = new Intent(ListCharitiesActivity.this, CharityMainActivity.class);
				    		c.putExtra("charity", INDEPENDER_NL);
							startActivity(c);
							break;
					}
				}
			});
			break;
		}
	}

}
