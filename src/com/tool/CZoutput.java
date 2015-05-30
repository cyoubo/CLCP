package com.tool;

import java.io.OutputStreamWriter;

import com.beans.NYBeans;
import com.beans.PlayerBeans;
import com.beans.WYBeans;

import FileUtils.FilesOuter.FileoutputListener;

public class CZoutput implements FileoutputListener
{
	private NYBeans nyBeans;
	private WYBeans wyBeans;
	private PlayerBeans playerBeans;
	
	public CZoutput(PlayerBeans playerBeans,WYBeans wyBeans,NYBeans nyBeans)
	{
		this.nyBeans=nyBeans;
		this.wyBeans=wyBeans;
		this.playerBeans=playerBeans;
	}
	
	@Override
	public boolean output(OutputStreamWriter out, String path, String name)
	{
		// TODO Auto-generated method stub
		return false;
	}

}
