package com.hf.energy.adater;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.hf.energy.R;


import com.hf.energy.bean.Oil;
import com.hf.energy.widget.utils.PopupWindowHelper;

import android.app.Activity;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class OilAdapter extends BaseAdapter{

	private Context ctx;
	private PopupWindow queryPopup;
	
	private class ViewHolder{
		TextView code;
		
		TextView price;
	
		TextView date;
	}
	
	private LayoutInflater inflater;
	private int layoutId;
	private List<Oil> oils;
	private int expandIndex = -1;
	
	public OilAdapter(Context context){
		ctx = context;
		inflater = LayoutInflater.from(context);
		layoutId =R.layout.list_oil_item;
		initDatas();
		initPopup();
	}
	
	private void initPopup() {
		queryPopup = PopupWindowHelper.getPopupWindow((Activity) ctx,  R.layout.popup_oil_price_query,false);
		queryPopup.getContentView().findViewById(R.id.btnQuery).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				queryPopup.dismiss();
			}
		});
	}

	private void initDatas(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		oils = new ArrayList<Oil>();
		for (int i = 0; i < 30; i++) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			Oil oil = new Oil(""+(i+1)+"#", ""+(i+1),""+(i+1), "¥"+(i+1), format.format(calendar.getTime()));
			oils.add(oil);
		}
	}

	@Override
	public int getCount() {
		return oils.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int arg0, View convertView, ViewGroup arg2) {
		Oil oil = oils.get(arg0);
		ViewHolder holder = null;
		if(convertView==null){
			holder = new ViewHolder();
			convertView = inflater.inflate(layoutId, arg2,false);
			convertView.setTag(holder);
			
			holder.code = (TextView) convertView.findViewById(R.id.tvOilId);
			holder.date = (TextView) convertView.findViewById(R.id.tvOilDate);
			holder.price = (TextView) convertView.findViewById(R.id.tvOilPrice);
		
		
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
	
	
		holder.code.setText(oil.getCode())   ;
	
		holder.date.setText(oil.getDate())   ;
		holder.price.setText(oil.getPrice()) ;
		

		return convertView;
	}

	public void setExpand(int index) {
		
	}
}
