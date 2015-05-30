package com.activity2;

import com.beans.PlayerBeans;
import com.compenent.PlayersAdapter;
import com.compenent.SQliteCPZS;
import com.system.GlobleParam;
import com.tool.SqliteHelperOrm.SQLiteOrmSDContext;
import com.tool.mydialog.NormalDialog;
import com.tool.mydialog.SinDialog;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public class AListPlayerDisplay extends ListActivity
{
	private PlayersAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		PrepareAdapter();
		getListView().setAdapter(adapter);
		getListView().setOnItemClickListener(itemClickListener);
		getListView().setOnItemLongClickListener(itemLongClickListener);
	}
	
	private void PrepareAdapter()
	{
		SQLiteOrmSDContext context=new SQLiteOrmSDContext(this, GlobleParam.Create());
		SQliteCPZS cpzs=new SQliteCPZS(context);
		adapter=new PlayersAdapter(this,cpzs.getREPlayerBeans().queryForAll());
		
	}
	
	OnItemClickListener itemClickListener=new OnItemClickListener()
	{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id)
		{
			final int index=position;
			NormalDialog sinDialog=new NormalDialog(AListPlayerDisplay.this, "选择", "将该组置为当前组");
			sinDialog.SetNlistener("取消", null);
			sinDialog.SetPlistener("确定", new DialogInterface.OnClickListener()
			{
				
				@Override
				public void onClick(DialogInterface dialog, int which)
				{
					// TODO Auto-generated method stub
					GlobleParam.Create().setPlayerBeans(adapter.getClicked(index));
					Toast.makeText(AListPlayerDisplay.this, "设置成功", Toast.LENGTH_SHORT).show();
					finish();
				}
			});
			sinDialog.Create().show();
			
		}
	};
	
	OnItemLongClickListener itemLongClickListener=new OnItemLongClickListener()
	{

		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view,
				int position, long id)
		{
			final int index=position;
			SinDialog sinDialog=new SinDialog(AListPlayerDisplay.this, "删除", "删除当前组");
			sinDialog.SetNlistener("取消", null);
			sinDialog.SetPlistener("确定", new DialogInterface.OnClickListener()
			{
				
				@Override
				public void onClick(DialogInterface dialog, int which)
				{
					// TODO Auto-generated method stub
					String g_player=GlobleParam.Create().getPlayerBeans().getPlayerno();
					String c_player=adapter.getClicked(index).getPlayerno();
					if(g_player.equals(c_player))
						GlobleParam.Create().setPlayerBeans(new PlayerBeans());
					
					adapter.Remove(index);
					
					Toast.makeText(AListPlayerDisplay.this, "删除成功", Toast.LENGTH_SHORT).show();
				}
			});
			sinDialog.Create().show();
			return false;
		}
	};
}
