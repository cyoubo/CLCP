package com.compenent;

import com.clcp.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



/**
 * 用于完成九宫格的界面展示adapter<br>
 * <b>使用该工具需要引入资源文件tool_pannelitem.xml</b> 
 * */
public class PannelAdapter extends BaseAdapter
{

	private Context context;
	private String[] labels;
	private int[] icons;
	
	/**
	 * 构造函数<br>
	 * @param context 上下文环境
	 * @param labelIds 标题字符串资源的Id
	 * @param iconIds 图片资源的Id数组
	 * */
	public PannelAdapter(Context context,int labelIds,int[] iconIds)
	{
		this.context=context;
		labels=context.getResources().getStringArray(labelIds);
		icons=iconIds;
	}
	
	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return labels.length;
	}

	@Override
	public Object getItem(int position)
	{
		// TODO Auto-generated method stub
		return labels[position];
	}

	@Override
	public long getItemId(int position)
	{
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		if(convertView==null)
		{
			LayoutInflater inflater=LayoutInflater.from(context);
			convertView=inflater.inflate(R.layout.tool_pannelitem, null);
			TextView tv=(TextView)convertView.findViewById(R.id.tool_pannelitem_label);
			tv.setText(labels[position]);
			ImageView ig=(ImageView)convertView.findViewById(R.id.tool_pannelitem_icon);
			ig.setImageResource(icons[position]);
		}
		return convertView;
	}

}
