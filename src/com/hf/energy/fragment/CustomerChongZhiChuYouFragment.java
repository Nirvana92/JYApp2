package com.hf.energy.fragment;

import com.hf.energy.R;
import com.hf.energy.adater.CustomerAdapter;
import com.hf.energy.bean.IHasQueryButton;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class CustomerChongZhiChuYouFragment extends Fragment implements IHasQueryButton {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frag_customer_chongzhichuyou, null);
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

}
