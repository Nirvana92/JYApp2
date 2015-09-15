package com.hf.energy;

import com.hf.energy.adater.OilAdapter;
import com.hf.energy.widget.utils.PopupWindowHelper;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.PopupWindow;

public class TabYoupingManagerActivity extends Activity implements OnClickListener, OnItemClickListener{

	private PopupWindow queryPopup;
	private ListView lv;
	private OilAdapter adapter;
	
	 @Override  
	 public void onCreate(Bundle savedInstanceState) {  
	      super.onCreate(savedInstanceState);  
	      setContentView(R.layout.act_oil_manager);
	      initPopup();
	      lv = (ListView) findViewById(R.id.lv);
	      adapter = new OilAdapter(this);
	      lv.setAdapter(adapter);
	      lv.setOnItemClickListener(this);
	      
	      findViewById(R.id.btnBack).setOnClickListener(this);
	      findViewById(R.id.btnQuery).setOnClickListener(this);
	 }

	private void initPopup() {
		queryPopup = PopupWindowHelper.getPopupWindow(this, R.layout.popup_oil_price_query, false);
		queryPopup.getContentView().findViewById(R.id.btnQuery).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				queryPopup.dismiss();
			}
		});
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.btnBack:
			finish();
			break;
		case R.id.btnQuery:
			queryPopup.showAtLocation(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
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
