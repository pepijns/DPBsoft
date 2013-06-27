package com.dpbsoft.app;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.facebook.Session;
import com.facebook.widget.WebDialog;

public class CharityInfoActivity extends Activity implements OnClickListener {

	private int charity;
	
	Globals globalState = new Globals();

	private String homeURL;
	private String donateURL;
	private String logoURL;
	private static final List<String> PERMISSIONS = Arrays.asList("publish_actions");
	private static final int REAUTH_ACTIVITY_CODE = 100;
	
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
	
	private static final int WNF_INFO = R.string.wnf_info;
	private static final int WSPA_INFO = R.string.wspa_info;
	private static final int SOPHIA_KATTENBOND_INFO = R.string.kattenbond_info;
	private static final int SOPHIA_VEREENIGING_INFO = R.string.vereeniging_info;
	private static final int STICHTING_DIERENLOT_INFO = R.string.dierenlot_info;
	private static final int BROOKE_HOSPITAL_INFO = R.string.brooke_info;
	private static final int GREENPEACE_INFO = R.string.greenpeace_info;
	private static final int NATUURMONUMENTEN_INFO = R.string.natuurmonumenten_info;
	private static final int MILIEUDEFENSIE_INFO = R.string.milieudefensie_info;
	private static final int UNICEF_INFO = R.string.unicef_info;
	private static final int LEGER_DES_HEILS_INFO = R.string.legerdesheils_info;
	private static final int TERRE_DES_HOMMES_INFO = R.string.terredeshommes_info;
	private static final int SOS_KINDERDORPEN_INFO = R.string.soskinderdorpen_info;
	private static final int PLAN_NEDERLAND_INFO = R.string.plannederland_info;
	private static final int VLUCHTELINGENWERK_NEDERLAND_INFO = R.string.vluchtelingenwerknederland_info;
	private static final int WAR_CHILD_INFO = R.string.warchild_info;
	private static final int KWF_KANKERBESTRIJDING_INFO = R.string.kwfkankerbestrijding_info;
	private static final int REUMAFONDS_INFO = R.string.reumafonds_info;
	private static final int LONGFONDS_INFO = R.string.longfonds_info;
	private static final int ALZHEIMER_NEDERLAND_INFO = R.string.alzheimernederland_info;
	private static final int NATIONAAL_EPILEPSIE_FONDS_INFO = R.string.nationaalepilepsiefonds_info;
	private static final int HARTSTICHTING_INFO = R.string.hartstichting_info;
	private static final int VERENIGING_DE_ZONNEBLOEM_INFO = R.string.verenigingdezonnebloem_info;
	private static final int KIKA_INFO = R.string.kika_info;
	private static final int MAAG_LEVER_DARM_STICHTING_INFO = R.string.maagleverdarmstichting_info;
	private static final int FIGHT_CANCER_INFO = R.string.fightcancer_info;
	private static final int DIABETES_FONDS_INFO = R.string.diabetesfonds_info;
	private static final int NSGK_INFO = R.string.nsgk_info;
	private static final int STOP_AIDS_NOW_INFO = R.string.stopaidsnow_info;
	private static final int NIERSTICHTING_INFO = R.string.nierstichting_info;
	private static final int AMNESTY_INTERNATIONAL_INFO = R.string.amnestyinternational_info;
	private static final int CLINICLOWNS_NEDERLAND_INFO = R.string.cliniclownsnederland_info;
	
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
				logoURL = "http://www.bezigebijen.nl/images/bruiloft/wnf.jpg";
				break;
			case WSPA: 
				tvTitle.setText(WSPA_TITLE);
				tvInfo.setText(WSPA_INFO);
				homeURL = "http://www.wspa.nl/";
				donateURL = "http://www.wspa-doneren.nl/wspa/?kclid=ZGFpc3ljb24g";
				logoURL = "http://www.animalsunited.nl/wp-content/uploads/2013/03/wspa.jpg";
				break;
			case SOPHIA_KATTENBOND:
				tvTitle.setText(SOPHIA_KATTENBOND_TITLE);
				tvInfo.setText(SOPHIA_KATTENBOND_INFO);
				homeURL = "http://www.sophia-vereeniging.nl/";
				donateURL = "http://www.sophia-vereeniging.nl/en/pages/help-mee/doneren/donatie-voor-dieren.html";
				logoURL = "http://www.dierenasiel-bommelerwaard.nl/cms/userfiles/Logo%20SKB.jpg";
				break;
			case SOPHIA_VEREENIGING:
				tvTitle.setText(SOPHIA_VEREENIGING_TITLE);
				tvInfo.setText(SOPHIA_VEREENIGING_INFO);
				homeURL = "http://www.sophia-vereeniging.nl/";
				donateURL = "http://www.sophia-vereeniging.nl/en/pages/help-mee/doneren/donatie-voor-dieren.html";
				logoURL = "http://i.imgur.com/o6yPhOg.png";
				break;
			case STICHTING_DIERENLOT:
				tvTitle.setText(STICHTING_DIERENLOT_TITLE);
				tvInfo.setText(STICHTING_DIERENLOT_INFO);
				homeURL = "https://www.dier.nu/";
				donateURL = "https://www.dier.nu/help-mee/6/Help-mee";
				logoURL = "http://www.dierenasielbrammelo.nl/wp-content/uploads/Stichting-dierenlot.jpg";
				break;
			case BROOKE_HOSPITAL:
				tvTitle.setText(BROOKE_HOSPITAL_TITLE);
				tvInfo.setText(BROOKE_HOSPITAL_INFO);
				homeURL = "http://www.greenpeace.nl/";
				donateURL = "http://www.greenpeace.nl/word-donateur/04895/";
				logoURL = "http://media-cache-ec2.pinimg.com/avatars/BrookeHospital-12_600.jpg";
				break;
			case GREENPEACE:
				tvTitle.setText(GREENPEACE_TITLE);
				tvInfo.setText(GREENPEACE_INFO);
				homeURL = "http://www.wspa.nl/";
				donateURL = "http://www.wspa-doneren.nl/wspa/?kclid=ZGFpc3ljb24g";
				logoURL = "http://www.mecnijmegen.nl/bestanden/afbeeldingen/afvalarrangement/organisaties/greenpeace_logo.jpg";
				break;
			case NATUURMONUMENTEN:
				tvTitle.setText(NATUURMONUMENTEN_TITLE);
				tvInfo.setText(NATUURMONUMENTEN_INFO);
				homeURL = "http://www.natuurmonumenten.nl/";
				donateURL = "http://www.natuurmonumenten.nl/doe-een-gift";
				logoURL = "http://www.arknature.nl/files/2013/04/natuurmonumenten.jpg";
				break;
			case MILIEUDEFENSIE:
				tvTitle.setText(MILIEUDEFENSIE_TITLE);
				tvInfo.setText(MILIEUDEFENSIE_INFO);
				homeURL = "https://www.milieudefensie.nl/";
				donateURL = "https://doneren.milieudefensie.nl/idoo/iwh/geefnu.php?aid=1";
				logoURL = "http://www.biobasedeconomy.nl/wp-content/uploads/2011/09/Logo-Milieudefensie.jpg";
				break;
			case UNICEF:
				tvTitle.setText(UNICEF_TITLE);
				tvInfo.setText(UNICEF_INFO);
				homeURL = "https://www.http://www.unicef.nl/";
				donateURL = "https://www.unicef.nl/wat-kun-jij-doen/word-donateur/";
				logoURL = "http://www.animaatjes.nl/plaatjes/u/unicef/animaatjes-unicef-01021.gif";
				break;
			case LEGER_DES_HEILS:
				tvTitle.setText(LEGER_DES_HEILS_TITLE);
				tvInfo.setText(LEGER_DES_HEILS_INFO);
				homeURL = "http://www.legerdesheils.nl/";
				donateURL = "http://www.legerdesheils.nl/doneren";
				logoURL = "http://www.camerainstallatie.nl/sites/default/files/lrg_leger_des_heils.gif";
				break;
			case TERRE_DES_HOMMES:
				tvTitle.setText(TERRE_DES_HOMMES_TITLE);
				tvInfo.setText(TERRE_DES_HOMMES_INFO);
				homeURL = "http://www.terredeshommes.nl/";
				donateURL = "http://www.terredeshommes.nl/doneren/";
				logoURL = "http://www.battleofconcepts.nl/html/FCKEditor_Upload/image/TdH.jpg";
				break;
			case SOS_KINDERDORPEN:
				tvTitle.setText(SOS_KINDERDORPEN_TITLE);
				tvInfo.setText(SOS_KINDERDORPEN_INFO);
				homeURL = "http://www.soskinderdorpen.nl/";
				donateURL = "https://doneer.soskinderdorpen.nl";
				logoURL = "http://www.vacatureboard.com/image/data/logos/91be623824e20ffe57c8284851d62993.jpg";
				break;
			case PLAN_NEDERLAND:
				tvTitle.setText(PLAN_NEDERLAND_TITLE);
				tvInfo.setText(PLAN_NEDERLAND_INFO);
				homeURL = "https://www.plannederland.nl/";
				donateURL = "https://www.plannederland.nl/doe-een-donatie";
				logoURL = "http://www.cbf.nl//Uploaded_files/Logos/PlanNederland.jpg";
				break;
			case VLUCHTELINGENWERK_NEDERLAND :
				tvTitle.setText(VLUCHTELINGENWERK_NEDERLAND_TITLE);
				tvInfo.setText(VLUCHTELINGENWERK_NEDERLAND_INFO);
				homeURL = "http://www.vluchtelingenwerk.nl/";
				donateURL = "http://www.vluchtelingenwerk.nl/steun-ons/steun-ons-werk.php";
				logoURL = "http://www.perssupport.nl/apssite/binaries/content/gallery/afbeeldingen/persberichten/2011/06/15/vwn_logo2010_nljpg";
				break;
			case WAR_CHILD :
				tvTitle.setText(WAR_CHILD_TITLE);
				tvInfo.setText(WAR_CHILD_INFO);
				homeURL = "http://www.warchild.nl/";
				donateURL = "https://www.warchild.nl/doneer";
				logoURL = "http://www.animaatjes.nl/plaatjes/w/war-child/animaatjes-war-child-41248.jpg";
				break;
			case KWF_KANKERBESTRIJDING :
				tvTitle.setText(KWF_KANKERBESTRIJDING_TITLE);
				tvInfo.setText(KWF_KANKERBESTRIJDING_INFO);
				homeURL = "http://www.kwfkankerbestrijding.nl/";
				donateURL = "http://helpen.kwfkankerbestrijding.nl/helpen-als-particulier/Pages/ik-geef-geld.aspx";
				logoURL = "http://perssupport.nl/apssite/binaries/content/gallery/afbeeldingen/persberichten/2013/02/01/kwf_rgb_nl_100%25jpg";
				break;
			case LONGFONDS :
				tvTitle.setText(LONGFONDS_TITLE);
				tvInfo.setText(LONGFONDS_INFO);
				homeURL = "https://www.longfonds.nl/";
				donateURL = "https://www.longfonds.nl/steun-ons";
				logoURL = "http://www.cbf.nl//Uploaded_files/Logos/Longfonds.jpg";
				break;
			case REUMAFONDS :
				tvTitle.setText(REUMAFONDS_TITLE);
				tvInfo.setText(REUMAFONDS_INFO);
				homeURL = "http://www.reumafonds.nl/";
				donateURL = "http://www.reumafonds.nl/help-mee/help-met-geld";
				logoURL = "http://www.dorpsblad.com/wp-content/gallery/logos/reumafonds.jpg";
				break;
			case ALZHEIMER_NEDERLAND :
				tvTitle.setText(ALZHEIMER_NEDERLAND_TITLE);
				tvInfo.setText(ALZHEIMER_NEDERLAND_INFO);
				homeURL = "http://www.alzheimer-nederland.nl/";
				donateURL = "http://www.alzheimer-nederland.nl/steun-ons-werk.aspx";
				logoURL = "http://i.imgur.com/XwuwG5E.png";
				break;
			case NATIONAAL_EPILEPSIE_FONDS :
				tvTitle.setText(NATIONAAL_EPILEPSIE_FONDS_TITLE);
				tvInfo.setText(NATIONAAL_EPILEPSIE_FONDS_INFO);
				homeURL = "http://www.epilepsiefonds.nl/";
				donateURL = "http://www.epilepsiefonds.nl/u_kunt_helpen/donaties";
				logoURL = "http://www.epilepsie.nl/afbeeldingen/logo_nef_450px_breed_en_70px_hoog.jpg";
				break;
			case HARTSTICHTING :
				tvTitle.setText(HARTSTICHTING_TITLE);
				tvInfo.setText(HARTSTICHTING_INFO);
				homeURL = "http://www.hartstichting.nl/";
				donateURL = "http://www.hartstichting.nl/help_mee/geld_geven/";
				logoURL = "http://wms-nassau.netfacet.nl/data/website/content/logo-nederlandse-hartstichting_nieuw.jpg";
				break;
			case VERENIGING_DE_ZONNEBLOEM :
				tvTitle.setText(VERENIGING_DE_ZONNEBLOEM_TITLE);
				tvInfo.setText(VERENIGING_DE_ZONNEBLOEM_INFO);
				homeURL = "https://www.zonnebloem.nl/";
				donateURL = "https://www.zonnebloem.nl/zb/doneer-nu";
				logoURL = "http://waarnaartoe.nl/images/mainimages/6419.jpg?1249481494";
				break;
			case KIKA :
				tvTitle.setText(KIKA_TITLE);
				tvInfo.setText(KIKA_INFO);
				homeURL = "http://www.kika.nl/";
				donateURL = "http://kika.nl/index.php?option=com_kikadonatie";
				logoURL = "http://www.radiowesterkwartier.com/wp-content/uploads/2013/02/kika.gif";
				break;
			case MAAG_LEVER_DARM_STICHTING :
				tvTitle.setText(MAAG_LEVER_DARM_STICHTING_TITLE);
				tvInfo.setText(MAAG_LEVER_DARM_STICHTING_INFO);
				homeURL = "http://www.mlds.nl/";
				donateURL = "http://www.mlds.nl/help-de-mlds/";
				logoURL = "http://doneren.mlds.nl/ppimg/IMG000203";
				break;
			case FIGHT_CANCER :
				tvTitle.setText(FIGHT_CANCER_TITLE);
				tvInfo.setText(FIGHT_CANCER_INFO);
				homeURL = "http://www.fightcancer.nl/";
				donateURL = "http://www.fightcancer.nl/doneren/Pages/Online%20doneren.aspx";
				logoURL = "http://www.bezigebijen.nl/images/bruiloft/wnf.jpg";
				break;
			case DIABETES_FONDS :
				tvTitle.setText(DIABETES_FONDS_TITLE);
				tvInfo.setText(DIABETES_FONDS_INFO);
				homeURL = "http://www.diabetesfonds.nl/";
				donateURL = "http://www.diabetesfonds.nl/overzicht/steunen";
				logoURL = "http://www.newbdenhaag.nl/sites/default/files/Fight%20Cancer_0.jpg";
				break;
			case NSGK:
				tvTitle.setText(NSGK_TITLE);
				tvInfo.setText(NSGK_INFO);
				homeURL = "http://www.nsgk.nl/";
				donateURL = "http://www.nsgk.nl/kan-ik-helpen/word-donateur";
				logoURL = "http://perssupport.nl/apssite/binaries/content/gallery/afbeeldingen/persberichten/2012/08/25/logo_nsgk+for+webjpg";
				break;
			case STOP_AIDS_NOW :
				tvTitle.setText(STOP_AIDS_NOW_TITLE);
				tvInfo.setText(STOP_AIDS_NOW_INFO);
				homeURL = "http://www.stopaidsnow.nl/";
				donateURL = "https://www.stopaidsnow.nl/steun_ons";
				logoURL = "http://ikkominactie.nl/image/11/K3MoOTAwKQ%3D%3D/stop-aids-now.jpg";
				break;
			case NIERSTICHTING :
				tvTitle.setText(NIERSTICHTING_TITLE);
				tvInfo.setText(NIERSTICHTING_INFO);
				homeURL = "http://www.nierstichting.nl/";
				donateURL = "https://doneer.nierstichting.nl/ik-wil-doneren";
				logoURL = "http://www.goededoelen.nl/images/uploads/logos/09NIERLOGO_P_PMS.jpg";
				break;
			case AMNESTY_INTERNATIONAL :
				tvTitle.setText(AMNESTY_INTERNATIONAL_TITLE);
				tvInfo.setText(AMNESTY_INTERNATIONAL_INFO);
				homeURL = "http://www.amnesty.nl/";
				donateURL = "https://www.amnesty.nl/steun-amnesty/word-lid";
				logoURL = "http://www.cbf.nl//Uploaded_files/Logos/AmnestyInternational.jpg";
				break;
			case CLINICLOWNS_NEDERLAND :
				tvTitle.setText(CLINICLOWNS_NEDERLAND_TITLE);
				tvInfo.setText(CLINICLOWNS_NEDERLAND_INFO);
				homeURL = "http://www.cliniclowns.nl/";
				donateURL = "http://www.cliniclowns.nl/doneer/";
				logoURL = "http://www.grootklimmendaal.nl/cms/bestanden/imagecache/9377a076-a8d7-4031-883a-92e7368c61ea.jpg";
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
    	case R.id.shareToFacebook:
	    	share(homeURL, logoURL);
		}
	}
	
	private void share(String homeURL, String logoURL) {
		
		requestPublishPermissions(Session.getActiveSession());
		TextView tvTitle =(TextView)findViewById(R.id.tvTitleInfo);
		Bundle bundle = new Bundle();
		bundle.putString("caption", "Ik steun dit goede doel.");
		bundle.putString("description", "Gedeeld via Charitybook.");
		bundle.putString("link", homeURL);
		bundle.putString("name", ""+tvTitle.getText());
		bundle.putString("picture", ""+logoURL);
		new WebDialog.FeedDialogBuilder(CharityInfoActivity.this, Session.getActiveSession(), bundle).build().show();
	}
	
	private void requestPublishPermissions(Session session) {
	    if (session != null) {
	        Session.NewPermissionsRequest newPermissionsRequest = new Session.NewPermissionsRequest(this, PERMISSIONS).setRequestCode(REAUTH_ACTIVITY_CODE);
	        session.requestNewPublishPermissions(newPermissionsRequest);
	    }
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);
	    switch(requestCode) {
	    default:
	        if(Session.getActiveSession() != null) 
	            Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
	        break;
	    }
	}
}
