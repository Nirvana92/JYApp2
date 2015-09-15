package com.hf.energy.adater;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.hf.energy.R;
import com.hf.energy.bean.ChuYouLog;
import com.hf.energy.bean.SubCard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CustomerSubCardAdapter extends BaseAdapter{

	
	private class ViewHolder{
		TextView subCard;
		TextView userName;
		TextView userId;
		TextView carId;

		ImageView arrow;
		View second;
	}
	
	private LayoutInflater inflater;
	private int layoutId;
	private List<SubCard> cards;
	private int expandIndex = -1;
	
	public CustomerSubCardAdapter(Context context){
		inflater = LayoutInflater.from(context);
		layoutId =R.layout.list_sub_card_item;
		initDatas();
	}
	
	private void initDatas(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		cards = new ArrayList<SubCard>();
		for (int i = 0; i < 30; i++) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			SubCard card = new SubCard("客户姓名"+(i+1), "卡号"+(i+1), "身份证号"+(i+1), "车牌号"+(i+1));
			cards.add(card);
		}
	}

	@Override
	public int getCount() {
		return cards.size();
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
		SubCard card = cards.get(arg0);
		ViewHolder holder = null;
		if(convertView==null){
			holder = new ViewHolder();
			convertView = inflater.inflate(layoutId, arg2,false);
			convertView.setTag(holder);
			
			holder.subCard = (TextView) convertView.findViewById(R.id.tvCardId);
			holder.userName = (TextView) convertView.findViewById(R.id.tvUserName);
			holder.userId = (TextView) convertView.findViewById(R.id.tvUserID);
			holder.carId = (TextView) convertView.findViewById(R.id.tvCarId);
			holder.second = convertView.findViewById(R.id.listSecondView);
			holder.arrow = (ImageView) convertView.findViewById(R.id.imgArrow);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.subCard.setText(card.getCardId());
		holder.userName.setText(card.getName());
		holder.carId.setText(card.getCarId());
		holder.userId.setText(card.getUserId());
		
		if(expandIndex==arg0){
			holder.second.setVisibility(holder.second.getVisibility()==View.VISIBLE?View.GONE:View.VISIBLE);
		}else{
			holder.second.setVisibility(View.GONE);
		}
		
		holder.arrow.setSelected(holder.second.getVisibility()==View.VISIBLE);
		
		return convertView;
	}

	public void setExpand(int index) {
		expandIndex = index;
		notifyDataSetChanged();
	}
	
}
