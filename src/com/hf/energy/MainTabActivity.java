package com.hf.energy;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.RadioGroup.OnCheckedChangeListener;

@SuppressWarnings("deprecation")
public class MainTabActivity extends TabActivity implements
		OnCheckedChangeListener {
	
	private TabHost tabHost;
	
	private RadioGroup rg;
	
	private Intent itDetail;
	private Intent itYoujia;
	private Intent itCharge;
	private Intent itAccount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.act_main_tab);

		tabHost = getTabHost();

		rg = (RadioGroup) findViewById(R.id.main_tab);
		rg.setOnCheckedChangeListener(this);

		itDetail = new Intent(this, TabDetailActivity.class);
		itAccount = new Intent(this, TabKehuManagerActivity.class);
		itYoujia = new Intent(this, TabYoupingManagerActivity.class);
		itCharge = new Intent(this, TabChargeActivity.class);

		tabHost.addTab(tabHost.newTabSpec("detail").setIndicator("detail")
				.setContent(itDetail));
		tabHost.addTab(tabHost.newTabSpec("account").setIndicator("account")
				.setContent(itAccount));
		tabHost.addTab(tabHost.newTabSpec("charge").setIndicator("charge")
				.setContent(itCharge));
		tabHost.addTab(tabHost.newTabSpec("youjia").setIndicator("youjia")
				.setContent(itYoujia));
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int checkedId) {
		switch (checkedId) {
		case R.id.radioDetail:
			tabHost.setCurrentTabByTag("detail");
			break;
		case R.id.radioYoujia:
			tabHost.setCurrentTabByTag("youjia");
			break;
		case R.id.radioAccount:
			tabHost.setCurrentTabByTag("account");
			break;
		case R.id.radioCharge:
			tabHost.setCurrentTabByTag("charge");
			break;
		default:
			break;
		}
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		return super.dispatchKeyEvent(event);
	}
}
