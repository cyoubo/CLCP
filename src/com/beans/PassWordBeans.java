package com.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="PW")
public class PassWordBeans
{
	@DatabaseField(columnName="index")
	private int index;
	@DatabaseField(columnName="password")
	private String passwrod;

	public String getPasswrod()
	{
		return passwrod;
	}

	public void setPasswrod(String passwrod)
	{
		this.passwrod = passwrod;
	}
	
}
