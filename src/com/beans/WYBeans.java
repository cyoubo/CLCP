package com.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="WYBeans")
public class WYBeans
{
	@DatabaseField(columnName="index",generatedId=true)
	private int index;
	@DatabaseField(columnName="starttime")
	private String starttime;
	@DatabaseField(columnName="endtime")
	private String endtime;
	@DatabaseField(columnName="palyerno")
	private String palyerno;
	public int getIndex()
	{
		return index;
	}
	public void setIndex(int index)
	{
		this.index = index;
	}
	public String getPalyerno()
	{
		return palyerno;
	}
	public void setPalyerno(String palyerno)
	{
		this.palyerno = palyerno;
	}
	@DatabaseField(columnName="jiashe_no")
	private int jiashe_no;
	@DatabaseField(columnName="jiashe_buwen")
	private int jiashe_buwen;
	@DatabaseField(columnName="jiashe_banzhan")
	private int jiashe_banzhan;
	@DatabaseField(columnName="duizhong_no")
	private int duizhong_no;
	@DatabaseField(columnName="duizhong_qipao")
	private int duizhong_qipao;
	@DatabaseField(columnName="dingxiang_no")
	private int dingxiang_no;
	@DatabaseField(columnName="dingxiang_qian")
	private int dingxiang_qian;
	@DatabaseField(columnName="dingxiang_hou")
	private int dingxiang_hou;
	@DatabaseField(columnName="yindian_no")
	private int yindian_no;
	@DatabaseField(columnName="yindian_chaoxian")
	private int yindian_chaoxian;
	@DatabaseField(columnName="caiji_finish")
	private int caiji_finish;
	@DatabaseField(columnName="caiji_jiangli")
	private int caiji_jiangli;
	@DatabaseField(columnName="caiji_fail")
	private int caiji_fail;
	
	public String getStarttime()
	{
		return starttime;
	}
	public void setStarttime(String starttime)
	{
		this.starttime = starttime;
	}
	public String getEndtime()
	{
		return endtime;
	}
	public void setEndtime(String endtime)
	{
		this.endtime = endtime;
	}
	public int getJiashe_no()
	{
		return jiashe_no;
	}
	public void setJiashe_no(int jiashe_no)
	{
		this.jiashe_no = jiashe_no;
	}
	public int getJiashe_buwen()
	{
		return jiashe_buwen;
	}
	public void setJiashe_buwen(int jiashe_buwen)
	{
		this.jiashe_buwen = jiashe_buwen;
	}
	public int getJiashe_banzhan()
	{
		return jiashe_banzhan;
	}
	public void setJiashe_banzhan(int jiashe_banzhan)
	{
		this.jiashe_banzhan = jiashe_banzhan;
	}
	public int getDuizhong_no()
	{
		return duizhong_no;
	}
	public void setDuizhong_no(int duizhong_no)
	{
		this.duizhong_no = duizhong_no;
	}
	public int getDuizhong_qipao()
	{
		return duizhong_qipao;
	}
	public void setDuizhong_qipao(int duizhong_qipao)
	{
		this.duizhong_qipao = duizhong_qipao;
	}
	public int getDingxiang_no()
	{
		return dingxiang_no;
	}
	public void setDingxiang_no(int dingxiang_no)
	{
		this.dingxiang_no = dingxiang_no;
	}
	public int getDingxiang_qian()
	{
		return dingxiang_qian;
	}
	public void setDingxiang_qian(int dingxiang_qian)
	{
		this.dingxiang_qian = dingxiang_qian;
	}
	public int getDingxiang_hou()
	{
		return dingxiang_hou;
	}
	public void setDingxiang_hou(int dingxiang_hou)
	{
		this.dingxiang_hou = dingxiang_hou;
	}
	public int getYindian_no()
	{
		return yindian_no;
	}
	public void setYindian_no(int yindian_no)
	{
		this.yindian_no = yindian_no;
	}
	public int getYindian_chaoxian()
	{
		return yindian_chaoxian;
	}
	public void setYindian_chaoxian(int yindian_chaoxian)
	{
		this.yindian_chaoxian = yindian_chaoxian;
	}
	public int getCaiji_finish()
	{
		return caiji_finish;
	}
	public void setCaiji_finish(int caiji_finish)
	{
		this.caiji_finish = caiji_finish;
	}
	public int getCaiji_jiangli()
	{
		return caiji_jiangli;
	}
	public void setCaiji_jiangli(int caiji_jiangli)
	{
		this.caiji_jiangli = caiji_jiangli;
	}
	public int getCaiji_fail()
	{
		return caiji_fail;
	}
	public void setCaiji_fail(int caiji_fail)
	{
		this.caiji_fail = caiji_fail;
	}
	
	
}
