package com.hf.energy.fragment;


import com.hf.energy.R;
import com.hf.energy.adater.CustomerSubCardTransferAdapter;
import com.hf.energy.bean.IHasQueryButton;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class CustomerTransferCardFragment extends Fragment implements IHasQueryButton, OnClickListener, OnItemClickListener {

	private ListView lv;
	private CustomerSubCardTransferAdapter adapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frag_customer_transfer_card, null);
		lv  = (ListView) view.findViewById(R.id.lv);
		adapter = new CustomerSubCardTransferAdapter(getActivity());
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(this);
		return view;
	}

	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}


	@Override
	public Boolean hasQueryButton() {
		return false;
	}


	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		default:
			break;
		}
	}


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		adapter.setExpand(arg2);
	}

}
