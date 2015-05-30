package com.activity;

import com.clcp.R;
import com.system.GlobleParam;
import com.system.SystemUtils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

/**内业输入的fragment*/
public class FNYInput extends Fragment
{
	/*private Button btn_start,btn_end;
	private TextView tv_start,tv_end;
	private RadioGroup rg_dakai,rg_anshi,rg_geshi;
	private CheckBox cb_anshi;
	private EditText ed_tiqian;
	

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{		
		Log.i("demo", "onCreateView");
		return inflater.inflate(R.layout.fnyinput, container, false);

	}
	
	public void onActivityCreated(Bundle savedInstanceState) 
	{
		super.onActivityCreated(savedInstanceState);
		View parent=getView();
		/*绑定控件
		btn_start=(Button) parent.findViewById(R.id.fnyinput_btn_start);
		btn_end=(Button)parent.findViewById(R.id.fnyinput_btn_end);
		tv_start=(TextView)parent.findViewById(R.id.fnyinput_tv_start);
		tv_end=(TextView)parent.findViewById(R.id.fnyinput_tv_end);
		rg_dakai=(RadioGroup)parent.findViewById(R.id.fnyinput_radioGroup_dakai);
		rg_anshi=(RadioGroup)parent.findViewById(R.id.fnyinput_radioGroup_anshi);
		rg_geshi=(RadioGroup)parent.findViewById(R.id.fnyinput_RadioGroup_geishi);
		cb_anshi=(CheckBox)parent.findViewById(R.id.fnying_cb_anshi);
		ed_tiqian=(EditText)parent.findViewById(R.id.fnying_ed_tiqian);
		/*设置监听
		btn_start.setOnClickListener(startclick);
		btn_end.setOnClickListener(endClickListener);
		rg_dakai.setOnCheckedChangeListener(rg_dakaiChangeListener);
		rg_anshi.setOnCheckedChangeListener(rg_anshiChangeListener);
		rg_geshi.setOnCheckedChangeListener(rg_geshiChangeListener);
		cb_anshi.setOnCheckedChangeListener(cb_tiqianChangeListener);
	};
	
	OnClickListener startclick=new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			tv_start.setText(SystemUtils.getSystemDateString());
			btn_start.setEnabled(false);
			GlobleParam.Create().getNyBeans().setStarttime(SystemUtils.getSystemDateString());
		}
	};
	
	OnClickListener endClickListener=new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			tv_end.setText(SystemUtils.getSystemDateString());
			btn_end.setEnabled(false);
			GlobleParam.Create().getNyBeans().setStarttime(SystemUtils.getSystemDateString());
			int tiaqian= getTiqianTime(ed_tiqian.getText().toString());
			GlobleParam.Create().getNyBeans().setSudu_tiqinan(tiaqian);
			//设置全局标记完成当前界面输入，可以进行下一步判定
			GlobleParam.Create().setState_nyinput_over(true);
			
		}
	};
	
	OnCheckedChangeListener rg_dakaiChangeListener=new OnCheckedChangeListener()
	{
		
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			// TODO Auto-generated method stub
			if(checkedId==R.id.fnyinput_dakai_no)
				GlobleParam.Create().getNyBeans().setDakai_no(0);
			else 
				{
					GlobleParam.Create().getNyBeans().setDakai_no(1);
					GlobleParam.Create().getNyBeans().setDakai_fail(1);
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
				GlobleParam.Create().getNyBeans().setAnshi_no(0);
			else 
				{
					GlobleParam.Create().getNyBeans().setAnshi_no(1);
					GlobleParam.Create().getNyBeans().setAnshi_fail(1);
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
				GlobleParam.Create().getNyBeans().setGeshi_no(0);
			else 
				{
					GlobleParam.Create().getNyBeans().setGeshi_no(1);
					GlobleParam.Create().getNyBeans().setGeshi_fail(1);
				}
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
				GlobleParam.Create().getNyBeans().setSudu_no(0);
				ed_tiqian.setEnabled(false);
			}
			else 
			{
				GlobleParam.Create().getNyBeans().setSudu_no(1);
				ed_tiqian.setEnabled(true);
			}
			
		}
	};
	
	private int getTiqianTime(String time)
	{
		int result=0;
		try
		{
			result=Integer.parseInt(time);
			if(result>10)
				result=10;
			if(result<0)
				result=0;
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		return result;
	}
	*/
	
}
