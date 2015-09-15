package com.hf.energy.fragment;

import android.app.Dialog;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.hf.energy.R;
import com.hf.energy.adater.CustomerAccountAdapter;
import com.hf.energy.bean.IHasQueryButton;
import com.hf.energy.event.CustomerQueryButtonClickEvent;
import com.hf.energy.widget.utils.PopupWindowHelper;

import de.greenrobot.event.EventBus;


public class CustomerAccountManagerFragment extends Fragment implements OnItemClickListener , IHasQueryButton, OnClickListener{

	private ListView lv;
	private CustomerAccountAdapter adapter;
	private PopupWindow popupQuery;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EventBus.getDefault().register(this);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frag_customer_account_manager, null);
		
		lv = (ListView) view.findViewById(R.id.lv);
		adapter = new CustomerAccountAdapter(getActivity());
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(this);
		
		initPopup();
		
		return view;
	}

	private void initPopup() {
		popupQuery = PopupWindowHelper.getPopupWindow(getActivity().getParent(), R.layout.popup_customer_account_manager_query, false);
		popupQuery.getContentView().findViewById(R.id.btnQuery).setOnClickListener(this);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		adapter.setExpand(arg2);
	}

	public void onEvent(CustomerQueryButtonClickEvent event){
		Fragment fragment = event.getTarget();
		if(fragment==null) return;
		if(fragment instanceof CustomerAccountManagerFragment){
			popupQuery.showAtLocation(getActivity().getWindow().getDecorView(),Gravity.CENTER, 0, 0);
		}
	}

	@Override
	public Boolean hasQueryButton() {
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnQuery:
			popupQuery.dismiss();
			break;

		default:
			break;
		}
	}

}
