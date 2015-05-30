package com.activity;

import java.util.ArrayList;
import java.util.List;

import com.clcp.R;
import com.system.GlobleParam;

import android.support.v4.app.Fragment;
import android.R.integer;
import android.drm.DrmStore.RightsStatus;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;

public class MainActivity2 extends FragmentActivity
{
	/*private CheckedTextView ct_player,ct_ny,ct_wy,ct_output;
	private int currentfrag;
	private List<Fragment> fragments;
	private FragmentTransaction ft;
	
	@Override
	protected void onCreate(Bundle arg0)
	{
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.mainactivity);
		
		fragments=new ArrayList<>();
		
		fragments.add(new FPlayerInput());
		fragments.add(new FWYInput());
		fragments.add(new FNYInput());
		fragments.add(new FFileOutput());
		
		currentfrag=-1;
		
		ct_ny=(CheckedTextView)findViewById(R.id.mainactivity_NY);
		ct_player=(CheckedTextView)findViewById(R.id.mainactivity_PlayerInput);
		ct_wy=(CheckedTextView)findViewById(R.id.mainactivity_WY);
		ct_output=(CheckedTextView)findViewById(R.id.mainactivity_Out);
		
		ct_ny.setOnClickListener(checkviewClickListener);
		ct_player.setOnClickListener(checkviewClickListener);
		ct_wy.setOnClickListener(checkviewClickListener);
		ct_output.setOnClickListener(checkviewClickListener);
		
	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
		
		ft = MainActivity.this.getSupportFragmentManager().beginTransaction();
		for(int i=0;i<fragments.size();i++)
		{
			ft.hide(fragments.get(i));
		}
		if(currentfrag!=-1&&GlobleParam.Create().statecreate[currentfrag])
			ft.show(fragments.get(currentfrag));
		ft.commit();
		Log.d("demo", "over onresume");
	}
	
	
	private OnClickListener checkviewClickListener=new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			if(currentfrag!=-1)
				fragments.get(currentfrag).onPause();
			ft = MainActivity.this.getSupportFragmentManager().beginTransaction();
			for(int i=0;i<fragments.size();i++)
			{
				ft.hide(fragments.get(i));
			}
			switch (v.getId())
			{
				case R.id.mainactivity_NY:
				{currentfrag=2;}break;
				case R.id.mainactivity_WY:
				{currentfrag=1;}break;
				case R.id.mainactivity_Out:
				{currentfrag=3;}break;
				case R.id.mainactivity_PlayerInput:
				{currentfrag=0;}break;
			}
			if(GlobleParam.Create().statecreate[currentfrag]==false)
			{
				Log.i("demo", "action add");
				ft.add(R.id.mainactivity_tab_content, fragments.get(currentfrag));
				GlobleParam.Create().statecreate[currentfrag]=true;
			}
			ft.show(fragments.get(currentfrag));
			ft.commit();
		}
	};*/
		
}
