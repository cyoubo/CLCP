package com.activity2;

import java.util.List;

import com.Beanshelper.RecordStateHelper;
import com.beans.PassWordBeans;
import com.beans.PlayerBeans;
import com.beans.RecordStateBeans;
import com.clcp.R;
import com.compenent.PannelAdapter;
import com.compenent.SQliteCPZS;
import com.system.GlobleParam;
import com.tool.SqliteHelperOrm.SQLiteOrmSDContext;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainActivity extends Activity
{
	private GridView gridView;
	
	private PannelAdapter adapter;
	private int[] icons;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.mainactivity2);
		
		gridView=(GridView)findViewById(R.id.mainactivity2_gridView1);
		
		icons=new int[]{R.drawable.icon1,R.drawable.icon2,R.drawable.icon3
				,R.drawable.icon4,R.drawable.icon5,R.drawable.icon6};
		adapter=new PannelAdapter(this, R.array.pannellabel, icons);
		
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(itemClickListener);
		
		PrepareDatabase();
		PreparePasswordBeans();
		PerparebyShare();
		
	}
	
	private OnItemClickListener itemClickListener=new OnItemClickListener()
	{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id)
		{
			Intent intent=new Intent();
			switch (position)
			{
				case 0://新建比赛组
				{
					intent.setClass(MainActivity.this, APlayerInput.class);
				}break;
				case 1://查看与删除比赛组
				{
					intent.setClass(MainActivity.this, AListPlayerDisplay.class);
				}break;
				case 2://外业观测
				{
					intent.setClass(MainActivity.this, AWYInput.class);
				}break;
				case 3://内业观测
				{
					intent.setClass(MainActivity.this, ANYInput.class);
				}break;
				case 4://文件
				{
					intent.setClass(MainActivity.this, AFileOutput.class);
				}break;
				case 5://密码管理
				{
					intent.setClass(MainActivity.this, APassWordMana.class);
				}break;
			}
			startActivity(intent);
		}
	};
	
	private void PrepareDatabase()
	{
		SQLiteOrmSDContext context=new SQLiteOrmSDContext(this, GlobleParam.Create());
		SQliteCPZS sQliteCPZS=new SQliteCPZS(context);
		sQliteCPZS.getReadableDatabase().close();
	}
	
	private void  PreparePasswordBeans()
	{
		SQLiteOrmSDContext context=new SQLiteOrmSDContext(this, GlobleParam.Create());
		SQliteCPZS CPZS=new SQliteCPZS(context);
		
		List<PassWordBeans> list=CPZS.getREPassWordBeans().queryForAll();
		if(list.size()!=0)
			GlobleParam.Create().setPsBeans(list.get(0));
		else 
			GlobleParam.Create().setPsBeans(new PassWordBeans());
		
		CPZS.close();
	}
	
	private void PerparebyShare()
	{
		SharedPreferences sp=getSharedPreferences("Current", Context.MODE_PRIVATE);
		String currentno=sp.getString("current", "");
		if(!currentno.equals(""))
		{
			SQLiteOrmSDContext context=new SQLiteOrmSDContext(this, GlobleParam.Create());
			SQliteCPZS CPZS=new SQliteCPZS(context);
			List<PlayerBeans> list=CPZS.getREPlayerBeans().queryForEq("playerno", currentno);
			if(list.size()!=0)
			{
				GlobleParam.Create().setPlayerBeans(list.get(0));
				
				RecordStateBeans teBeans=CPZS.getRERecordStateBeans().queryForEq("playerNO", currentno).get(0);
				RecordStateHelper teHelper=new RecordStateHelper(teBeans);
				ANYInput.Flag_isLocked=teHelper.isOverNY();
				AWYInput.Flag_isLocked=teHelper.isOverWY();
			}
			else 
				GlobleParam.Create().setPlayerBeans(new PlayerBeans());
			
			CPZS.close();
		}
	}
	
	@Override
	protected void onResume()
	{
		// TODO Auto-generated method stub
		super.onResume();
		
	}
	
	@Override
	protected void onDestroy()
	{
		// TODO Auto-generated method stub
		super.onDestroy();
		//将当前比赛组写入配置文件，方便后期恢复
		SharedPreferences sp=getSharedPreferences("Current", Context.MODE_PRIVATE);
		Editor ed=sp.edit();
		ed.putString("current", GlobleParam.Create().getPlayerBeans().getPlayerno());
		ed.commit();
	}
}
