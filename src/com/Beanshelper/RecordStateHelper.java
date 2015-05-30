package com.Beanshelper;

import com.beans.RecordStateBeans;

public class RecordStateHelper
{
	private RecordStateBeans beans;
	public RecordStateHelper(RecordStateBeans beans)
	{
		this.beans=beans;
	}
	
	public RecordStateBeans getBeans()
	{
		return beans;
	}
	
	public String getPlayerNO()
	{
		return beans.getPlayerNO();
	}
	
	public boolean isOverWY()
	{
		return beans.getIsoverWY()==1;
	}
	
	public boolean isOverNY()
	{
		return beans.getIsoverNY()==1;
	}
	
	public void setIsOverWY(boolean r)
	{
		if(r)
			beans.setIsoverWY(1);
		else 
			beans.setIsoverWY(2);
	}
	
	public void setIsOverNY(boolean r)
	{
		if(r)
			beans.setIsoverNY(1);
		else 
			beans.setIsoverNY(2);
	}
	
	public String getNYState()
	{
		return isOverNY()?"完成":"未完成";
	}
	
	public String getWYState()
	{
		return isOverWY()?"完成":"未完成";
	}
	
}
