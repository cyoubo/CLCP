package com.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="RecordStateBeans")
public class RecordStateBeans
{
	@DatabaseField(columnName="index",generatedId=true)
	private int index;
	@DatabaseField(columnName="playerNO")
	private String playerNO;
	@DatabaseField(columnName="isoverWY")
	private int isoverWY;
	@DatabaseField(columnName="isoverNY")
	private int isoverNY;
	public int getIndex()
	{
		return index;
	}
	public void setIndex(int index)
	{
		this.index = index;
	}
	
	public String getPlayerNO()
	{
		return playerNO;
	}
	public void setPlayerNO(String playerNO)
	{
		this.playerNO = playerNO;
	}
	public int getIsoverWY()
	{
		return isoverWY;
	}
	public void setIsoverWY(int isoverWY)
	{
		this.isoverWY = isoverWY;
	}
	public int getIsoverNY()
	{
		return isoverNY;
	}
	public void setIsoverNY(int isoverNY)
	{
		this.isoverNY = isoverNY;
	}
	
}
