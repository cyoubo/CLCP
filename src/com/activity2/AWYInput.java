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
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.Beanshelper.RecordStateHelper;
import com.Beanshelper.WYHelper;
import com.beans.RecordStateBeans;
import com.beans.WYBeans;
import com.clcp.R;
import com.compenent.InputNumRangeWatcher;
import com.compenent.SQliteCPZS;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.system.GlobleParam;
import com.system.SystemUtils;
import com.tool.SqliteHelperOrm.SQLiteOrmHelper;
import com.tool.SqliteHelperOrm.SQLiteOrmSDContext;
import com.tool.mydialog.NormalDialog;

/**
 * 该界面用于外业数据输入
 * */
public class AWYInput extends Activity
{
	private Button btn_start, btn_end;
	private TextView tv_start, tv_end;
	private CheckBox cb_jiashe, cb_duizhong, cb_dingxiang, cb_yindian,
			cb_caiji;
	private EditText ed_buwen, ed_banzhan, ed_qipao, ed_qian, ed_hou,
			ed_chaoxian;
	private EditText ed_jiangli, ed_fail;
	private ToggleButton tg_islocked;

	private WYBeans beans;
	private RecordStateBeans stateBeans;

	private boolean Flag_isLocked;
	private boolean Flag_issaved;

	public static final int AWYInput_ResetStart = 1;
	public static final int AWYInput_ResetEnd = 2;
	public static final int AWYInput_Locked = 3;

	android.widget.CompoundButton.OnCheckedChangeListener toggle=new android.widget.CompoundButton.OnCheckedChangeListener()
	{
		
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		{
			if(!isChecked)
			{
				//输入密码,启动intent，回调
				Intent intent=new Intent(AWYInput.this, APasswordInput.class);
				startActivityForResult(intent, ANYInput.ANYInput_Locked);
			}
			else 
			{
				Flag_isLocked=true;
			}
			UpdateUIbyBeans(Flag_isLocked);
			
			
		}
	};

