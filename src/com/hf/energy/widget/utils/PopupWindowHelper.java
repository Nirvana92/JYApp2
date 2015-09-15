package com.hf.energy.widget.utils;

import com.hf.energy.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;

public class PopupWindowHelper {

	public static PopupWindow getPopupWindow(Activity act,int layoutId,Boolean wrapContent){
		final PopupWindow popupWindow = new PopupWindow(act);
		View view = act.getLayoutInflater().inflate(layoutId, null);
		popupWindow.setContentView(view);
		int width = wrapContent?LayoutParams.WRAP_CONTENT:LayoutParams.MATCH_PARENT;
		popupWindow.setWidth(width);
		popupWindow.setHeight(width);
		popupWindow.setFocusable(true);
		popupWindow.setOutsideTouchable(true);
		popupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
		ColorDrawable dw = new ColorDrawable(0x00000000);
		popupWindow.setBackgroundDrawable(dw);
		
		
		View wrapper = view.findViewById(R.id.popupWrapper);
		
		if(wrapper!=null){
			wrapper.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					popupWindow.dismiss();
				}
			});
		}
		
		View content = view.findViewById(R.id.popupContent);
		
		if(content!=null){
			content.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					
				}
			});
		}
		
		return popupWindow;
	}
	
}
