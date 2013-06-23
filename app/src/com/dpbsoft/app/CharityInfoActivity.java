package com.dpbsoft.app;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class CharityInfoActivity extends Activity implements OnClickListener {

	private int charity;
	
	Globals globalState = new Globals();

	private String homeURL;

	private String donateURL;
	
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
	private static final int WNF_INFO = R.string.wnf_info;
	private static final int WSPA_INFO = R.string.wspa_info;
	private static final int SOPHIA_KATTENBOND_INFO = R.string.kattenbond_info;
	private static final int SOPHIA_VEREENIGING_INFO = R.string.vereeniging_info;
	private static final int STICHTING_DIERENLOT_INFO = R.string.dierenlot_info;
	private static final int BROOKE_HOSPITAL_INFO = R.string.brooke_info;
	private static final int GREENPEACE_INFO = R.string.greenpeace_info;
	private static final int NATUURMONUMENTEN_INFO = R.string.natuurmonumenten_info;
	private static final int MILIEUDEFENSIE_INFO = R.string.milieudefensie_info;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_charity_info);
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    charity = extras.getInt("charity");
		}

		setView();
	}
	
	private void setView(){
		TextView tvTitle =(TextView)findViewById(R.id.tvTitleInfo);
		TextView tvInfo =(TextView)findViewById(R.id.tvInfo);
		
		switch (charity){
			case WNF: 
				tvTitle.setText(WNF_TITLE);
				tvInfo.setText(WNF_INFO);
				homeURL = "http://www.wnf.nl/";
				donateURL = "https://www.wnf.nl/nl/hoe_kan_ik_helpen/giften/";
				break;
			case WSPA: 
				tvTitle.setText(WSPA_TITLE);
				tvInfo.setText(WSPA_INFO);
				homeURL = "http://www.wspa.nl/";
				donateURL = "http://www.wspa-doneren.nl/wspa/?kclid=ZGFpc3ljb24g";
				break;
			case SOPHIA_KATTENBOND:
				tvTitle.setText(SOPHIA_KATTENBOND_TITLE);
				tvInfo.setText(SOPHIA_KATTENBOND_INFO);
				homeURL = "http://www.sophia-vereeniging.nl/";
				donateURL = "http://www.sophia-vereeniging.nl/en/pages/help-mee/doneren/donatie-voor-dieren.html";
				break;
			case SOPHIA_VEREENIGING:
				tvTitle.setText(SOPHIA_VEREENIGING_TITLE);
				tvInfo.setText(SOPHIA_VEREENIGING_INFO);
				homeURL = "http://www.sophia-vereeniging.nl/";
				donateURL = "http://www.sophia-vereeniging.nl/en/pages/help-mee/doneren/donatie-voor-dieren.html";
				break;
			case STICHTING_DIERENLOT:
				tvTitle.setText(STICHTING_DIERENLOT_TITLE);
				tvInfo.setText(STICHTING_DIERENLOT_INFO);
				homeURL = "https://www.dier.nu/";
				donateURL = "https://www.dier.nu/help-mee/6/Help-mee";
				break;
			case BROOKE_HOSPITAL:
				tvTitle.setText(BROOKE_HOSPITAL_TITLE);
				tvInfo.setText(BROOKE_HOSPITAL_INFO);
				homeURL = "http://www.greenpeace.nl/";
				donateURL = "http://www.greenpeace.nl/word-donateur/04895/";
				break;
			case GREENPEACE:
				tvTitle.setText(GREENPEACE_TITLE);
				tvInfo.setText(GREENPEACE_INFO);
				homeURL = "http://www.wspa.nl/";
				donateURL = "http://www.wspa-doneren.nl/wspa/?kclid=ZGFpc3ljb24g";
				break;
			case NATUURMONUMENTEN:
				tvTitle.setText(NATUURMONUMENTEN_TITLE);
				tvInfo.setText(NATUURMONUMENTEN_INFO);
				homeURL = "http://www.natuurmonumenten.nl/";
				donateURL = "http://www.natuurmonumenten.nl/doe-een-gift";
				break;
			case MILIEUDEFENSIE:
				tvTitle.setText(MILIEUDEFENSIE_TITLE);
				tvInfo.setText(MILIEUDEFENSIE_INFO);
				homeURL = "https://www.milieudefensie.nl/";
				donateURL = "https://doneren.milieudefensie.nl/idoo/iwh/geefnu.php?aid=1";
				break;
		}
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
    	case R.id.tvDonate:
    		Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse(donateURL));
    		startActivity(a);
    		break;
    	case R.id.tvURL:
    		Intent b = new Intent(Intent.ACTION_VIEW, Uri.parse(homeURL));
    		startActivity(b);
    		break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.charity_info, menu);
		return true;
	}

}
