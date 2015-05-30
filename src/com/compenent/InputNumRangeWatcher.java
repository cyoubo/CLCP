package com.compenent;

import android.R.integer;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

/**
 * ���ڼ���editview���������ǵķ�Χ�Ƿ�Խ��
 * */
public class InputNumRangeWatcher implements TextWatcher
{
	private int MIN_MARK,MAX_MARK;
	private Context context;
	private EditText et;
	private CallbackAfterChange afterChange;
	
	/**
	 * ���캯��
	 * @param context �����Ļ��� 
	 * @param et �����仯�Ŀؼ�
	 * @param min �仯��Сֵ
	 * @param max �仯���ֵ
	 * @param change �任��ɵĻص����������ڻ�ñ仯���Edit������
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
                	 String mess="����λ��"+MIN_MARK+"~"+MAX_MARK+"֮��";
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
	 * ����ʵ�ֻ�ü����仯���Edittext������
	 * */
	public interface CallbackAfterChange
	{
		/*�ֻ�ü����仯���Edittext������*/
		void AfterChange(int id,String text);
	}

}
