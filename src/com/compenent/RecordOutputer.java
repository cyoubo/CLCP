package com.compenent;

import java.io.IOException;
import java.io.OutputStreamWriter;

import com.Beanshelper.NYHelper;
import com.Beanshelper.WYHelper;
import com.beans.NYBeans;
import com.beans.PlayerBeans;
import com.beans.WYBeans;

import FileUtils.FilesOuter.BaseFileOuter;
import FileUtils.FilesOuter.FileoutputListener;

public class RecordOutputer implements FileoutputListener
{
	private PlayerBeans players;
	private WYBeans wyBeans;
	private NYBeans nyBeans;
	
	public RecordOutputer(PlayerBeans players,WYBeans wyBeans,NYBeans nyBeans)
	{
		this.players=players;
		this.wyBeans=wyBeans;
		this.nyBeans=nyBeans;
	}
	
	@Override
	public boolean output(OutputStreamWriter out, String path, String name)
	{
		try
		{
			out.write("Name1:"+players.getGuancePalyer());
			out.write(BaseFileOuter.NewLine());
			out.write("Name2:"+players.getCaijiPalyer());
			out.write(BaseFileOuter.NewLine());
			out.write("Name3:"+players.getBiantuPalyer());
			out.write(BaseFileOuter.NewLine());
			out.write("Time1Start:"+wyBeans.getStarttime());
			out.write(BaseFileOuter.NewLine());
			out.write("Time1End:"+wyBeans.getEndtime());
			out.write(BaseFileOuter.NewLine());
			out.write("Time2Start:"+nyBeans.getStarttime());
			out.write(BaseFileOuter.NewLine());
			out.write("Time2End:"+nyBeans.getEndtime());
			out.write(BaseFileOuter.NewLine());

			out.flush();
			//外業架設
			if(wyBeans.getJiashe_no()==0)
			{
				out.write(WYHelper.jiashe_no+":"+wyBeans.getJiashe_no());
				out.write(BaseFileOuter.NewLine());
			}
			else 
			{
				if(wyBeans.getJiashe_banzhan()!=0)
				{
					out.write(WYHelper.jiashe_banzhan+":"+wyBeans.getJiashe_banzhan());
					out.write(BaseFileOuter.NewLine());
				}
				if(wyBeans.getJiashe_buwen()!=0)
				{
					out.write(WYHelper.jiashe_buwen+":"+wyBeans.getJiashe_buwen());
					out.write(BaseFileOuter.NewLine());
				}
			}
			out.flush();
			//對中整平
			if(wyBeans.getDuizhong_no()==0)
			{
				out.write(WYHelper.duizhong_no+":"+wyBeans.getDuizhong_no());
				out.write(BaseFileOuter.NewLine());
			}
			else 
			{
				if(wyBeans.getDuizhong_qipao()!=0)
				{
					out.write(WYHelper.duizhong_qipao+":"+wyBeans.getDuizhong_qipao());
					out.write(BaseFileOuter.NewLine());
				}
				
			}
			out.flush();
			//定向
			if(wyBeans.getDingxiang_no()==0)
			{
				out.write(WYHelper.dingxiang_no+":"+wyBeans.getDingxiang_no());
				out.write(BaseFileOuter.NewLine());
			}
			else 
			{
				if(wyBeans.getDingxiang_hou()!=0)
				{
					out.write(WYHelper.dingxiang_hou+":"+wyBeans.getDingxiang_hou());
					out.write(BaseFileOuter.NewLine());
				}
				if(wyBeans.getDingxiang_qian()!=0)
				{
					out.write(WYHelper.dingxiang_qian+":"+wyBeans.getDingxiang_qian());
					out.write(BaseFileOuter.NewLine());
				}
				
			}
			out.flush();
			//引點
			if(wyBeans.getYindian_no()==0)
			{
				out.write(WYHelper.yindian_no+":"+wyBeans.getYindian_no());
				out.write(BaseFileOuter.NewLine());
			}
			else 
			{
				if(wyBeans.getYindian_chaoxian()!=0)
				{
					out.write(WYHelper.yindian_chaoxian+":"+wyBeans.getYindian_chaoxian());	
					out.write(BaseFileOuter.NewLine());
				}
			}
			out.flush();
			//採集
			if(wyBeans.getCaiji_finish()==0)
			{
				
				out.write(WYHelper.caiji_finish+":"+wyBeans.getCaiji_finish());
				out.write(BaseFileOuter.NewLine());
			}
			else 
			{
				if(wyBeans.getCaiji_jiangli()!=0)
				{
					out.write(WYHelper.caiji_jiangli+":"+wyBeans.getCaiji_jiangli());
					out.write(BaseFileOuter.NewLine());
				}
				if(wyBeans.getCaiji_fail()!=0)
				{
					out.write(WYHelper.caiji_fail+":"+wyBeans.getCaiji_fail());
					out.write(BaseFileOuter.NewLine());
				}
			}
			out.flush();
			//打開
			if(nyBeans.getDakai_no()==0)
			{
				out.write(NYHelper.dakai_no+":0");
				out.write(BaseFileOuter.NewLine());
			}
			else 
			{
				out.write(NYHelper.dakai_fail+":1");
				out.write(BaseFileOuter.NewLine());
			}
			out.flush();
			//按時
			if(nyBeans.getAnshi_no()==0)
			{
				out.write(NYHelper.anshi_no+":0");
				out.write(BaseFileOuter.NewLine());
			}
			else 
			{
				out.write(NYHelper.anshi_fail+":1");
				out.write(BaseFileOuter.NewLine());
			}
			out.flush();
			//格式
			if(nyBeans.getGeshi_no()==0)
			{
				out.write(NYHelper.geshi_no+":0");
				out.write(BaseFileOuter.NewLine());
			}
			else 
			{
				out.write(NYHelper.geshi_fail+":1");
				out.write(BaseFileOuter.NewLine());
			}
			out.flush();
			//速度
			if(nyBeans.getSudu_no()==0)
			{
				out.write(NYHelper.geshi_no+":0");
				out.write(BaseFileOuter.NewLine());
			}
			else 
			{
				out.write(NYHelper.sudu_tiqinan+":"+nyBeans.getSudu_tiqinan());
				out.write(BaseFileOuter.NewLine());
			}
			out.flush();
			
			out.close();
		}
		catch (IOException e)
		{
			try
			{
				out.flush();
				out.close();
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return true;
	}

}
