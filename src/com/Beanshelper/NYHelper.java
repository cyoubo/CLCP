package com.Beanshelper;

import com.beans.NYBeans;

public class NYHelper
{
	private NYBeans beans;
	public NYHelper(NYBeans beans)
	{
		this.beans=beans;
	}
	
	public String getStartTime()
	{
		if(beans.getStarttime()==null||beans.getStarttime().equals(""))
			return "";
		else 
			return beans.getStarttime();
	}
	
	public String getEndTime()
	{
		if(beans.getEndtime()==null||beans.getEndtime().equals(""))
			return "";
		else 
			return beans.getEndtime();
	}
	
	public static final String dakai_no="9990301018";
	public static final String dakai_fail="9990301009";

	public static final String anshi_no="9990301019";
	public static final String anshi_fail="9990301011";

	public static final String geshi_no="9990301020";
	public static final String geshi_fail="9990301010";

	public static final String sudu_no="9990301021";
	public static final String sudu_tiqinan="9990301012";
	
}
