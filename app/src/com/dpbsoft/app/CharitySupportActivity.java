package com.dpbsoft.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class CharitySupportActivity extends Activity implements OnClickListener {

	private int charity;
	
	Globals globalState = new Globals();

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
	
	private static final int WNF_STEUN = R.string.wnf_steun;
	private static final int WSPA_STEUN = R.string.wspa_steun;
	private static final int SOPHIA_KATTENBOND_STEUN = R.string.kattenbond_steun;
	private static final int SOPHIA_VEREENIGING_STEUN = R.string.vereeniging_steun;
	private static final int STICHTING_DIERENLOT_STEUN = R.string.dierenlot_steun;
	private static final int BROOKE_HOSPITAL_STEUN = R.string.brooke_steun;
	private static final int GREENPEACE_STEUN = R.string.greenpeace_steun;
	private static final int NATUURMONUMENTEN_STEUN = R.string.natuurmonumenten_steun;
	private static final int MILIEUDEFENSIE_STEUN = R.string.milieudefensie_steun;
	private static final int UNICEF_STEUN = R.string.unicef_steun;
	private static final int LEGER_DES_HEILS_STEUN = R.string.legerdesheils_steun;
	private static final int TERRE_DES_HOMMES_STEUN = R.string.terredeshommes_steun;
	private static final int SOS_KINDERDORPEN_STEUN = R.string.soskinderdorpen_steun;
	private static final int PLAN_NEDERLAND_STEUN = R.string.plannederland_steun;
	private static final int VLUCHTELINGENWERK_NEDERLAND_STEUN = R.string.vluchtelingenwerknederland_steun;
	private static final int WAR_CHILD_STEUN = R.string.warchild_steun;
	private static final int KWF_KANKERBESTRIJDING_STEUN = R.string.kwfkankerbestrijding_steun;
	private static final int REUMAFONDS_STEUN = R.string.reumafonds_steun;
	private static final int LONGFONDS_STEUN = R.string.longfonds_steun;
	private static final int ALZHEIMER_NEDERLAND_STEUN = R.string.alzheimernederland_steun;
	private static final int NATIONAAL_EPILEPSIE_FONDS_STEUN = R.string.nationaalepilepsiefonds_steun;
	private static final int HARTSTICHTING_STEUN = R.string.hartstichting_steun;
	private static final int VERENIGING_DE_ZONNEBLOEM_STEUN = R.string.verenigingdezonnebloem_steun;
	private static final int KIKA_STEUN = R.string.kika_steun;
	private static final int MAAG_LEVER_DARM_STICHTING_STEUN = R.string.maagleverdarmstichting_steun;
	private static final int FIGHT_CANCER_STEUN = R.string.fightcancer_steun;
	private static final int DIABETES_FONDS_STEUN = R.string.diabetesfonds_steun;
	private static final int NSGK_STEUN = R.string.nsgk_steun;
	private static final int STOP_AIDS_NOW_STEUN = R.string.stopaidsnow_steun;
	private static final int NIERSTICHTING_STEUN = R.string.nierstichting_steun;
	private static final int AMNESTY_INTERNATIONAL_STEUN = R.string.amnestyinternational_steun;
	private static final int CLINICLOWNS_NEDERLAND_STEUN = R.string.cliniclownsnederland_steun;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_charity_support);
		
		Bundle extras = getIntent().getExtras(); 
		if (extras != null) {
		    charity = extras.getInt("charity");
		}

		setView();
	}
	
	private void setView(){
		TextView tvTitle =(TextView)findViewById(R.id.tvTitleSupport);
		TextView tvSupport =(TextView)findViewById(R.id.tvSupport);
		
		switch (charity){
			case WNF: 
				tvTitle.setText(WNF_TITLE);
				tvSupport.setText(WNF_STEUN);
				donateURL = "https://www.wnf.nl/nl/hoe_kan_ik_helpen/giften/";
				break;
			case WSPA: 
				tvTitle.setText(WSPA_TITLE);
				tvSupport.setText(WSPA_STEUN);
				donateURL = "http://www.wspa-doneren.nl/wspa/?kclid=ZGFpc3ljb24g";
				break;
			case SOPHIA_KATTENBOND:
				tvTitle.setText(SOPHIA_KATTENBOND_TITLE);
				tvSupport.setText(SOPHIA_KATTENBOND_STEUN);
				donateURL = "http://www.sophia-vereeniging.nl/en/pages/help-mee/doneren/donatie-voor-dieren.html";
				break;
			case SOPHIA_VEREENIGING:
				tvTitle.setText(SOPHIA_VEREENIGING_TITLE);
				tvSupport.setText(SOPHIA_VEREENIGING_STEUN);
				donateURL = "http://www.sophia-vereeniging.nl/en/pages/help-mee/doneren/donatie-voor-dieren.html";
				break;
			case STICHTING_DIERENLOT:
				tvTitle.setText(STICHTING_DIERENLOT_TITLE);
				tvSupport.setText(STICHTING_DIERENLOT_STEUN);
				donateURL = "https://www.dier.nu/help-mee/6/Help-mee";
				break;
			case BROOKE_HOSPITAL:
				tvTitle.setText(BROOKE_HOSPITAL_TITLE);
				tvSupport.setText(BROOKE_HOSPITAL_STEUN);
				donateURL = "http://www.brooke.nl/hoe-kunt-u-helpen/word-donateur.html";
				break;
			case GREENPEACE:
				tvTitle.setText(GREENPEACE_TITLE);
				tvSupport.setText(GREENPEACE_STEUN);
				donateURL = "http://www.greenpeace.nl/word-donateur/04895/";
				break;
			case NATUURMONUMENTEN:
				tvTitle.setText(NATUURMONUMENTEN_TITLE);
				tvSupport.setText(NATUURMONUMENTEN_STEUN);
				donateURL = "http://www.natuurmonumenten.nl/doe-een-gift";
				break;
			case MILIEUDEFENSIE:
				tvTitle.setText(MILIEUDEFENSIE_TITLE);
				tvSupport.setText(MILIEUDEFENSIE_STEUN);
				donateURL = "https://doneren.milieudefensie.nl/idoo/iwh/geefnu.php?aid=1";
				break;
			case UNICEF:
				tvTitle.setText(UNICEF_TITLE);
				tvSupport.setText(UNICEF_STEUN);
				donateURL = "https://www.unicef.nl/wat-kun-jij-doen/word-donateur/";
				break;
			case LEGER_DES_HEILS:
				tvTitle.setText(LEGER_DES_HEILS_TITLE);
				tvSupport.setText(LEGER_DES_HEILS_STEUN);
				donateURL = "http://www.legerdesheils.nl/doneren";
				break;
			case TERRE_DES_HOMMES:
				tvTitle.setText(TERRE_DES_HOMMES_TITLE);
				tvSupport.setText(TERRE_DES_HOMMES_STEUN);
				donateURL = "http://www.terredeshommes.nl/doneren/";
				break;
			case SOS_KINDERDORPEN:
				tvTitle.setText(SOS_KINDERDORPEN_TITLE);
				tvSupport.setText(SOS_KINDERDORPEN_STEUN);
				donateURL = "https://doneer.soskinderdorpen.nl";
				break;
			case PLAN_NEDERLAND:
				tvTitle.setText(PLAN_NEDERLAND_TITLE);
				tvSupport.setText(PLAN_NEDERLAND_STEUN);
				donateURL = "https://www.plannederland.nl/doe-een-donatie";
				break;
			case VLUCHTELINGENWERK_NEDERLAND:
				tvTitle.setText(VLUCHTELINGENWERK_NEDERLAND_TITLE);
				tvSupport.setText(VLUCHTELINGENWERK_NEDERLAND_STEUN);
				donateURL = "http://www.vluchtelingenwerk.nl/steun-ons/steun-ons-werk.php";
				break;
			case WAR_CHILD:
				tvTitle.setText(WAR_CHILD_TITLE);
				tvSupport.setText(WAR_CHILD_STEUN);
				donateURL = "https://www.warchild.nl/doneer";
				break;
			case KWF_KANKERBESTRIJDING:
				tvTitle.setText(KWF_KANKERBESTRIJDING_TITLE);
				tvSupport.setText(KWF_KANKERBESTRIJDING_STEUN);
				donateURL = "http://helpen.kwfkankerbestrijding.nl/helpen-als-particulier/Pages/ik-geef-geld.aspx";
				break;
			case LONGFONDS:
				tvTitle.setText(LONGFONDS_TITLE);
				tvSupport.setText(LONGFONDS_STEUN);
				donateURL = "https://www.longfonds.nl/steun-ons";
				break;
			case REUMAFONDS:
				tvTitle.setText(REUMAFONDS_TITLE);
				tvSupport.setText(REUMAFONDS_STEUN);
				donateURL = "http://www.reumafonds.nl/help-mee/help-met-geld";
				break;
			case ALZHEIMER_NEDERLAND:
				tvTitle.setText(ALZHEIMER_NEDERLAND_TITLE);
				tvSupport.setText(ALZHEIMER_NEDERLAND_STEUN);
				donateURL = "http://www.alzheimer-nederland.nl/steun-ons-werk.aspx";
				break;
			case NATIONAAL_EPILEPSIE_FONDS:
				tvTitle.setText(NATIONAAL_EPILEPSIE_FONDS_TITLE);
				tvSupport.setText(NATIONAAL_EPILEPSIE_FONDS_STEUN);
				donateURL = "http://www.epilepsiefonds.nl/u_kunt_helpen/donaties";
				break;
			case HARTSTICHTING:
				tvTitle.setText(HARTSTICHTING_TITLE);
				tvSupport.setText(HARTSTICHTING_STEUN);
				donateURL = "http://www.hartstichting.nl/help_mee/geld_geven/";
				break;
			case VERENIGING_DE_ZONNEBLOEM:
				tvTitle.setText(VERENIGING_DE_ZONNEBLOEM_TITLE);
				tvSupport.setText(VERENIGING_DE_ZONNEBLOEM_STEUN);
				donateURL = "https://www.zonnebloem.nl/zb/doneer-nu";
				break;
			case KIKA:
				tvTitle.setText(KIKA_TITLE);
				tvSupport.setText(KIKA_STEUN);
				donateURL = "http://kika.nl/index.php?option=com_kikadonatie";
				break;
			case MAAG_LEVER_DARM_STICHTING:
				tvTitle.setText(MAAG_LEVER_DARM_STICHTING_TITLE);
				tvSupport.setText(MAAG_LEVER_DARM_STICHTING_STEUN);
				donateURL = "http://www.mlds.nl/help-de-mlds/";
				break;
			case FIGHT_CANCER:
				tvTitle.setText(FIGHT_CANCER_TITLE);
				tvSupport.setText(FIGHT_CANCER_STEUN);
				donateURL = "http://www.fightcancer.nl/doneren/Pages/Online%20doneren.aspx";
				break;
			case DIABETES_FONDS :
				tvTitle.setText(DIABETES_FONDS_TITLE);
				tvSupport.setText(DIABETES_FONDS_STEUN);
				donateURL = "http://www.diabetesfonds.nl/overzicht/steunen";
				break;
			case STOP_AIDS_NOW:
				tvTitle.setText(STOP_AIDS_NOW_TITLE);
				tvSupport.setText(STOP_AIDS_NOW_STEUN);
				donateURL = "https://www.stopaidsnow.nl/steun_ons";
				break;
			case NIERSTICHTING:
				tvTitle.setText(NIERSTICHTING_TITLE);
				tvSupport.setText(NIERSTICHTING_STEUN);
				donateURL = "https://doneer.nierstichting.nl/ik-wil-doneren";
				break;
			case AMNESTY_INTERNATIONAL:
				tvTitle.setText(AMNESTY_INTERNATIONAL_TITLE);
				tvSupport.setText(AMNESTY_INTERNATIONAL_STEUN);
				donateURL = "https://www.amnesty.nl/steun-amnesty/word-lid";
				break;
			case CLINICLOWNS_NEDERLAND:
				tvTitle.setText(CLINICLOWNS_NEDERLAND_TITLE);
				tvSupport.setText(CLINICLOWNS_NEDERLAND_STEUN);
				donateURL = "http://www.cliniclowns.nl/doneer/";
				break;
			case NSGK:
				tvTitle.setText(NSGK_TITLE);
				tvSupport.setText(NSGK_STEUN);
				donateURL = "http://www.nsgk.nl/kan-ik-helpen/word-donateur";
				break;
		}
	}

	@Override
	public void onClick(View v) {
		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(donateURL));
 		startActivity(i);		
	}
}
