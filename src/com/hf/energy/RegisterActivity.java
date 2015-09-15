package com.hf.energy;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

/**
 * @author Nirvana
 * 
 * 注册界面
 */
public class RegisterActivity extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_register);
		
		findViewById(R.id.btnRegister).setOnClickListener(this);
		findViewById(R.id.btnBack).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.btnRegister:
			Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
			finish();
			break;
		case R.id.btnBack:
			finish();
			break;
		default:
			break;
		}
	}
}
