package com.activity2;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.beans.PassWordBeans;
import com.clcp.R;
import com.compenent.SQliteCPZS;
import com.system.GlobleParam;
import com.tool.SqliteHelperOrm.SQLiteOrmHelper;
import com.tool.SqliteHelperOrm.SQLiteOrmSDContext;

public class APassWordMana extends Activity
{
	private EditText ed_password,ed_conform,ed_password_old;
	private Button btn_sure;
	private TextView tv__password_old;
	
	private boolean flag_passwordExist;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.apasswordmana);
		ed_password=(EditText)findViewById(R.id.apasswordmana_ed_password);
		ed_conform=(EditText)findViewById(R.id.apasswordmana_ed_conform);
		ed_password_old=(EditText)findViewById(R.id.apasswordmana_ed_old);
		tv__password_old=(TextView)findViewById(R.id.apasswordmana_tv_old);
		btn_sure=(Button)findViewById(R.id.apasswordmana_btn_sure);
		btn_sure.setOnClickListener(sureClickListener);
	}
	
	@Override
	protected void onResume()
	{
		// TODO Auto-generated method stub
		super.onResume();
		flag_passwordExist=IsPassWordExist();
		if(!flag_passwordExist)
		{
			tv__password_old.setVisibility(View.GONE);
			ed_password_old.setVisibility(View.GONE);
		}
			
	}
	
	private OnClickListener sureClickListener=new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			String p=ed_password.getText().toString().trim();
			String c=ed_conform.getText().toString().trim();
			boolean result=false;
			if(flag_passwordExist)
			{
				String o=ed_password_old.getText().toString().trim();
				if(CheckOldPassWord(o))
				{
					if(CheckPassWordVaild(p, c))
					{
						result=UpdateOldPassword(p);
						SQLiteOrmHelper.ToastShowResult(APassWordMana.this, result);
						if(result)
							finish();
					}
					else 
					{
						Toast.makeText(APassWordMana.this, "确认密码输入不一致", Toast.LENGTH_LONG).show();
					} 
				}
				else 
				{
					Toast.makeText(APassWordMana.this, "原始密码不正确", Toast.LENGTH_LONG).show();
				}
			}
			else 
			{
				if(CheckPassWordVaild(p, c))
				{
					result=CreateNewPassword(p);
					SQLiteOrmHelper.ToastShowResult(APassWordMana.this, result);
					if(result)
						finish();
				}
				else 
				{
					Toast.makeText(APassWordMana.this, "确认密码输入不一致", Toast.LENGTH_LONG).show();
				}
			}
			/**修改全局变量,可根据实际修改*/
			if(result)
			{
				SQLiteOrmSDContext context=new SQLiteOrmSDContext(APassWordMana.this, GlobleParam.Create());
				SQliteCPZS cpzs=new SQliteCPZS(context);
				PassWordBeans beans=cpzs.getREPassWordBeans().queryForAll().get(0);
				GlobleParam.Create().setPsBeans(beans);
				cpzs.close();
			}
				
		}
	};

	private boolean CreateNewPassword(String p)
	{
		boolean result=false;
		PassWordBeans beans=new PassWordBeans();
		beans.setPasswrod(p);
		SQLiteOrmSDContext context=new SQLiteOrmSDContext(this, GlobleParam.Create());
		SQliteCPZS cpzs=new SQliteCPZS(context);
		int r=cpzs.getREPassWordBeans().create(beans);
		if(r!=-1)
			result=true;
		cpzs.close();
		return result;
	}
	
	private boolean UpdateOldPassword(String p)
	{
		boolean result=false;
		SQLiteOrmSDContext context=new SQLiteOrmSDContext(this, GlobleParam.Create());
		SQliteCPZS cpzs=new SQliteCPZS(context);
		PassWordBeans beans=cpzs.getREPassWordBeans().queryForAll().get(0);
		beans.setPasswrod(p);
		int r=cpzs.getREPassWordBeans().update(beans);
		if(r!=-1)
			result=true;
		cpzs.close();
		return result;
	}
	
	
	private boolean IsPassWordExist()
	{
		boolean result=false;
		SQLiteOrmSDContext context=new SQLiteOrmSDContext(this, GlobleParam.Create());
		SQliteCPZS cpzs=new SQliteCPZS(context);
		List<PassWordBeans> list=cpzs.getREPassWordBeans().queryForAll();
		Log.i("demo", "password list size"+list.size());
		if(list.size()!=0)
			result=true;
		cpzs.close();
		return result;
	}
	
	private boolean CheckPassWordVaild(String p,String c)
	{
		boolean result=false;
		if(p.equals(c)&&p.equals("")==false&&c.equals("")==false)
			result=true;
		return result;
	}
	
	private boolean CheckOldPassWord(String o)
	{
		boolean result=false;
		SQLiteOrmSDContext context=new SQLiteOrmSDContext(this, GlobleParam.Create());
		SQliteCPZS cpzs=new SQliteCPZS(context);
		PassWordBeans beans=cpzs.getREPassWordBeans().queryForAll().get(0);
		if(beans.getPasswrod().equals(o))
			result=true;
		cpzs.close();
		return result;
	}
	
	
}
