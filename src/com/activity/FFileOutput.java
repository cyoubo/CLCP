package com.activity;

import com.clcp.R;
import com.system.GlobleParam;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class FFileOutput extends Fragment
{
	private EditText ed_name;
	private Button btn_output;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		
		// TODO Auto-generated method stub
		//return super.onCreateView(inflater, container, savedInstanceState);
		return inflater.inflate(R.layout.ffileoutput, container,false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		View parent=getView();
		ed_name=(EditText)parent.findViewById(R.id.fflieoutput_ed_name);
		//btn_output=(Button)parent.findViewById(R.id.fflieoutput_btn_output);
		
		btn_output.setOnClickListener(outputClickListener);
		ed_name.setText(GlobleParam.Create().CombineNameFromPlayer());
	}
	
	OnClickListener outputClickListener=new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			
		}
	};
}
