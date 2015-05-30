package com.Beanshelper;

import com.beans.WYBeans;

public class WYHelper
{
	private WYBeans beans;
	public WYHelper(WYBeans beans)
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
	
	public static final String  jiashe_no="9990301013";
	public static final String  jiashe_buwen="9990301001";
	public static final String  jiashe_banzhan="9990301002";
	
	public static final String  duizhong_no="9990301014";
	public static final String  duizhong_qipao="9990301003";

	public static final String  dingxiang_no="9990301015";
	public static final String  dingxiang_qian="9990301004";
	public static final String  dingxiang_hou="9990301005";
	
	public static final String  yindian_no="9990301016";
	public static final String  yindian_chaoxian="9990301006";
	
	public static final String  caiji_finish="9990301017";
	public static final String  caiji_jiangli="9990301022";
	public static final String  caiji_fail="9990301008";
	
}
