package com.hf.energy.fragment;

import java.lang.reflect.Field;

import com.hf.energy.R;
import com.hf.energy.adater.CustomerAccountDetailPagerAdapter;
import com.hf.energy.bean.IHasQueryButton;
import com.hf.energy.event.CustomerQueryButtonClickEvent;
import com.hf.energy.widget.utils.PopupWindowHelper;

import de.greenrobot.event.EventBus;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;


public class CustomerAccountDetailFragment extends Fragment implements IHasQueryButton, OnPageChangeListener{

	private CustomerAccountDetailPagerAdapter adapter;
	private ViewPager pager;
	private ViewGroup tabHeaderContainer;
	private PopupWindow popupQuery;
	private View view;
	
	private class SetAdapterTask extends AsyncTask<Void, Void, Void> {
        protected Void doInBackground(Void... params) {
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            if(adapter != null) pager.setAdapter(adapter);
        }
    }
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EventBus.getDefault().register(this);
	}

	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		
		 view = inflater.inflate(R.layout.frag_account_detail_query, container,false);
		tabHeaderContainer = (ViewGroup) view.findViewById(R.id.tabHeaderContainer);
		pager = (ViewPager) view.findViewById(R.id.pager);
		adapter = new CustomerAccountDetailPagerAdapter(getChildFragmentManager());
		pager.setAdapter(adapter);
		pager.setOffscreenPageLimit(adapter.getCount());
		pager.setOnPageChangeListener(this);
		highLightCurrentTab(0);
		initPopup();
		
		
		return view;
	}
	
	@Override
	public void onDetach() {
	super.onDetach();
	try {
	    Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
	    childFragmentManager.setAccessible(true);
	    childFragmentManager.set(this, null);

	} catch (NoSuchFieldException e) {
	    throw new RuntimeException(e);
	} catch (IllegalAccessException e) {
	    throw new RuntimeException(e);
	}
	}
	
	

	private void initPopup() {
		popupQuery = PopupWindowHelper.getPopupWindow(getActivity().getParent(), R.layout.popup_customer_account_detail_query, false);
		popupQuery.getContentView().findViewById(R.id.btnQuery).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				popupQuery.dismiss();
			}
		});
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}
	
	public void onEvent(CustomerQueryButtonClickEvent event){
		Fragment fragment = event.getTarget();
		if(fragment==null) return;
		if(fragment instanceof CustomerAccountDetailFragment){
			popupQuery.showAtLocation(getActivity().getWindow().getDecorView(),Gravity.CENTER, 0, 0);
		}
	}
	
	
	@Override
	public Boolean hasQueryButton() {
		return true;
	}


	@Override
	public void onPageScrollStateChanged(int arg0) {
		
	}


	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		
	}


	@Override
	public void onPageSelected(int arg0) {
		highLightCurrentTab(arg0);
	}
	
	private void highLightCurrentTab(int index){
		for (int i = 0; i < tabHeaderContainer.getChildCount(); i++) {
			View child = tabHeaderContainer.getChildAt(i);
			child.setSelected(i==index);
		}
	}

}
