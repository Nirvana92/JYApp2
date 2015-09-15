package com.hf.energy.adater;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.hf.energy.R;
import com.hf.energy.bean.ChuYouLog;
import com.hf.energy.bean.SubCard;
import com.hf.energy.widget.utils.PopupWindowHelper;

import android.R.raw;
import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Button;

public class CustomerSubCardTransferAdapter extends BaseAdapter implements OnClickListener{

	private Context ctx;
	private PopupWindow transferInPopup;
	private PopupWindow transferOutPopup;
	
	private class ViewHolder{
		TextView subCard;
		TextView userName;
		TextView userId;
		TextView carId;
		TextView money;
		ImageView arrow;
		View second;
		View btnIn;
		View btnOut;
	}
	
	private LayoutInflater inflater;
	private int layoutId;
	private List<SubCard> cards;
	private int expandIndex = -1;
	
	public CustomerSubCardTransferAdapter(Context context){
		ctx = context;
		inflater = LayoutInflater.from(context);
		layoutId =R.layout.list_sub_card_transfer_item;
		initDatas();
		initPopup();
	}
	
	private void initPopup() {
		transferInPopup = PopupWindowHelper.getPopupWindow((Activity) ctx,  R.layout.popup_customer_sub_card_transfer,false);
		transferOutPopup = PopupWindowHelper.getPopupWindow((Activity) ctx, R.layout.popup_customer_sub_card_transfer,false);
		
		((TextView)transferOutPopup.getContentView().findViewById(R.id.tvPopupTitle)).setText("子卡转出信息");
		((TextView)transferOutPopup.getContentView().findViewById(R.id.tvTransferLabel)).setText("转出金额");
		((Button)transferOutPopup.getContentView().findViewById(R.id.btnTransfer)).setText("确定转出");
		
		((Button)transferOutPopup.getContentView().findViewById(R.id.btnTransfer)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				transferOutPopup.dismiss();
			}
		});
		
		((Button)transferInPopup.getContentView().findViewById(R.id.btnTransfer)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				transferInPopup.dismiss();
			}
		});
	}
	
	private void fillPopupData(SubCard card,PopupWindow popupWindow){
		EditText editCardId = (EditText) popupWindow.getContentView().findViewById(R.id.tvCardId);
		EditText editUserName = (EditText) popupWindow.getContentView().findViewById(R.id.tvUserName);
	
		EditText editCarId = (EditText) popupWindow.getContentView().findViewById(R.id.tvCarId);
		EditText editMoney = (EditText) popupWindow.getContentView().findViewById(R.id.tvMoney);
		EditText editTransferMoney = (EditText) popupWindow.getContentView().findViewById(R.id.tvTransferMoney);
		
		editCardId.setText(card.getCardId());
		
		editUserName.setText(card.getName());
		editCarId.setText(card.getCarId());
		editMoney.setText(card.getMoney());
		editTransferMoney.setText("");
	}

	private void initDatas(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		cards = new ArrayList<SubCard>();
		for (int i = 0; i < 30; i++) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			SubCard card = new SubCard("卡主姓名"+(i+1), "卡号"+(i+1), "身份证号"+(i+1), "车牌号"+(i+1));
			card.setMoney((i+150)+"");
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
			holder.money = (TextView) convertView.findViewById(R.id.tvMoney);
			holder.btnIn = convertView.findViewById(R.id.btnTransferIn);
			holder.btnOut = convertView.findViewById(R.id.btnTransferOut);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.btnIn.setTag(card);
		holder.btnOut.setTag(card);
		holder.btnIn.setOnClickListener(this);
		holder.btnOut.setOnClickListener(this);
		holder.subCard.setText(card.getCardId());
		holder.userName.setText(card.getName());
		holder.carId.setText(card.getCarId());
		holder.userId.setText(card.getUserId());
		holder.money.setText(card.getMoney());
		
		
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

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnTransferIn:
			fillPopupData((SubCard) v.getTag(), transferInPopup);
			transferInPopup.showAtLocation(((Activity)ctx).getWindow().getDecorView(), Gravity.CENTER, 0, 0);
			break;
		case R.id.btnTransferOut:
			fillPopupData((SubCard) v.getTag(), transferOutPopup);
			transferOutPopup.showAtLocation(((Activity)ctx).getWindow().getDecorView(), Gravity.CENTER, 0, 0);
			break;
		default:
			break;
		}
	}
	
}
