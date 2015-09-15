package com.hf.energy.adater;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.hf.energy.R;
import com.hf.energy.bean.Customer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomerAdapter extends BaseAdapter{

	private static Random random = new Random();
	private List<Customer> datas;
	private LayoutInflater inflater;
	
	private class ViewHolder{
		TextView name;
		TextView phone;
		TextView idCard;
	}
	
	public CustomerAdapter(Context context){
		inflater = LayoutInflater.from(context);
		initDatas();
	}
	
	private void initDatas(){
		datas = new ArrayList<Customer>();
		Customer c1 = new Customer("张三","13247871451","360103198402156213");
		Customer c2 = new Customer("李四","15247876751","120123198972156984");
		Customer c3 = new Customer("王五","19847871251","120123195272132418");
		Customer[] customers = new Customer[]{ c1,c2,c3};
		
		for (int i = 0; i < 20; i++) {
			int index = random.nextInt(3);
			datas.add(customers[index]);
		}
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
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
		Customer c = datas.get(arg0);
		ViewHolder holder = null;
		if(convertView==null){
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.list_customer_query_info, arg2,false);
			convertView.setTag(holder);
			
			holder.idCard = (TextView) convertView.findViewById(R.id.tvCustomerIDCard);
			holder.name = (TextView) convertView.findViewById(R.id.tvCustomerName);
			holder.phone = (TextView) convertView.findViewById(R.id.tvCutomerPhone);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.idCard.setText(c.getIdCard());
		holder.name.setText(c.getName());
		holder.phone.setText(c.getPhone());
		
		return convertView;
	}
}
