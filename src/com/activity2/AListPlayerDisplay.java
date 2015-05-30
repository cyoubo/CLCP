package com.activity2;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Toast;

import com.beans.NYBeans;
import com.beans.PlayerBeans;
import com.compenent.PlayersAdapter;
import com.compenent.SQliteCPZS;
import com.system.GlobleParam;
import com.tool.SqliteHelperOrm.SQLiteOrmSDContext;
import com.tool.mydialog.NormalDialog;

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
		cpzs.close();
	}
	
	OnItemClickListener itemClickListener=new OnItemClickListener()
	{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id)
		{
			final int index=position;
			NormalDialog sinDialog=new NormalDialog(AListPlayerDisplay.this, "ѡ��", "��������Ϊ��ǰ��");
			sinDialog.SetNlistener("ȡ��", null);
			sinDialog.SetPlistener("ȷ��", new DialogInterface.OnClickListener()
			{
				
				@Override
				public void onClick(DialogInterface dialog, int which)
				{
					// TODO Auto-generated method stub
					GlobleParam.Create().setPlayerBeans(adapter.getClicked(index));
					Toast.makeText(AListPlayerDisplay.this, "���óɹ�", Toast.LENGTH_SHORT).show();
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
			NormalDialog sinDialog=new NormalDialog(AListPlayerDisplay.this, "ɾ��", "ɾ����ǰ��");
			sinDialog.SetNlistener("ȡ��", null);
			sinDialog.SetPlistener("ȷ��", new DialogInterface.OnClickListener()
			{
				
				@Override
				public void onClick(DialogInterface dialog, int which)
				{
					// TODO Auto-generated method stub
					String g_player=GlobleParam.Create().getPlayerBeans().getPlayerno();
					String c_player=adapter.getClicked(index).getPlayerno();
					if(g_player.equals(c_player))
					{
						Toast.makeText(AListPlayerDisplay.this, "����ɾ����ǰ��", Toast.LENGTH_SHORT).show();
					}
					else 
					{
						SQLiteOrmSDContext context=new SQLiteOrmSDContext(AListPlayerDisplay.this, GlobleParam.Create());
						SQliteCPZS cpzs=new SQliteCPZS(context);
						//�����Լ����ʵ�ּ���ɾ��
						cpzs.getReadableDatabase().execSQL("PRAGMA foreign_keys=ON");
						int result=cpzs.getREPlayerBeans().delete(adapter.getClicked(index));
						if(result==1)
						{
							adapter.Remove(index);
							Toast.makeText(AListPlayerDisplay.this, "ɾ���ɹ�", Toast.LENGTH_SHORT).show();
						}
						else 
						{
							Toast.makeText(AListPlayerDisplay.this, "ɾ��ʧ��", Toast.LENGTH_SHORT).show();
						}
						cpzs.close();
					}				
				}
			});
			sinDialog.Create().show();
			return true;
		}
	};
}
