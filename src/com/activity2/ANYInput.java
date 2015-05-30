package com.activity2;

import java.util.List;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.Beanshelper.NYHelper;
import com.Beanshelper.RecordStateHelper;
import com.beans.NYBeans;
import com.beans.RecordStateBeans;
import com.clcp.R;
import com.compenent.InputNumRangeWatcher;
import com.compenent.InputNumRangeWatcher.CallbackAfterChange;
import com.compenent.SQliteCPZS;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.system.GlobleParam;
import com.system.SystemUtils;
import com.tool.SqliteHelperOrm.SQLiteOrmHelper;
import com.tool.SqliteHelperOrm.SQLiteOrmSDContext;
import com.tool.mydialog.NormalDialog;

/**内业输入的fragment*/
public class ANYInput extends Activity
{
	private Button btn_start,btn_end;
	private TextView tv_start,tv_end;
	private RadioGroup rg_dakai,rg_anshi,rg_geshi;
	private CheckBox cb_anshi;
	private EditText ed_tiqian;
	private ToggleButton tg_islocked;
	
	private NYBeans beans;
	private RecordStateBeans stateBeans;
	
	private boolean Flag_isLocked;
	private boolean Flag_issaved;
	
	public static final int ANYInput_ResetStart=1;
	public static final int ANYInput_ResetEnd=2;
	public static final int ANYInput_Locked=3;
	
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.fnyinput);
		/*绑定控件*/
		btn_start=(Button) this.findViewById(R.id.fnyinput_btn_start);
		btn_end=(Button)this.findViewById(R.id.fnyinput_btn_end);
		tv_start=(TextView)this.findViewById(R.id.fnyinput_tv_start);
		tv_end=(TextView)this.findViewById(R.id.fnyinput_tv_end);
		rg_dakai=(RadioGroup)this.findViewById(R.id.fnyinput_radioGroup_dakai);
		rg_anshi=(RadioGroup)this.findViewById(R.id.fnyinput_radioGroup_anshi);
		rg_geshi=(RadioGroup)this.findViewById(R.id.fnyinput_RadioGroup_geishi);
		cb_anshi=(CheckBox)this.findViewById(R.id.fnying_cb_anshi);
		ed_tiqian=(EditText)this.findViewById(R.id.fnying_ed_tiqian);
		tg_islocked=(ToggleButton)this.findViewById(R.id.fnyinput_toggle_locked);
		/*设置监听*/
		btn_start.setOnClickListener(startclick);
		btn_end.setOnClickListener(endClickListener);
		rg_dakai.setOnCheckedChangeListener(rg_dakaiChangeListener);
		rg_anshi.setOnCheckedChangeListener(rg_anshiChangeListener);
		rg_geshi.setOnCheckedChangeListener(rg_geshiChangeListener);
		cb_anshi.setOnCheckedChangeListener(cb_tiqianChangeListener);
		tg_islocked.setOnCheckedChangeListener(toggle);
		ed_tiqian.addTextChangedListener(new InputNumRangeWatcher(this, ed_tiqian, 0, 10,tiqiancallback));
	}
	
	@Override
	protected void onStart()
	{
		// TODO Auto-generated method stub
		super.onStart();
		/**根据全局playerno设置创建或者回复nybeans*/
		String g_playerno=GlobleParam.Create().getPlayerBeans().getPlayerno();
		if(g_playerno.equals(""))
		{
			Toast.makeText(this, "请选择参赛组别", Toast.LENGTH_LONG).show();
			finish();
		}
		else 
		{
			SQLiteOrmSDContext context=new SQLiteOrmSDContext(this, GlobleParam.Create());
			SQliteCPZS cpzs=new SQliteCPZS(context);
			List<NYBeans> list=cpzs.getRENYBeans().queryForEq("palyerno", g_playerno);
			if(list!=null&&list.size()!=0)//已经有相关记录了
			{
				beans=list.get(0);
			}
			else//没有相关记录 
			{
				beans=new NYBeans();
			}
			List<RecordStateBeans> list2=cpzs.getRERecordStateBeans().queryForEq("playerNO", g_playerno);
			if(list2!=null&&list2.size()!=0)//已经有相关记录了
			{
				stateBeans=list2.get(0);
			}
			else//没有相关记录 
			{
				stateBeans=new RecordStateBeans();
			}
			cpzs.close();
			UpdateUIbyBeans(!Flag_isLocked);//更新UI
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		menu.add(0, 0, 1, "重置开始");
		menu.add(0, 0, 2, "重置结束");
		menu.add(0, 0, 3, "结果保存");
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// TODO Auto-generated method stub
		switch (item.getOrder())
		{
			case 1://重置开始
			{
				Intent intent=new Intent(ANYInput.this, APasswordInput.class);
				startActivityForResult(intent, ANYInput_ResetStart);
			}break;
			case 2://重置结束
			{
				Intent intent=new Intent(ANYInput.this, APasswordInput.class);
				startActivityForResult(intent, ANYInput_ResetEnd);
			}break;
			case 3://项目保存
			{
				Flag_issaved=SaveBeans();
				
			}break;
		}
		return true;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==APasswordInput.APasswordInput_repeat)
		{
			if(GlobleParam.Create().getPsBeans().getPasswrod().equals(APasswordInput.password))
			{
				if(requestCode==ANYInput_ResetStart)
				{
					btn_start.setEnabled(true);
				}
				if(requestCode==ANYInput_ResetEnd)
				{
					btn_end.setEnabled(true);
				}
				if(requestCode==ANYInput_Locked)
				{
					Log.i("demo", "into 3");
					Flag_isLocked=false;
					UpdateUIbyBeans(!Flag_isLocked);
				}
			}
			else 
			{
				Toast.makeText(this, "输入不正确", Toast.LENGTH_SHORT).show();
			}
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		// TODO Auto-generated method stub
		if(keyCode==KeyEvent.KEYCODE_BACK)
		{ 
			if(Flag_issaved==false)//未保存
			{
				NormalDialog normalDialog=new NormalDialog(ANYInput.this, "注意", "当前记录没有保存，是否保存");
				normalDialog.SetNlistener("暂不保存", new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{finish();}
				});
				normalDialog.SetPlistener("确定", null);
				normalDialog.Create().show();
			}
			return super.onKeyDown(keyCode, event);
		}
		else 
		{
			return super.onKeyDown(keyCode, event);
		}
		
	}
	

	private void UpdateUIbyBeans(boolean islocked)
	{
		NYHelper helper=new NYHelper(beans);
		tv_end.setText(helper.getEndTime());
		if(tv_end.getText().equals(""))
			btn_end.setEnabled(islocked);
		else 
			btn_end.setEnabled(false);
		
		tv_start.setText(helper.getStartTime());
		btn_start.setEnabled(islocked);
		
		if(tv_start.getText().equals(""))
			btn_start.setEnabled(islocked);
		else 
			btn_start.setEnabled(false);
		
		
		if(beans.getDakai_no()==0)
		{
			((RadioButton)rg_dakai.getChildAt(0)).setSelected(true);
			((RadioButton)rg_dakai.getChildAt(1)).setSelected(false);
		}
		else 
		{
			((RadioButton)rg_dakai.getChildAt(0)).setSelected(false);
			((RadioButton)rg_dakai.getChildAt(1)).setSelected(true);
		}
		
		((RadioButton)rg_dakai.getChildAt(0)).setEnabled(islocked);
		((RadioButton)rg_dakai.getChildAt(1)).setEnabled(islocked);
		
		if(beans.getAnshi_no()==0)
		{
			((RadioButton)rg_anshi.getChildAt(0)).setSelected(true);
			((RadioButton)rg_anshi.getChildAt(1)).setSelected(false);
		}
		else 
		{
			((RadioButton)rg_anshi.getChildAt(0)).setSelected(false);
			((RadioButton)rg_anshi.getChildAt(1)).setSelected(true);
		}
		
		((RadioButton)rg_anshi.getChildAt(0)).setEnabled(islocked);
		((RadioButton)rg_anshi.getChildAt(1)).setEnabled(islocked);

		if(beans.getGeshi_no()==0)
		{
			((RadioButton)rg_geshi.getChildAt(0)).setSelected(true);
			((RadioButton)rg_geshi.getChildAt(1)).setSelected(false);
		}
		else 
		{
			((RadioButton)rg_geshi.getChildAt(0)).setSelected(false);
			((RadioButton)rg_geshi.getChildAt(1)).setSelected(true);
		}
		
		((RadioButton)rg_geshi.getChildAt(0)).setEnabled(islocked);
		((RadioButton)rg_geshi.getChildAt(1)).setEnabled(islocked);
		
		if(beans.getSudu_no()==0)
		{
			cb_anshi.setSelected(true);
			ed_tiqian.setText(""+beans.getSudu_tiqinan());
			ed_tiqian.setEnabled(false);
		}
		else 
		{
			cb_anshi.setSelected(false);
			ed_tiqian.setText(""+beans.getSudu_tiqinan());
			ed_tiqian.setEnabled(true);
		}
		cb_anshi.setEnabled(islocked);
		ed_tiqian.setEnabled(islocked);
		ed_tiqian.setEnabled(islocked);
	
	}
	
	OnClickListener startclick=new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			tv_start.setText(SystemUtils.getSystemDateString());
			beans.setStarttime(SystemUtils.getSystemDateString());
			btn_start.setEnabled(false);
		}
	};
	
	OnClickListener endClickListener=new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			tv_end.setText(SystemUtils.getSystemDateString());
			beans.setEndtime(SystemUtils.getSystemDateString());
			btn_end.setEnabled(false);
		}
	};
	
	android.widget.CompoundButton.OnCheckedChangeListener toggle=new android.widget.CompoundButton.OnCheckedChangeListener()
	{
		
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		{
			if(!isChecked)
			{
				//输入密码,启动intent，回调
				Intent intent=new Intent(ANYInput.this, APasswordInput.class);
				startActivityForResult(intent, ANYInput.ANYInput_Locked);
			}
			else 
			{
				Flag_isLocked=true;
			}
			UpdateUIbyBeans(!Flag_isLocked);
			
			
		}
	};
	
	OnCheckedChangeListener rg_dakaiChangeListener=new OnCheckedChangeListener()
	{
		
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			// TODO Auto-generated method stub
			if(checkedId==R.id.fnyinput_dakai_no)
			{
				beans.setDakai_no(0);
			}
			else 
			{
					beans.setDakai_no(1);
					beans.setDakai_fail(1);
			}
		}
	};
	
	OnCheckedChangeListener rg_anshiChangeListener=new OnCheckedChangeListener()
	{
		
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			// TODO Auto-generated method stub
			if(checkedId==R.id.fnyinput_anshi_no)
				beans.setAnshi_no(0);
			else 
				{
					beans.setAnshi_no(1);
					beans.setAnshi_fail(1);
				}
		}
	};
	
	OnCheckedChangeListener rg_geshiChangeListener=new OnCheckedChangeListener()
	{
		
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			// TODO Auto-generated method stub
			if(checkedId==R.id.fnyinput_geshi_no)
				beans.setGeshi_no(0);
			else 
				{
					beans.setGeshi_no(1);
					beans.setGeshi_fail(1);
				}
		}
	};
	
	private CallbackAfterChange tiqiancallback=new CallbackAfterChange()
	{
		
		@Override
		public void AfterChange(int id,String text)
		{
			Log.i("demo", "exe_CallbackAfterChange");
			int reuslt=0;
			try
			{
				reuslt=Integer.parseInt(text);
			}
			catch (Exception e)
			{
				reuslt=0;
			}
			beans.setSudu_tiqinan(reuslt);
			Log.i("demo", "exe_CallbackAfterChange "+beans.getSudu_tiqinan());
		}
	};
	
	android.widget.CompoundButton.OnCheckedChangeListener cb_tiqianChangeListener=new android.widget.CompoundButton.OnCheckedChangeListener()
	{
		
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		{
			// TODO Auto-generated method stu
			if(isChecked)
			{
				beans.setSudu_no(0);
				ed_tiqian.setEnabled(false);
			}
			else 
			{
				beans.setSudu_no(1);
				ed_tiqian.setEnabled(true);
			}
			
		}
	};
	
	private boolean SaveBeans()
	{
		//beans.setSudu_tiqinan(getTiqianTime(ed_tiqian.getText().toString().trim()));
		beans.setPalyerno(GlobleParam.Create().getPlayerBeans().getPlayerno());
		stateBeans.setPlayerNO(GlobleParam.Create().getPlayerBeans().getPlayerno());
		
		SQLiteOrmSDContext context=new SQLiteOrmSDContext(this, GlobleParam.Create());
		SQliteCPZS cpzs=new SQliteCPZS(context);
		Log.i("demo", "in save bean"+beans.getSudu_tiqinan());
		CreateOrUpdateStatus i=cpzs.getRENYBeans().createOrUpdate(beans);
		boolean result=i.isCreated()||i.isUpdated();
		if(result)
		{
			RecordStateHelper helper=new RecordStateHelper(stateBeans);
			helper.setIsOverNY(result);
			CreateOrUpdateStatus j=cpzs.getRERecordStateBeans().createOrUpdate(helper.getBeans());
			result=result&&(j.isCreated()||j.isUpdated());
		}
		cpzs.close();
		SQLiteOrmHelper.ToastShowResult(ANYInput.this, result);
		return result;
		
	}
}
