package com.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName="NYBeans")
public class NYBeans
{
	@DatabaseField(columnName="index",generatedId=true)
	private int index;
	@DatabaseField(columnName="starttime")
	private String starttime;
	@DatabaseField(columnName="endtime")
	private String endtime;
	@DatabaseField(columnName="palyerno")
	private String palyerno;
	@DatabaseField(columnName="dakai_no")
	private int dakai_no;
	@DatabaseField(columnName="dakai_fail")
	private int dakai_fail;
	@DatabaseField(columnName="anshi_no")
	private int anshi_no;
	@DatabaseField(columnName="anshi_fail")
	private int anshi_fail;
	@DatabaseField(columnName="geshi_no")
	private int geshi_no;
	@DatabaseField(columnName="geshi_fail")
	private int geshi_fail;
	@DatabaseField(columnName="sudu_no")
	private int sudu_no;
	@DatabaseField(columnName="sudu_tiqinan")
	private int sudu_tiqinan;

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
	public int getDakai_no()
	{
		return dakai_no;
	}
	public void setDakai_no(int dakai_no)
	{
		this.dakai_no = dakai_no;
	}
	public int getDakai_fail()
	{
		return dakai_fail;
	}
	public void setDakai_fail(int dakai_fail)
	{
		this.dakai_fail = dakai_fail;
	}
	public int getAnshi_no()
	{
		return anshi_no;
	}
	public void setAnshi_no(int anshi_no)
	{
		this.anshi_no = anshi_no;
	}
	public int getAnshi_fail()
	{
		return anshi_fail;
	}
	public void setAnshi_fail(int anshi_fail)
	{
		this.anshi_fail = anshi_fail;
	}
	public int getGeshi_no()
	{
		return geshi_no;
	}
	public void setGeshi_no(int geshi_no)
	{
		this.geshi_no = geshi_no;
	}
	public int getGeshi_fail()
	{
		return geshi_fail;
	}
	public void setGeshi_fail(int geshi_fail)
	{
		this.geshi_fail = geshi_fail;
	}
	public int getSudu_no()
	{
		return sudu_no;
	}
	public void setSudu_no(int sudu_no)
	{
		this.sudu_no = sudu_no;
	}
	public int getSudu_tiqinan()
	{
		return sudu_tiqinan;
	}
	public void setSudu_tiqinan(int sudu_tiqinan)
	{
		this.sudu_tiqinan = sudu_tiqinan;
	}
}
