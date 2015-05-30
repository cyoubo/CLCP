package com.activity;

import com.clcp.R;
import com.system.GlobleParam;
import com.system.SystemUtils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 该界面用于外业数据输入
 * */
public class FWYInput extends Fragment
{
	/*private Button btn_start,btn_end;
	private TextView tv_start,tv_end;
	private CheckBox cb_jiashe,cb_duizhong,cb_dingxiang,cb_yindian,cb_caiji;
	private EditText ed_buwen,ed_banzhan,ed_qipao,ed_qian,ed_hou,ed_chaoxian;
	private EditText ed_jiangli,ed_fail;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		//return super.onCreateView(inflater, container, savedInstanceState);
		return inflater.inflate(R.layout.fwyinput, container, false);

	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		View parent=getView();
		/*绑定控件
		btn_start=(Button) parent.findViewById(R.id.fwyinput_btn_start);
		btn_end=(Button)parent.findViewById(R.id.fwyinput_btn_end);
		tv_start=(TextView)parent.findViewById(R.id.fwyinput_tv_start);
		tv_end=(TextView)parent.findViewById(R.id.fwyinput_tv_end);
		cb_jiashe=(CheckBox)parent.findViewById(R.id.fwyinput_cb_jiashi_no);
		ed_banzhan=(EditText)parent.findViewById(R.id.fwyinput_ed_jiashi_banzhan);
		ed_buwen=(EditText)parent.findViewById(R.id.fwyinput_ed_jiashi_buwen);
		cb_duizhong=(CheckBox)parent.findViewById(R.id.fwyinput_cb_duizhong_no);
		ed_qipao=(EditText)parent.findViewById(R.id.fwyinput_ed_duizhong_qipao);
		cb_dingxiang=(CheckBox)parent.findViewById(R.id.fwyinput_cb_dingxiang_no);
		ed_qian=(EditText)parent.findViewById(R.id.fwyinput_ed_dingxiang_qian);
		ed_hou=(EditText)parent.findViewById(R.id.fwyinput_ed_dingxiang_hou);
		cb_yindian=(CheckBox)parent.findViewById(R.id.fwyinput_cb_yindian_no);
		ed_chaoxian=(EditText)parent.findViewById(R.id.fwyinput_ed_yindian_chaoxian);
		cb_caiji=(CheckBox)parent.findViewById(R.id.fwyinput_cb_caiji_finish);
		ed_jiangli=(EditText)parent.findViewById(R.id.fwyinput_ed_caiji_jiangli);
		ed_fail=(EditText)parent.findViewById(R.id.fwyinput_ed_caiji_fail);
		/*事件监听
		btn_end.setOnClickListener(endClickListener);
		btn_start.setOnClickListener(startclick);
		cb_jiashe.setOnCheckedChangeListener(cb_jiasheChangeListener);
		cb_duizhong.setOnCheckedChangeListener(cb_duizhongChangeListener);
		cb_dingxiang.setOnCheckedChangeListener(cb_dingxiangChangeListener);
		cb_yindian.setOnCheckedChangeListener(cb_yindianChangeListener);
		cb_caiji.setOnCheckedChangeListener(cb_caijiChangeListener);
		
	}
	
	OnClickListener startclick=new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			tv_start.setText(SystemUtils.getSystemDateString());
			btn_start.setEnabled(false);
			GlobleParam.Create().getWyBeans().setStarttime(SystemUtils.getSystemDateString());
		}
	};
	
	OnClickListener endClickListener=new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			tv_end.setText(SystemUtils.getSystemDateString());
			btn_end.setEnabled(false);
			GlobleParam.Create().getWyBeans().setStarttime(SystemUtils.getSystemDateString());
			//设置全局标记完成当前界面输入，可以进行下一步判定
			GlobleParam.Create().setState_wyinput_over(true);
			
		}
	};
	
	OnCheckedChangeListener cb_jiasheChangeListener=new OnCheckedChangeListener()
	{
		
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		{
			// TODO Auto-generated method stub
			if(isChecked)
			{
				GlobleParam.Create().getWyBeans().setJiashe_no(0);
				ed_banzhan.setEnabled(false);
				ed_buwen.setEnabled(false);
			}
			else 
			{
				GlobleParam.Create().getWyBeans().setJiashe_no(1);
				ed_banzhan.setEnabled(true);
				ed_buwen.setEnabled(true);
			}
		}
	};
	
	OnCheckedChangeListener cb_duizhongChangeListener=new OnCheckedChangeListener()
	{
		
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		{
			// TODO Auto-generated method stub
			if(isChecked)
			{
				GlobleParam.Create().getWyBeans().setDuizhong_no(0);
				ed_qipao.setEnabled(false);
			}
			else 
			{
				GlobleParam.Create().getWyBeans().setDuizhong_no(1);
				ed_qipao.setEnabled(true);
			}
		}
	};
	
	OnCheckedChangeListener cb_dingxiangChangeListener=new OnCheckedChangeListener()
	{
		
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		{
			// TODO Auto-generated method stub
			if(isChecked)
			{
				GlobleParam.Create().getWyBeans().setDingxiang_no(0);
				ed_qian.setEnabled(false);
				ed_hou.setEnabled(false);
			}
			else 
			{
				GlobleParam.Create().getWyBeans().setDingxiang_no(1);
				ed_qian.setEnabled(true);
				ed_hou.setEnabled(true);
			}
		}
	};
	
	OnCheckedChangeListener cb_yindianChangeListener=new OnCheckedChangeListener()
	{
		
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		{
			// TODO Auto-generated method stub
			if(isChecked)
			{
				GlobleParam.Create().getWyBeans().setYindian_no(0);
				ed_chaoxian.setEnabled(false);
			}
			else 
			{
				GlobleParam.Create().getWyBeans().setYindian_no(1);
				ed_chaoxian.setEnabled(true);
			}
		}
	};
	
	OnCheckedChangeListener cb_caijiChangeListener=new OnCheckedChangeListener()
	{
		
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		{
			// TODO Auto-generated method stub
			if(isChecked)
			{
				GlobleParam.Create().getWyBeans().setCaiji_finish(0);
				ed_jiangli.setEnabled(true);
				ed_fail.setEnabled(false);
			}
			else 
			{
				GlobleParam.Create().getWyBeans().setCaiji_finish(1);
				ed_jiangli.setEnabled(false);
				ed_fail.setEnabled(true);
			}
		}
	};
	*/
}
