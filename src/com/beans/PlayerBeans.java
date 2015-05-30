package com.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="PlayerBeans")
public class PlayerBeans
{
	@DatabaseField(columnName="index",generatedId=true)
	private int index;
	@DatabaseField(columnName="guancePalyer")
	private String guancePalyer="";
	@DatabaseField(columnName="biantuPalyer")
	private String biantuPalyer="";
	@DatabaseField(columnName="caijiPalyer")
	private String caijiPalyer="";
	@DatabaseField(columnName="playerno")
	private String playerno="";
	
	public String getPlayerno()
	{
		return playerno;
	}
	public void setPlayerno(String playerno)
	{
		this.playerno = playerno;
	}
	public String getGuancePalyer()
	{
		return guancePalyer;
	}
	public void setGuancePalyer(String guancePalyer)
	{
		this.guancePalyer = guancePalyer;
	}
	public String getBiantuPalyer()
	{
		return biantuPalyer;
	}
	public void setBiantuPalyer(String biantuPalyer)
	{
		this.biantuPalyer = biantuPalyer;
	}
	public String getCaijiPalyer()
	{
		return caijiPalyer;
	}
	public void setCaijiPalyer(String caijiPalyer)
	{
		this.caijiPalyer = caijiPalyer;
	}
	
	
}
