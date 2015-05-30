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
 * ������ɾŹ���Ľ���չʾadapter<br>
 * <b>ʹ�øù�����Ҫ������Դ�ļ�tool_pannelitem.xml</b> 
 * */
public class PannelAdapter extends BaseAdapter
{

	private Context context;
	private String[] labels;
	private int[] icons;
	
	/**
	 * ���캯��<br>
	 * @param context �����Ļ���
	 * @param labelIds �����ַ�����Դ��Id
	 * @param iconIds ͼƬ��Դ��Id����
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
