package com.compenent;

import android.R.integer;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 用于监听editview输入数字是的范围是否越界
 * */
public class InputNumRangeWatcher implements TextWatcher
{
	private int MIN_MARK,MAX_MARK;
	private Context context;
	private EditText et;
	private CallbackAfterChange afterChange;
	
	/**
	 * 构造函数
	 * @param context 上下文环境 
	 * @param et 监听变化的控件
	 * @param min 变化最小值
	 * @param max 变化最大值
	 * @param change 变换完成的回调函数，用于获得变化后的Edit的内容
	 * 
	 * */
	public InputNumRangeWatcher(Context context,EditText et,int min,int max,CallbackAfterChange change)
	{
		this.context=context;
		this.MIN_MARK=min;
		this.MAX_MARK=max;
		this.et=et;
		this.afterChange=change;
	}
	
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after)
	{
		if (start > 1) 
        { 
            if (MIN_MARK != -1 && MAX_MARK != -1) 
            { 
              int num = Integer.parseInt(s.toString()); 
              if (num > MAX_MARK) 
              { 
                  s = String.valueOf(MAX_MARK); 
                  et.setText(s); 
                  afterChange.AfterChange(et.getId(),String.valueOf(s));
              } 
              else if(num < MIN_MARK) 
              {
                  s = String.valueOf(MIN_MARK);
                  afterChange.AfterChange(et.getId(),String.valueOf(s));
              }
              return; 
            } 
        } 
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void afterTextChanged(Editable s)
	{
		if (s != null && !s.equals("")) 
        { 
            if (MIN_MARK != -1 && MAX_MARK != -1) 
            { 
                 int markVal = 0; 
                 try 
                 { 
                     markVal = Integer.parseInt(s.toString()); 
                 } 
                 catch (NumberFormatException e) 
                 { 
                     markVal = 0; 
                 } 
                 if (markVal > MAX_MARK) 
                 { 
                	 String mess="数字位于"+MIN_MARK+"~"+MAX_MARK+"之间";
                     Toast.makeText(context, mess, Toast.LENGTH_SHORT).show(); 
                     et.setText(String.valueOf(MAX_MARK)); 
                 }  
                 else 
                 {
                	 afterChange.AfterChange(et.getId(),""+markVal);
                 }
                 return; 
            } 
           
         } 
	}
	
	/**
	 * 用于实现获得监听变化后的Edittext的内容
	 * */
	public interface CallbackAfterChange
	{
		/*现获得监听变化后的Edittext的内容*/
		void AfterChange(int id,String text);
	}

}
