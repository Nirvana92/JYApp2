package com.hf.energy.adater;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.hf.energy.R;
import com.hf.energy.bean.CustomerAccount;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomerAccountAdapter extends BaseAdapter{

	private static Random random = new Random();
	private List<CustomerAccount> datas;
	private LayoutInflater inflater;
	private int expandIndex = -1;
	
	private class ViewHolder{
		TextView card;
		TextView money;
		View     second;
	}
	
	public CustomerAccountAdapter(Context context){
		inflater = LayoutInflater.from(context);
		initDatas();
	}
	
	
	private void initDatas(){
		datas = new ArrayList<CustomerAccount>();
		CustomerAccount a1 = new CustomerAccount("454789456211", "100487");
		CustomerAccount a2 = new CustomerAccount("458787454561", "554400");
		CustomerAccount a3 = new CustomerAccount("698781124541","4781124");
		CustomerAccount a4 = new CustomerAccount("997855454564"	, "354");
		CustomerAccount[] as = new CustomerAccount[]{a1,a2,a3,a4};
		for (int i = 0; i < 25; i++) {
			int index = random.nextInt(as.length);
			CustomerAccount account = as[index];
			datas.add(account);
		}
	}
	
	public void setExpand(int index){
		this.expandIndex = index;
		notifyDataSetChanged();
	}
	
	@Override
	public int getCount() {
		return datas.size();
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

		CustomerAccount account = datas.get(arg0);
		
		ViewHolder holder = null;
		
		if(convertView==null){
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.list_customer_account_info, arg2,false);
			convertView.setTag(holder);
			
			holder.card = (TextView) convertView.findViewById(R.id.tvAccountID);
			holder.money = (TextView) convertView.findViewById(R.id.tvAccountMoney);
			holder.second = convertView.findViewById(R.id.listSecondView);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		if(expandIndex==arg0){
			holder.second.setVisibility(holder.second.getVisibility()==View.VISIBLE?View.GONE:View.VISIBLE);
		}else {
			holder.second.setVisibility(View.GONE);
		}
		
		holder.card.setText(account.getCard());
		holder.money.setText(account.getMoney());
		
		return convertView;
	}

}
