package com.hf.energy.adater;

import java.util.ArrayList;
import java.util.List;

import com.hf.energy.fragment.CustomerAccountDetailChuYouLogFragment;
import com.hf.energy.fragment.CustomerAccountDetailTiYouLogFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class CustomerAccountDetailPagerAdapter extends FragmentPagerAdapter {

	private List<Fragment> fragments;
	
	public CustomerAccountDetailPagerAdapter(FragmentManager fm) {
		super(fm);
		fragments = new ArrayList<Fragment>();
		fragments.add(new CustomerAccountDetailChuYouLogFragment());
		fragments.add(new CustomerAccountDetailTiYouLogFragment());
	}

	@Override
	public Fragment getItem(int arg0) {
		
		return fragments.get(arg0);
	}

	@Override
	public int getCount() {
		
		return fragments.size();
	}
}
