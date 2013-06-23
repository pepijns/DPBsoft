package com.dpbsoft.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
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
		/*private static final int UNICEF = 10;
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
		private static final int HARTSTICTHING = 22;
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
		private static final int INDEPENDER_NL = 33;*/
	
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.charity_main, menu);
		return true;
	}

	

}
