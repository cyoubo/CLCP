 package com.system;

import java.util.List;









import com.beans.NYBeans;
import com.beans.PassWordBeans;
import com.beans.PlayerBeans;
import com.beans.WYBeans;
import com.tool.SqliteHelperOrm.IDataBaseInfo;

import android.graphics.PointF;
import android.util.Log;

/**ȫ�ֱ���
 * <br><b>���õ���ģʽ��֤����Ψһ</b>
 * */
public class GlobleParam implements IDataBaseInfo
{
	/**ȫ�ֲ�����Ψһʵ��*/
	private static GlobleParam mParam=null;
	
	private PlayerBeans playerBeans;
	private PassWordBeans psBeans;
	
	/**
	 * ��ȡ�򴴽�ȫ�ֲ�������
	 * @return ����ȫ�ֲ�����Ψһ����ʵ��
	 * */
	public static GlobleParam Create()
	{
		if (mParam == null)
		{
			Log.d("demo", "create new mparam");
			mParam = new GlobleParam();
		}
		return mParam;
	}
	/**
	 * ˽�л����캯������ֹ�ⲿ����
	 * */
	private GlobleParam()
	{
		playerBeans=new PlayerBeans();
		psBeans=new PassWordBeans();
	}
	
	public PassWordBeans getPsBeans()
	{
		return psBeans;
	}
	public void setPsBeans(PassWordBeans psBeans)
	{
		this.psBeans = psBeans;
	}
	public PlayerBeans getPlayerBeans()
	{
		return playerBeans;
	}
	public void setPlayerBeans(PlayerBeans playerBeans)
	{
		this.playerBeans = playerBeans;
	}


	public String CombineNameFromPlayer()
	{
		return this.playerBeans.getGuancePalyer()+"_"+this.playerBeans.getCaijiPalyer()+"_"+this.playerBeans.getBiantuPalyer();
	}
	
	public String getOutputFilePath()
	{
		return SystemUtils.ExtendSDpath()+"/CPZS/Grade/";
	}
	
	
	@Override
	public String getDataBaseFullPath()
	{
		// TODO Auto-generated method stub
		return SystemUtils.ExtendSDpath()+"/CPZS/DB/defalut.db";
	}
	@Override
	public String getDataBasePath()
	{
		// TODO Auto-generated method stub
		return SystemUtils.ExtendSDpath()+"/CPZS/DB";
	}
	@Override
	public String getDataBaseName()
	{
		// TODO Auto-generated method stub
		return "defalut.db";
	}

	

}
