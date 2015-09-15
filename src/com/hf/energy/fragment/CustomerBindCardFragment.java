package com.hf.energy.fragment;

import com.hf.energy.CustomerSubCardActivity;
import com.hf.energy.R;
import com.hf.energy.adater.CustomerAdapter;
import com.hf.energy.bean.IHasQueryButton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;

public class CustomerBindCardFragment extends Fragment implements IHasQueryButton, OnClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frag_customer_bind_card, null);
		view.findViewById(R.id.btnZhiKaRead).setOnClickListener(this);
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
		case R.id.btnZhiKaRead:
			Intent it = new Intent(getActivity(),CustomerSubCardActivity.class);
			getActivity().startActivity(it);
			break;

		default:
			break;
		}
	}

}
