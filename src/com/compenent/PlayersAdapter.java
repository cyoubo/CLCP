package com.compenent;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.beans.PlayerBeans;
import com.clcp.R;

public class PlayersAdapter extends BaseAdapter
{
	private List<PlayerBeans> list;
	private Context context;
	private String currentNO;
	
	public PlayersAdapter(Context context,List<PlayerBeans> list,String currentNO)
	{
		this.context=context;
		this.list=list;
		this.currentNO=currentNO;
	}
	
	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position)
	{
		// TODO Auto-generated method stub
		return position;
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
		// TODO Auto-generated method stub
		LayoutInflater inflater=LayoutInflater.from(context);
		convertView=inflater.inflate(R.layout.playersadapteritem, null, false);
		TextView tv_no=(TextView)convertView.findViewById(R.id.playersadapter_no);
		TextView tv_guance=(TextView)convertView.findViewById(R.id.playersadapter_guance);
		TextView tv_caiji=(TextView)convertView.findViewById(R.id.playersadapter_caiji);
		TextView tv_biantu=(TextView)convertView.findViewById(R.id.playersadapter_biantu);
		
		PlayerBeans temp=list.get(position);
		tv_biantu.setText(temp.getBiantuPalyer());
		tv_caiji.setText(temp.getCaijiPalyer());
		tv_guance.setText(temp.getGuancePalyer());
		tv_no.setText(temp.getPlayerno());
		
		if(temp.getPlayerno().equals(currentNO))
		{
			tv_biantu.setTextColor(Color.BLUE);
			tv_caiji.setTextColor(Color.BLUE);
			tv_guance.setTextColor(Color.BLUE);
			tv_no.setTextColor(Color.BLUE);
			tv_no.setText(temp.getPlayerno()+"£¨µ±Ç°×é£©");
		}
		
		return convertView;
	}
	
	public PlayerBeans getClicked(int index)
	{
		return list.get(index);
	}
	
	public void Remove(int index)
	{
		list.remove(index);
		this.notifyDataSetChanged();
	}

}
