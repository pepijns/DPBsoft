package com.dpbsoft.app;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
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
	
	//view strings
	private static final int WNF_TITLE = R.string.wnf_title;
	private static final int WSPA_TITLE = R.string.wspa_title;
	private static final int WNF_STEUN = R.string.wnf_steun;
	private static final int WSPA_STEUN = R.string.wspa_steun;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_charity_support);
		
		charity = globalState.getCharity();

		setView(charity);
	}
	
	private void setView(int charity){
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
		}
	}

	@Override
	public void onClick(View v) {
		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(donateURL));
 		startActivity(i);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.charity_support, menu);
		return true;
	}

}
