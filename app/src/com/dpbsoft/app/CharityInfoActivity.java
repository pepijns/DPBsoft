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
	
	//view strings
	private static final int WNF_TITLE = R.string.wnf_title;
	private static final int WSPA_TITLE = R.string.wspa_title;
	private static final int WNF_INFO = R.string.wnf_info;
	private static final int WSPA_INFO = R.string.wspa_info;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_charity_info);
		
		charity = globalState.getCharity();

		setView(charity);
	}
	
	private void setView(int charity){
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
