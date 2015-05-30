package com.compenent;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import com.Beanshelper.RecordStateHelper;
import com.beans.RecordStateBeans;
import com.clcp.R;

public class RecordAdapeter extends BaseAdapter
{
	private Context context;
	private List<RecordStateBeans> list;
	private boolean[] checked;
	private boolean Flag_isshowout;
	
	
	public RecordAdapeter(Context context,List<RecordStateBeans> list,boolean isshowout)
	{
		this.context=context;
		this.list=list;
		this.Flag_isshowout=isshowout;
		checked=new boolean[list.size()];
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
		final int index=position;
		LayoutInflater inflater=LayoutInflater.from(context);
		convertView=inflater.inflate(R.layout.recordadapeteritem, null);
		
		TextView tv_no=(TextView)convertView.findViewById(R.id.recordadapeter_tv_playerno);
		TextView tv_overwy=(TextView)convertView.findViewById(R.id.recordadapeter_tv_overwy);
		TextView tv_overny=(TextView)convertView.findViewById(R.id.recordadapeter_tv_overny);
		CheckBox cb_out=(CheckBox)convertView.findViewById(R.id.recordadapeter_cb_flag);
		
		RecordStateHelper tempBeans=new RecordStateHelper(list.get(position));
		tv_no.setText(tempBeans.getPlayerNO());
		tv_overwy.setText(tempBeans.getWYState());
		tv_overny.setText(tempBeans.getNYState());
		cb_out.setChecked(checked[position]);
		if(!Flag_isshowout)
			cb_out.setVisibility(View.GONE);
		else 
			cb_out.setVisibility(View.VISIBLE);
		return convertView;
	}
	
	public void ToggleChecked(int index)
	{
		this.checked[index]=!this.checked[index];
		notifyDataSetChanged();
	}
	
	public boolean[] getChecked()
	{
		return checked;
	}

}
