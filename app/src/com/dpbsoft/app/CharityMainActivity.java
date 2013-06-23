package com.dpbsoft.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class CharityMainActivity extends Activity implements OnClickListener {
	
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
	
	//view strings
	private static final int WNF_TITLE = R.string.wnf_title;
	private static final int WSPA_TITLE = R.string.wspa_title;
	private static final int SOPHIA_KATTENBOND_TITLE = R.string.kattenbond_title;
	private static final int SOPHIA_VEREENIGING_TITLE = R.string.vereeniging_title;
	private static final int STICHTING_DIERENLOT_TITLE = R.string.dierenlot_title;
	private static final int BROOKE_HOSPITAL_TITLE = R.string.brooke_title;
	private static final int GREENPEACE_TITLE = R.string.greenpeace_title;
	private static final int NATUURMONUMENTEN_TITLE = R.string.natuurmonumenten_title;
	private static final int MILIEUDEFENSIE_TITLE = R.string.milieudefensie_title;
	private static final int UNICEF_TITLE = R.string.unicef_title;
	private static final int LEGER_DES_HEILS_TITLE = R.string.legerdesheils_title;
	private static final int TERRE_DES_HOMMES_TITLE = R.string.terredeshommes_title;
	private static final int SOS_KINDERDORPEN_TITLE = R.string.soskinderdorpen_title;
	private static final int PLAN_NEDERLAND_TITLE = R.string.plannederland_title;
	private static final int VLUCHTELINGENWERK_NEDERLAND_TITLE = R.string.vluchtelingenwerknederland_title;
	private static final int WAR_CHILD_TITLE = R.string.warchild_title;
	private static final int KWF_KANKERBESTRIJDING_TITLE = R.string.kwfkankerbestrijding_title;
	private static final int REUMAFONDS_TITLE = R.string.reumafonds_title;
	private static final int LONGFONDS_TITLE = R.string.longfonds_title;
	private static final int ALZHEIMER_NEDERLAND_TITLE = R.string.alzheimernederland_title;
	private static final int NATIONAAL_EPILEPSIE_FONDS_TITLE = R.string.nationaalepilepsiefonds_title;
	private static final int HARTSTICHTING_TITLE = R.string.hartstichting_title;
	private static final int VERENIGING_DE_ZONNEBLOEM_TITLE = R.string.verenigingdezonnebloem_title;
	private static final int KIKA_TITLE = R.string.kika_title;
	private static final int MAAG_LEVER_DARM_STICHTING_TITLE = R.string.maagleverdarmstichting_title;
	private static final int FIGHT_CANCER_TITLE = R.string.fightcancer_title;
	private static final int DIABETES_FONDS_TITLE = R.string.diabetesfonds_title;
	private static final int NSGK_TITLE = R.string.nsgk_title;
	private static final int STOP_AIDS_NOW_TITLE = R.string.stopaidsnow_title;
	private static final int NIERSTICHTING_TITLE = R.string.nierstichting_title;
	private static final int AMNESTY_INTERNATIONAL_TITLE = R.string.amnestyinternational_title;
	private static final int CLINICLOWNS_NEDERLAND_TITLE = R.string.cliniclownsnederland_title;

	private int charity; //Charity selected in the list
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_charity_main);
		
		Bundle extras = getIntent().getExtras(); 
		if (extras != null) {
		    charity = extras.getInt("charity");
		}
		
		setView();	 
	}
	
	private void setView(){
		TextView tv =(TextView)findViewById(R.id.tvTitleMain); 
		
		switch (charity){
		case WNF:
		    tv.setText(WNF_TITLE);
			break;
		case WSPA:
		    tv.setText(WSPA_TITLE);
			break;
		case SOPHIA_KATTENBOND:
		    tv.setText(SOPHIA_KATTENBOND_TITLE);
			break;
		case SOPHIA_VEREENIGING:
		    tv.setText(SOPHIA_VEREENIGING_TITLE);
			break;
		case STICHTING_DIERENLOT:
		    tv.setText(STICHTING_DIERENLOT_TITLE);
			break;
		case BROOKE_HOSPITAL:
		    tv.setText(BROOKE_HOSPITAL_TITLE);
			break;
		case GREENPEACE:
		    tv.setText(GREENPEACE_TITLE);
			break;
		case NATUURMONUMENTEN:
		    tv.setText(NATUURMONUMENTEN_TITLE);
			break;
		case MILIEUDEFENSIE:
		    tv.setText(MILIEUDEFENSIE_TITLE);
			break;
		case UNICEF:
		    tv.setText(UNICEF_TITLE);
			break;
		case LEGER_DES_HEILS:
		    tv.setText(LEGER_DES_HEILS_TITLE);
			break;
		case TERRE_DES_HOMMES:
		    tv.setText(TERRE_DES_HOMMES_TITLE);
			break;
		case SOS_KINDERDORPEN:
		    tv.setText(SOS_KINDERDORPEN_TITLE);
			break;
		case PLAN_NEDERLAND:
		    tv.setText(PLAN_NEDERLAND_TITLE);
			break;
		case VLUCHTELINGENWERK_NEDERLAND:
		    tv.setText(VLUCHTELINGENWERK_NEDERLAND_TITLE);
			break;
		case WAR_CHILD:
		    tv.setText(WAR_CHILD_TITLE);
			break;
		case KWF_KANKERBESTRIJDING:
		    tv.setText(KWF_KANKERBESTRIJDING_TITLE);
			break;
		case LONGFONDS:
		    tv.setText(LONGFONDS_TITLE);
			break;
		case REUMAFONDS:
		    tv.setText(REUMAFONDS_TITLE);
			break;
		case ALZHEIMER_NEDERLAND:
		    tv.setText(ALZHEIMER_NEDERLAND_TITLE);
			break;
		case NATIONAAL_EPILEPSIE_FONDS:
		    tv.setText(NATIONAAL_EPILEPSIE_FONDS_TITLE);
			break;
		case HARTSTICHTING:
		    tv.setText(HARTSTICHTING_TITLE);
			break;
		case VERENIGING_DE_ZONNEBLOEM:
		    tv.setText(VERENIGING_DE_ZONNEBLOEM_TITLE);
			break;
		case KIKA :
		    tv.setText(KIKA_TITLE);
			break;
		case MAAG_LEVER_DARM_STICHTING:
		    tv.setText(MAAG_LEVER_DARM_STICHTING_TITLE);
			break;
		case FIGHT_CANCER:
		    tv.setText(FIGHT_CANCER_TITLE);
			break;
		case DIABETES_FONDS :
		    tv.setText(DIABETES_FONDS_TITLE);
			break;
		case NSGK :
		    tv.setText(NSGK_TITLE);
			break;
		case STOP_AIDS_NOW  :
		    tv.setText(STOP_AIDS_NOW_TITLE);
			break;
		case NIERSTICHTING  :
		    tv.setText(NIERSTICHTING_TITLE);
			break;
		case AMNESTY_INTERNATIONAL :
		    tv.setText(AMNESTY_INTERNATIONAL_TITLE);
			break;
		case CLINICLOWNS_NEDERLAND :
		    tv.setText(CLINICLOWNS_NEDERLAND_TITLE);
			break;
		}
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()) {
        	case R.id.btnInfo:
		    	Intent a = new Intent(CharityMainActivity.this, CharityInfoActivity.class);
	    		a.putExtra("charity",charity);
		    	startActivity(a);
        		break;
        	case R.id.btnSteun:
		    	Intent b = new Intent(CharityMainActivity.this, CharitySupportActivity.class);
	    		b.putExtra("charity",charity);
		    	startActivity(b);
        		break;
		}
	}
}