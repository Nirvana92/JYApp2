package com.hf.energy;

import com.hf.energy.adater.CustomerSubCardAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class CustomerSubCardActivity extends Activity implements OnClickListener, OnItemClickListener{

	private ListView lv;
	private CustomerSubCardAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_customer_sub_card);
		lv = (ListView) findViewById(R.id.lv);
		adapter = new CustomerSubCardAdapter(this);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(this);
		findViewById(R.id.btnBack).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnBack:
			finish();
			break;

		default:
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		adapter.setExpand(arg2);
	}
	
}