	OnClickListener startclick = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			tv_start.setText(SystemUtils.getSystemDateString());
			beans.setStarttime(tv_start.getText().toString());
			btn_start.setEnabled(false);

		}
	};

	OnClickListener endclick = new OnClickListener()
	{
		@Override
		public void onClick(View v)
		{
			tv_end.setText(SystemUtils.getSystemDateString());
			beans.setEndtime(tv_end.getText().toString());
			btn_end.setEnabled(false);
		}
	};
	OnCheckedChangeListener cb_jiasheChangeListener = new OnCheckedChangeListener()
	{

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked)
		{
			// TODO Auto-generated method stub
			if (isChecked)
			{
				
				ed_banzhan.setEnabled(false);
				ed_buwen.setEnabled(false);
			}
			else
			{

				ed_banzhan.setEnabled(true);
				ed_buwen.setEnabled(true);
			}
		}
	};

	OnCheckedChangeListener cb_duizhongChangeListener = new OnCheckedChangeListener()
	{

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked)
		{
			// TODO Auto-generated method stub
			if (isChecked)
			{

				ed_qipao.setEnabled(false);
			}
			else
			{

				ed_qipao.setEnabled(true);
			}
		}
	};

	OnCheckedChangeListener cb_dingxiangChangeListener = new OnCheckedChangeListener()
	{

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked)
		{
			// TODO Auto-generated method stub
			if (isChecked)
			{

				ed_qian.setEnabled(false);
				ed_hou.setEnabled(false);
			}
			else
			{

				ed_qian.setEnabled(true);
				ed_hou.setEnabled(true);
			}
		}
	};

	OnCheckedChangeListener cb_yindianChangeListener = new OnCheckedChangeListener()
	{

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked)
		{
			// TODO Auto-generated method stub
			if (isChecked)
			{

				ed_chaoxian.setEnabled(false);
			}
			else
			{

				ed_chaoxian.setEnabled(true);
			}
		}
	};

	OnCheckedChangeListener cb_caijiChangeListener = new OnCheckedChangeListener()
	{

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked)
		{
			// TODO Auto-generated method stub
			if (isChecked)
			{
				ed_jiangli.setEnabled(true);
				ed_fail.setEnabled(false);
			}
			else
			{
				ed_jiangli.setEnabled(false);
				ed_fail.setEnabled(true);
			}
		}
	};

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == APasswordInput.APasswordInput_repeat)
		{
			if (GlobleParam.Create().getPsBeans().getPasswrod()
					.equals(APasswordInput.password))
			{
				if (requestCode == AWYInput_ResetStart)
				{
					btn_start.setEnabled(true);
				}
				if (requestCode == AWYInput_ResetEnd)
				{
					btn_end.setEnabled(true);
				}
				if (requestCode == AWYInput_Locked)
				{
					Flag_isLocked = false;
					UpdateUIbyBeans(Flag_isLocked);
				}
			}
			else
			{
				Toast.makeText(this, "输入不正确", Toast.LENGTH_SHORT).show();
			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.fwyinput);

		/* 绑定控件 */
		btn_start = (Button) this.findViewById(R.id.fwyinput_btn_start);
		btn_end = (Button) this.findViewById(R.id.fwyinput_btn_end);
		tv_start = (TextView) this.findViewById(R.id.fwyinput_tv_start);
		tv_end = (TextView) this.findViewById(R.id.fwyinput_tv_end);
		cb_jiashe = (CheckBox) this.findViewById(R.id.fwyinput_cb_jiashi_no);
		ed_banzhan = (EditText) this
				.findViewById(R.id.fwyinput_ed_jiashi_banzhan);
		ed_buwen = (EditText) this.findViewById(R.id.fwyinput_ed_jiashi_buwen);
		cb_duizhong = (CheckBox) this
				.findViewById(R.id.fwyinput_cb_duizhong_no);
		ed_qipao = (EditText) this
				.findViewById(R.id.fwyinput_ed_duizhong_qipao);
		cb_dingxiang = (CheckBox) this
				.findViewById(R.id.fwyinput_cb_dingxiang_no);
		ed_qian = (EditText) this.findViewById(R.id.fwyinput_ed_dingxiang_qian);
		ed_hou = (EditText) this.findViewById(R.id.fwyinput_ed_dingxiang_hou);
		cb_yindian = (CheckBox) this.findViewById(R.id.fwyinput_cb_yindian_no);
		ed_chaoxian = (EditText) this
				.findViewById(R.id.fwyinput_ed_yindian_chaoxian);
		cb_caiji = (CheckBox) this.findViewById(R.id.fwyinput_cb_caiji_finish);
		ed_jiangli = (EditText) this
				.findViewById(R.id.fwyinput_ed_caiji_jiangli);
		ed_fail = (EditText) this.findViewById(R.id.fwyinput_ed_caiji_fail);
		tg_islocked = (ToggleButton) this
				.findViewById(R.id.fwyinput_toggle_locked);
		/* 事件监听 */
		btn_end.setOnClickListener(endclick);
		btn_start.setOnClickListener(startclick);
		cb_jiashe.setOnCheckedChangeListener(cb_jiasheChangeListener);
		cb_duizhong.setOnCheckedChangeListener(cb_duizhongChangeListener);
		cb_dingxiang.setOnCheckedChangeListener(cb_dingxiangChangeListener);
		cb_yindian.setOnCheckedChangeListener(cb_yindianChangeListener);
		cb_caiji.setOnCheckedChangeListener(cb_caijiChangeListener);
		tg_islocked.setOnCheckedChangeListener(toggle);
		/*edit事件監聽**/
		ed_banzhan.addTextChangedListener(new InputNumRangeWatcher(this, ed_banzhan, 0, 10, wyAfterChange));
		ed_buwen.addTextChangedListener(new InputNumRangeWatcher(this, ed_buwen, 0, 10, wyAfterChange));
		ed_chaoxian.addTextChangedListener(new InputNumRangeWatcher(this, ed_chaoxian, 0, 10, wyAfterChange));
		ed_fail.addTextChangedListener(new InputNumRangeWatcher(this, ed_fail, 0, 10, wyAfterChange));
		ed_hou.addTextChangedListener(new InputNumRangeWatcher(this, ed_hou, 0, 10, wyAfterChange));
		ed_jiangli.addTextChangedListener(new InputNumRangeWatcher(this, ed_jiangli, 0, 10, wyAfterChange));
		ed_qian.addTextChangedListener(new InputNumRangeWatcher(this, ed_qian, 0, 10, wyAfterChange));
		ed_qipao.addTextChangedListener(new InputNumRangeWatcher(this, ed_qipao, 0, 10, wyAfterChange));
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
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK)
		{
			if (Flag_issaved == false)// 未保存
			{
				NormalDialog normalDialog = new NormalDialog(AWYInput.this,
						"注意", "当前记录没有保存，是否保存");
				normalDialog.SetNlistener("暂不保存",
						new DialogInterface.OnClickListener()
						{
							@Override
							public void onClick(DialogInterface dialog,
									int which)
							{
								finish();
							}
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

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// TODO Auto-generated method stub
		switch (item.getOrder())
		{
			case 1:// 重置开始
			{
				Intent intent = new Intent(AWYInput.this, APasswordInput.class);
				startActivityForResult(intent, AWYInput_ResetStart);
			}
				break;
			case 2:// 重置结束
			{
				Intent intent = new Intent(AWYInput.this, APasswordInput.class);
				startActivityForResult(intent, AWYInput_ResetEnd);
			}
				break;
			case 3:// 项目保存
			{
				Flag_issaved = SaveBeans();

			}
				break;
		}
		return true;
	}

	@Override
	protected void onStart()
	{
		// TODO Auto-generated method stub
		super.onStart();
		/** 根据全局playerno设置创建或者回复nybeans */
		String g_playerno = GlobleParam.Create().getPlayerBeans().getPlayerno();
		if (g_playerno.equals(""))
		{
			Toast.makeText(this, "请选择参赛组别", Toast.LENGTH_LONG).show();
			finish();
		}
		else
		{
			SQLiteOrmSDContext context = new SQLiteOrmSDContext(this,
					GlobleParam.Create());
			SQliteCPZS cpzs = new SQliteCPZS(context);
			List<WYBeans> list = cpzs.getREWYBeans().queryForEq("palyerno",
					g_playerno);
			if (list != null && list.size() != 0)// 已经有相关记录了
			{
				beans = list.get(0);
			}
			else
			// 没有相关记录
			{
				beans = new WYBeans();
			}
			List<RecordStateBeans> list2 = cpzs.getRERecordStateBeans()
					.queryForEq("playerNO", g_playerno);
			if (list2 != null && list2.size() != 0)// 已经有相关记录了
			{
				stateBeans = list2.get(0);
			}
			else
			// 没有相关记录
			{
				stateBeans = new RecordStateBeans();
			}
			cpzs.close();
			UpdateUIbyBeans(Flag_isLocked);// 更新UI
		}
	}

	private boolean SaveBeans()
	{
		// beans.setSudu_tiqinan(getTiqianTime(ed_tiqian.getText().toString().trim()));
		beans.setPalyerno(GlobleParam.Create().getPlayerBeans().getPlayerno());
		stateBeans.setPlayerNO(GlobleParam.Create().getPlayerBeans()
				.getPlayerno());

		SQLiteOrmSDContext context = new SQLiteOrmSDContext(this,
				GlobleParam.Create());
		SQliteCPZS cpzs = new SQliteCPZS(context);
		CreateOrUpdateStatus i = cpzs.getREWYBeans().createOrUpdate(beans);
		boolean result = i.isCreated() || i.isUpdated();
		if (result)
		{
			RecordStateHelper helper = new RecordStateHelper(stateBeans);
			helper.setIsOverWY(result);
			CreateOrUpdateStatus j = cpzs.getRERecordStateBeans()
					.createOrUpdate(helper.getBeans());
			result = result && (j.isCreated() || j.isUpdated());
		}
		SQLiteOrmHelper.ToastShowResult(AWYInput.this, result);
		return result;

	}

	private void UpdateUIbyBeans(boolean islocked)
	{
		Log.d("demo", "UpdateUIbyBeans islocked is "+islocked);
		WYHelper helper=new WYHelper(beans);
		
		tv_end.setText(helper.getEndTime());
		btn_end.setEnabled(!islocked&&helper.getEndTime().equals(""));
		
		tv_start.setText(helper.getStartTime());
		btn_start.setEnabled(!islocked&&helper.getStartTime().equals(""));
		
		//架设
		cb_jiashe.setChecked(beans.getJiashe_no()==0);
		cb_jiashe.setEnabled(!islocked);
		ed_banzhan.setText(""+beans.getJiashe_banzhan());
		ed_buwen.setText(""+beans.getJiashe_buwen());
		ed_banzhan.setEnabled(!islocked&&beans.getJiashe_no()!=0);
		ed_buwen.setEnabled(!islocked&&beans.getJiashe_no()!=0);
		//对中
		cb_duizhong.setChecked(beans.getDuizhong_no()==0);
		cb_duizhong.setEnabled(!islocked);
		ed_qipao.setEnabled(!islocked&&beans.getDuizhong_no()!=0);
		ed_qipao.setText(""+beans.getDuizhong_qipao());
		//采点
		cb_dingxiang.setChecked(beans.getDingxiang_no()==0);
		cb_dingxiang.setEnabled(!islocked);
		ed_qian.setEnabled(!islocked&&beans.getDuizhong_no()!=0);
		ed_qian.setText(""+beans.getDingxiang_qian());
		ed_hou.setEnabled(!islocked&&beans.getDuizhong_no()!=0);
		ed_hou.setText(""+beans.getDingxiang_hou());
		//引测
		cb_yindian.setChecked(beans.getYindian_no()==0);
		cb_yindian.setEnabled(!islocked);
		ed_chaoxian.setEnabled(!islocked&&beans.getYindian_no()!=0);
		ed_chaoxian.setText(""+beans.getYindian_chaoxian());
		//采集
		cb_caiji.setChecked(beans.getCaiji_finish()==0);
		cb_caiji.setEnabled(!islocked);
		ed_jiangli.setEnabled(!islocked&&beans.getCaiji_finish()!=0);
		ed_jiangli.setText(""+beans.getCaiji_jiangli());
		ed_fail.setEnabled(!islocked&&beans.getCaiji_finish()!=0);
		ed_fail.setText(""+beans.getCaiji_fail ());
	}
	
	private InputNumRangeWatcher.CallbackAfterChange wyAfterChange=new InputNumRangeWatcher.CallbackAfterChange()
	{
		
		@Override
		public void AfterChange(int id, String text)
		{
			// TODO Auto-generated method stub
			int resuslt=0;
			try
			{
				resuslt=Integer.parseInt(text);
			}
			catch (Exception e)
			{
				resuslt=0;
			}
			
			switch (id)
			{
				case R.id.fwyinput_ed_jiashi_banzhan:
				{
					beans.setJiashe_banzhan(resuslt);
				}break;
				case R.id.fwyinput_ed_jiashi_buwen:
				{
					beans.setJiashe_buwen(resuslt);
				}break;
				case R.id.fwyinput_ed_duizhong_qipao:
				{
					beans.setDuizhong_qipao(resuslt);
				}break;
				case R.id.fwyinput_ed_dingxiang_qian:
				{
					beans.setDingxiang_qian(resuslt);
				}break;
				case R.id.fwyinput_ed_dingxiang_hou:
				{
					beans.setDingxiang_hou(resuslt);
				}break;
				case R.id.fwyinput_ed_yindian_chaoxian:
				{
					beans.setYindian_chaoxian(resuslt);
				}break;
				case R.id.fwyinput_ed_caiji_fail:
				{
					beans.setCaiji_fail(resuslt);
				}break;
				case R.id.fwyinput_ed_caiji_jiangli:
				{
					beans.setCaiji_jiangli(resuslt);
				}break;
				default:
					break;
			}
		}
	};
}
