package com.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.clcp.R;
import com.system.GlobleParam;

public class FPlayerInput extends Fragment
{
	/*private Button btn_sure,btn_reset;
	private EditText ed_guance,ed_biantu,ed_caiji;
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		View parent=getView();
		/*∞Û∂®øÿº˛
		btn_reset=(Button)parent.findViewById(R.id.fplayer_btn_reset);
		btn_sure=(Button)parent.findViewById(R.id.fplayer_btn_sure);
		ed_biantu=(EditText)parent.findViewById(R.id.fplayerinput_biantu);
		ed_guance=(EditText)parent.findViewById(R.id.fplayerinput_guance);
		ed_caiji=(EditText)parent.findViewById(R.id.fplayerinput_caiji);
		/*…Ë÷√º‡Ã˝
		btn_reset.setOnClickListener(resetClickListener);
		btn_sure.setOnClickListener(sureClickListener);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		Log.i("demo", "onCreateView");
		return inflater.inflate(R.layout.fplayerinput, container, false);
	}
	
	OnClickListener sureClickListener=new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			if(ed_guance.getText().toString().trim().equals(""))
			{
				ed_guance.setText("«Î ‰»Î");
			}
			else if(ed_caiji.getText().toString().trim().equals(""))
			{
				ed_caiji.setText("«Î ‰»Î");
			}
			else if(ed_biantu.getText().toString().trim().equals(""))
			{
				ed_biantu.setText("«Î ‰»Î");
			}
			else
			{
				GlobleParam.Create().getPlayerBeans().setBiantuPalyer(ed_biantu.getText().toString().trim());
				GlobleParam.Create().getPlayerBeans().setGuancePalyer(ed_guance.getText().toString().trim());
				GlobleParam.Create().getPlayerBeans().setCaijiPalyer(ed_caiji.getText().toString().trim());
				GlobleParam.Create().setState_palyer_over(true);
			}
		}
	};
	
	OnClickListener resetClickListener=new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			ed_biantu.setText("");
			ed_guance.setText("");
			ed_caiji.setText("");
		}
	};
	
	public void onPause() 
	{
		super.onPause();
		Log.i("demo", "frag onpause");
	};
	
	*/
	
}
