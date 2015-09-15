package com.hf.energy.fragment;

import com.hf.energy.R;
import com.hf.energy.adater.CustomerAccountAdapter;
import com.hf.energy.adater.CustomerChuYouLogAdapter;
import com.hf.energy.adater.CustomerTiYouLogAdapter;
import com.hf.energy.event.CustomerQueryButtonClickEvent;
import com.hf.energy.widget.utils.PopupWindowHelper;

import de.greenrobot.event.EventBus;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class CustomerAccountDetailTiYouLogFragment extends Fragment implements OnItemClickListener {

	private ListView lv;
	private CustomerTiYouLogAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frag_account_detail_listview, null);
		
		lv = (ListView) view.findViewById(R.id.lv);
		adapter = new CustomerTiYouLogAdapter(getActivity());
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(this);
		
		return view;
	}


	@Override
	public void onDestroy() {
		super.onDestroy();
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		adapter.setExpand(arg2);
	}

	
}
