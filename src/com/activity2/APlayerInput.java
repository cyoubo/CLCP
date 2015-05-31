package com.activity2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.Beanshelper.RecordStateHelper;
import com.beans.RecordStateBeans;
import com.clcp.R;
import com.compenent.SQliteCPZS;
import com.system.GlobleParam;
import com.tool.SqliteHelperOrm.SQLiteOrmHelper;
import com.tool.SqliteHelperOrm.SQLiteOrmSDContext;

public class APlayerInput extends Activity
{
	private Button btn_sure,btn_reset;
	private EditText ed_guance,ed_biantu,ed_caiji,ed_playerno;
	
	
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.fplayerinput);
		/*∞Û∂®øÿº˛**/
		btn_reset=(Button)this.findViewById(R.id.fplayer_btn_reset);
		btn_sure=(Button)this.findViewById(R.id.fplayer_btn_sure);
		ed_biantu=(EditText)this.findViewById(R.id.fplayerinput_biantu);
		ed_guance=(EditText)this.findViewById(R.id.fplayerinput_guance);
		ed_caiji=(EditText)this.findViewById(R.id.fplayerinput_caiji);
		ed_playerno=(EditText)this.findViewById(R.id.fplayerinput_xiaozubianhao);
		/*…Ë÷√º‡Ã˝**/
		btn_reset.setOnClickListener(resetClickListener);
		btn_sure.setOnClickListener(sureClickListener);
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
				GlobleParam.Create().getPlayerBeans().setPlayerno(ed_playerno.getText().toString().trim());
				
				SQLiteOrmSDContext context=new SQLiteOrmSDContext(APlayerInput.this,GlobleParam.Create());
				SQliteCPZS cpzs=new SQliteCPZS(context);
				int result=cpzs.getREPlayerBeans().create(GlobleParam.Create().getPlayerBeans());
				
				RecordStateBeans tBeans=new RecordStateBeans();
				RecordStateHelper tHelper=new RecordStateHelper(tBeans);
				tHelper.setIsOverNY(false);
				ANYInput.Flag_isLocked=false;
				tHelper.setIsOverWY(false);
				AWYInput.Flag_isLocked=false;
				tHelper.setPlayerNO(GlobleParam.Create().getPlayerBeans().getPlayerno());
				
				cpzs.getRERecordStateBeans().createOrUpdate(tHelper.getBeans());
				
				cpzs.close();
				SQLiteOrmHelper.ToastShowResult(APlayerInput.this, result);
				if(result!=-1)
				{
					finish();
				}
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
	
	
	
}
