package com.hf.energy.adater;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.hf.energy.R;
import com.hf.energy.bean.TiYouLog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CustomerTiYouLogAdapter extends BaseAdapter{

	private class ViewHolder{
		TextView order;
		TextView date;
		TextView address;
		TextView tiyouLiang;
		TextView yuer;
		ImageView arrow;
		View second;
	}
	
	private LayoutInflater inflater;
	private int layoutId;
	private List<TiYouLog> logs;
	private int expandIndex = -1;
	
	public CustomerTiYouLogAdapter(Context context){
		inflater = LayoutInflater.from(context);
		layoutId =R.layout.list_customer_tiyou_log;
		initDatas();
	}
	
	private void initDatas(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		logs = new ArrayList<TiYouLog>();
		for (int i = 0; i < 30; i++) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			TiYouLog log = new TiYouLog((1567897121+i)+"", format.format(calendar.getTime()), "网点"+(i+1), (100+i)+"", (100-i)+"");
			logs.add(log);
		}
	}

	@Override
	public int getCount() {
		return logs.size();
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
		TiYouLog log = logs.get(arg0);
		ViewHolder holder = null;
		if(convertView==null){
			holder = new ViewHolder();
			convertView = inflater.inflate(layoutId, arg2,false);
			convertView.setTag(holder);
			
			holder.address = (TextView) convertView.findViewById(R.id.tvAddress);
			holder.date = (TextView) convertView.findViewById(R.id.tvDate);
			holder.tiyouLiang = (TextView) convertView.findViewById(R.id.tvTiyouliang);
			holder.order = (TextView) convertView.findViewById(R.id.tvOrder);
			holder.yuer = (TextView) convertView.findViewById(R.id.tvYuer);
			holder.second = convertView.findViewById(R.id.listSecondView);
			holder.arrow = (ImageView) convertView.findViewById(R.id.imgArrow);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.address.setText(log.getAddress());
		holder.date.setText(log.getDate());
		holder.tiyouLiang.setText(log.getTiyouliang());
		holder.order.setText(log.getOrderId());
		holder.yuer.setText(log.getYuer());
		
		if(expandIndex==arg0){
			holder.second.setVisibility(holder.second.getVisibility()==View.VISIBLE?View.GONE:View.VISIBLE);
		}else{
			holder.second.setVisibility(View.GONE);
		}
		
		holder.arrow.setSelected(holder.second.getVisibility()==View.VISIBLE);
		
		return convertView;
	}

	public void setExpand(int arg2) {
		expandIndex = arg2;
		notifyDataSetChanged();
	}
	
}
