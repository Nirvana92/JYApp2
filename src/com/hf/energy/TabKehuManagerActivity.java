package com.hf.energy;

import com.hf.energy.bean.IHasQueryButton;
import com.hf.energy.event.CustomerQueryButtonClickEvent;
import com.hf.energy.fragment.CustomerAccountDetailFragment;
import com.hf.energy.fragment.CustomerAccountManagerFragment;
import com.hf.energy.fragment.CustomerBindCardFragment;
import com.hf.energy.fragment.CustomerTransferCardFragment;
import de.greenrobot.event.EventBus;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

public class TabKehuManagerActivity extends FragmentActivity implements
		OnClickListener {
	
	private PopupWindow popupTop;
	private Button btnHeaderCenter;
	private View btnHeaderRight;
	private CustomerAccountManagerFragment customerAccountManagerFragment;
	private CustomerAccountDetailFragment customerAccountDetailFragment;
	private CustomerBindCardFragment customerBindCardFragment;
	private CustomerTransferCardFragment customerTransferCardFragment;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_tab_customer);
		
		btnHeaderRight = findViewById(R.id.btnHeaderRight);
		btnHeaderCenter = (Button) findViewById(R.id.btnHeaderCenter);
		findViewById(R.id.btnBack).setOnClickListener(this);
		btnHeaderCenter.setOnClickListener(this);
		btnHeaderRight.setOnClickListener(this);
		
		initPopup();
		
		replaceFragment(getFragment(0));
	}
	
	private void replaceFragment(Fragment fragment) {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragmentContainer, fragment).commit();
		if (fragment instanceof IHasQueryButton) {
			IHasQueryButton iHasQueryButton = (IHasQueryButton) fragment;
			btnHeaderRight
					.setVisibility(iHasQueryButton.hasQueryButton() ? View.VISIBLE
							: View.GONE);
			btnHeaderRight.setTag(fragment);
		} else {
			btnHeaderRight.setVisibility(View.GONE);
			btnHeaderRight.setTag(null);
		}
	}

	private void initPopup() {
		popupTop = getPopupWindow(R.layout.popup_customer_options, true);
		ViewGroup view = (ViewGroup) popupTop.getContentView();
		int index = 0;
		for (int i = 0; i < view.getChildCount(); i++) {
			View child = view.getChildAt(i);
			if (child.getVisibility() == View.GONE)
				continue;
			if (index == 0) {
				child.setSelected(true);
				TextView tv = (TextView) child;
				btnHeaderCenter.setText(tv.getText() + "◢");
			}
			child.setTag(index);
			child.setOnClickListener(onTopPopupItemClick);
			index++;
		}
	}

	private View.OnClickListener onTopPopupItemClick = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v.isSelected())
				return;
			Integer index = (Integer) v.getTag();
			TextView tv = (TextView) v;
			ViewGroup view = (ViewGroup) popupTop.getContentView();
			for (int i = 0; i < view.getChildCount(); i++) {
				View child = view.getChildAt(i);
				child.setSelected(false);
			}
			tv.setSelected(true);
			btnHeaderCenter.setText(tv.getText() + "◢");
			popupTop.dismiss();
			Fragment fragment = getFragment(index);
			if (fragment != null) {
				replaceFragment(fragment);
			}
		}
	};

	private Fragment getFragment(int index) {
		Fragment fragment = null;
		switch (index) {
		
		case 0:
			if (customerAccountDetailFragment == null) {
				customerAccountDetailFragment = new CustomerAccountDetailFragment();
			}
			fragment = customerAccountDetailFragment;
			break;
		case 1:
			if (customerAccountManagerFragment == null) {
				customerAccountManagerFragment = new CustomerAccountManagerFragment();
			}
			fragment = customerAccountManagerFragment;
			break;
		case 2:
			if (customerBindCardFragment == null) {
				customerBindCardFragment = new CustomerBindCardFragment();
			}
			fragment = customerBindCardFragment;
			break;
		case 3:
			if (customerTransferCardFragment == null) {
				customerTransferCardFragment = new CustomerTransferCardFragment();
			}
			fragment = customerTransferCardFragment;
			break;
		default:
			break;
		}
		return fragment;
	}

	private PopupWindow getPopupWindow(int layoutId, Boolean wrapContent) {
		PopupWindow popupWindow = new PopupWindow(getParent());
		View view = getLayoutInflater().inflate(layoutId, null);
		popupWindow.setContentView(view);
		int width = wrapContent ? LayoutParams.WRAP_CONTENT
				: LayoutParams.MATCH_PARENT;
		popupWindow.setWidth(width);
		popupWindow.setHeight(width);
		popupWindow.setFocusable(true);
		popupWindow.setOutsideTouchable(true);
		popupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
		ColorDrawable dw = new ColorDrawable(0x00000000);
		popupWindow.setBackgroundDrawable(dw);
		return popupWindow;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnBack:
			finish();
			break;
		case R.id.btnHeaderCenter:
			int width = v.getWidth();
			popupTop.setWidth(width);
			popupTop.showAsDropDown(v, 0, 10);
			break;
		case R.id.btnHeaderRight:
			if (v.getTag() != null) {
				EventBus.getDefault()
						.post(new CustomerQueryButtonClickEvent((Fragment) v
								.getTag()));
			}
			break;
		default:
			break;
		}
	}

}
