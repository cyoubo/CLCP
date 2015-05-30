package com.activity2;

import FileUtils.FilesOuter.BaseFileOuter;
import FileUtils.FilesOuter.WriteFlag;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.beans.NYBeans;
import com.beans.PlayerBeans;
import com.beans.WYBeans;
import com.clcp.R;
import com.compenent.RecordAdapeter;
import com.compenent.RecordOutputer;
import com.compenent.SQliteCPZS;
import com.system.GlobleParam;
import com.tool.SqliteHelperOrm.SQLiteOrmSDContext;

/**
 * @author cyoubo
 * 該界面用於記錄文件輸出設置
 * */
public class AFileOutput extends Activity
{
	private EditText ed_name;
	private Button btn_outcurrent,btn_outselected,btn_outall;
	
	private RecordAdapeter adapeter;
	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.ffileoutput);
		
		ed_name=(EditText)this.findViewById(R.id.fflieoutput_ed_name);
		btn_outcurrent=(Button)this.findViewById(R.id.fflieoutput_btn_outcurrent);
		btn_outselected=(Button)this.findViewById(R.id.fflieoutput_btn_outselected);
		btn_outall=(Button)this.findViewById(R.id.fflieoutput_btn_outall);
		listView=(ListView)this.findViewById(R.id.fflieoutput_listView);
		
		btn_outcurrent.setOnClickListener(outcurrentClickListener);
		btn_outall.setOnClickListener(outallClickListener);
		btn_outselected.setOnClickListener(outselectedClickListener);
		ed_name.setText(GlobleParam.Create().getPlayerBeans().getPlayerno());
		
		PreparedAdatper();
		listView.setAdapter(adapeter);
		listView.setOnItemClickListener(itemClickListener);
		
		
	}
	
	void PreparedAdatper()
	{
		SQLiteOrmSDContext context=new SQLiteOrmSDContext(this, GlobleParam.Create());
		SQliteCPZS cpzs=new SQliteCPZS(context);
		adapeter=new RecordAdapeter(this, cpzs.getRERecordStateBeans().queryForAll(), true);
		cpzs.close();
	}
	
	OnItemClickListener itemClickListener=new OnItemClickListener()
	{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id)
		{
			// TODO Auto-generated method stub
			
		}
	};
	
	OnClickListener outcurrentClickListener=new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			String playno=GlobleParam.Create().getPlayerBeans().getPlayerno();
			PlayerBeans playerBeans=GlobleParam.Create().getPlayerBeans();
			
			SQLiteOrmSDContext context=new SQLiteOrmSDContext(AFileOutput.this, GlobleParam.Create());
			SQliteCPZS cpzs=new SQliteCPZS(context);
			
			WYBeans WYbeans=cpzs.getREWYBeans().queryForEq("palyerno", playno).get(0);
			NYBeans NYbeans=cpzs.getRENYBeans().queryForEq("palyerno", playno).get(0);
			
			BaseFileOuter output=new BaseFileOuter(GlobleParam.Create().getOutputFilePath(), playno+".cz");
			output.CreateOrOpenFile(WriteFlag.MAINTAIN);
			output.Print(new RecordOutputer(playerBeans, WYbeans, NYbeans));
			output.Close();
			
			Toast.makeText(AFileOutput.this, "完成輸出", Toast.LENGTH_SHORT).show();
		}
	};
	
	OnClickListener outselectedClickListener=new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			Toast.makeText(AFileOutput.this, "該功能暫未開放", Toast.LENGTH_SHORT).show();
		}
	};
	
	OnClickListener outallClickListener=new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			Toast.makeText(AFileOutput.this, "該功能暫未開放", Toast.LENGTH_SHORT).show();
		}
	};
}
