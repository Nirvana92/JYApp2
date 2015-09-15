package com.hf.energy;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

/**
 * @author Nirvana
 *  
 * 登录界面
 */
public class MainActivity extends Activity implements OnClickListener {
	
	private EditText userNameET;
	private EditText passWordET;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.act_main);
		findViewById(R.id.btnLogin).setOnClickListener(this);
		findViewById(R.id.btnRegister).setOnClickListener(this);
	}

	public void init() {
		userNameET = (EditText) this.findViewById(R.id.username);
		passWordET = (EditText) this.findViewById(R.id.password);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.btnLogin:
			gotoMain();
			break;
		case R.id.btnRegister:
			gotoRegister();
			break;
		default:
			break;
		}
	}

	/*
	 * 跳转到主界面
	 */
	private void gotoMain() {

		//String username = userNameET.getText().toString().trim();
		//String password = passWordET.getText().toString().trim();
		
		//判断用户正确性
		
		Intent it = new Intent(this, MainTabActivity.class);
		startActivity(it);
	}

	/*
	 * 跳转到注册界面
	 */
	private void gotoRegister() {
		Intent it = new Intent(this, RegisterActivity.class);
		startActivity(it);
	}

}
