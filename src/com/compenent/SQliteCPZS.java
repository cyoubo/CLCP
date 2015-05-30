package com.compenent;

import android.content.Context;

import com.beans.NYBeans;
import com.beans.PassWordBeans;
import com.beans.PlayerBeans;
import com.beans.RecordStateBeans;
import com.beans.WYBeans;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.tool.SqliteHelperOrm.SQLiteOrmHelper;
import com.tool.SqliteHelperOrm.SQLiteOrmSDContext;

public class SQliteCPZS extends SQLiteOrmHelper
{

	private SQliteCPZS(Context context, String databaseName)
	{
		super(context, databaseName);
		// TODO Auto-generated constructor stub
	}
	
	public SQliteCPZS(SQLiteOrmSDContext context)
	{
		super(context, context.getInfo().getDataBaseName());
	}
	
	public RuntimeExceptionDao<PlayerBeans, Integer> getREPlayerBeans()
	{
		return getRuntimeExceptionDao(PlayerBeans.class);
	}
	
	public RuntimeExceptionDao<PassWordBeans, Integer> getREPassWordBeans()
	{
		return getRuntimeExceptionDao(PassWordBeans.class);
	}

	public RuntimeExceptionDao<NYBeans, Integer> getRENYBeans()
	{
		return getRuntimeExceptionDao(NYBeans.class);
	}
	
	public RuntimeExceptionDao<RecordStateBeans, Integer> getRERecordStateBeans()
	{
		return getRuntimeExceptionDao(RecordStateBeans.class);
	}
	
	public RuntimeExceptionDao<WYBeans, Integer> getREWYBeans()
	{
		return getRuntimeExceptionDao(WYBeans.class);
	}
}
