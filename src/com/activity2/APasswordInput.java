package com.activity2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.clcp.R;

/**
 * 该界面用于密码输入，以dialog形式展示
 * */
public class APasswordInput extends Activity
{
	private Button btn_sure;
	private EditText ed_password;
	
	public static final int APasswordInput_repeat=1000;
	public static final int APasswordInput_request=2000;
	
	public static String password;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.apasswordinput);
		this.setTitle("请输入密码");
		btn_sure=(Button)findViewById(R.id.apasswordinput_btn_sure);
		ed_password=(EditText)findViewById(R.id.apasswordinput_ed_password);
		btn_sure.setOnClickListener(sureClickListener);
	}
	
	private OnClickListener sureClickListener=new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			APasswordInput.password=ed_password.getText().toString().trim();
			Log.i("demo", "apw into click");
			setResult(APasswordInput.APasswordInput_repeat);
			finish();
		}
	};
	
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) 
	{
		return true;
	};
}
