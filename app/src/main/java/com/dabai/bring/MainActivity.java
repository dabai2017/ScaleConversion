package com.dabai.bring;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.view.View.*;
import android.text.*;

public class MainActivity extends Activity 
{
	EditText ET_2,ET_8,ET_10,ET_16;
	Button bu_back1;
	Context context;

	String txt;
	//光标所指进制位置
	int et_in = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		context = getApplicationContext();
		init_val();
		init();
	

    }

	private void init()
	{
		
		ET_2.addTextChangedListener(new TextWatcher(){
				@Override
				public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4)
				{	
			
				}
				@Override
				public void onTextChanged(CharSequence p1, int p2, int p3, int p4)
				{
					txt = p1.toString();		
				}
				@Override
				public void afterTextChanged(Editable p1)
				{
					try{
						//实时获取
						if(et_in==2 && txt!=""){
							int ten = Integer.parseInt(txt,2);
							//转8
							ET_8.setText(Integer.toOctalString(ten));
							//转10
							ET_10.setText(""+ten);
							//转16
							ET_16.setText(Integer.toHexString(ten).toUpperCase());
						}		
					}catch(Exception e){
						//setTitle("异常:"+e);
					}
					}
			});
		
		
				
			
		ET_8.addTextChangedListener(new TextWatcher(){
				@Override
				public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4)
				{	

				}
				@Override
				public void onTextChanged(CharSequence p1, int p2, int p3, int p4)
				{
					txt = p1.toString();		
				}
				@Override
				public void afterTextChanged(Editable p1)
				{
					try{
						//实时获取
						if(et_in==8 && txt!=""){
							int ten = Integer.parseInt(txt,8);
							//转2
							ET_2.setText(Integer.toBinaryString(ten));
							//转10
							ET_10.setText(""+ten);
							//转16
							ET_16.setText(Integer.toHexString(ten).toUpperCase());
						}		
					}catch(Exception e){
						//setTitle("异常:"+e);
					}
				}
			});
			
			
		ET_10.addTextChangedListener(new TextWatcher(){
				@Override
				public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4)
				{	

				}
				@Override
				public void onTextChanged(CharSequence p1, int p2, int p3, int p4)
				{
					txt = p1.toString();		
				}
				@Override
				public void afterTextChanged(Editable p1)
				{
					try{
						//实时获取
						if(et_in==10 && txt!=""){
							int ten = Integer.parseInt(txt,10);
							//转8
							ET_8.setText(Integer.toOctalString(ten));
							//转2
							ET_2.setText(Integer.toBinaryString(ten));
							//转16
							ET_16.setText(Integer.toHexString(ten).toUpperCase());
						}		
					}catch(Exception e){
						//setTitle("异常:"+e);
					}
				}
			});
			
			
			
		ET_16.addTextChangedListener(new TextWatcher(){
				@Override
				public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4)
				{	

				}
				@Override
				public void onTextChanged(CharSequence p1, int p2, int p3, int p4)
				{
					txt = p1.toString();		
				}
				@Override
				public void afterTextChanged(Editable p1)
				{
					try{
						//实时获取
						if(et_in==16 && txt!=""){
							int ten = Integer.parseInt(txt,16);
							//转8
							ET_8.setText(Integer.toOctalString(ten));
							//转2
							ET_2.setText(Integer.toBinaryString(ten));
							//转10
							ET_10.setText(""+ten);
						}		
					}catch(Exception e){
						//setTitle("异常:"+e);
					}
				}
			});
		
			
			
		
		
		ET_2.setOnFocusChangeListener(new OnFocusChangeListener(){
				@Override
				public void onFocusChange(View p1, boolean p2)
				{
					et_in = 2;
				}
			});
		ET_8.setOnFocusChangeListener(new OnFocusChangeListener(){
				@Override
				public void onFocusChange(View p1, boolean p2)
				{
					et_in = 8;
				}
			});
		ET_10.setOnFocusChangeListener(new OnFocusChangeListener(){
				@Override
				public void onFocusChange(View p1, boolean p2)
				{
					et_in = 10;
				}
			});
		ET_16.setOnFocusChangeListener(new OnFocusChangeListener(){
				@Override
				public void onFocusChange(View p1, boolean p2)
				{
					et_in = 16;
				}
			});
		bu_back1.setOnLongClickListener(new OnLongClickListener(){

				@Override
				public boolean onLongClick(View p1)
				{
					del_text();
					return true;
				}
			});
		
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
					 WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
		
		
	}

	public void init_val()
	{
		//eeee
		ET_2 = (EditText)findViewById(R.id.ET_2);
		ET_8 = (EditText)findViewById(R.id.ET_8);
		ET_10 = (EditText)findViewById(R.id.ET_10);
		ET_16 = (EditText)findViewById(R.id.ET_16);
		
		/*
		光标隐藏
		ET_2.setCursorVisible(false);
		ET_8.setCursorVisible(false);
		ET_10.setCursorVisible(false);
		ET_16.setCursorVisible(false);
		*/
		
		//bbb
		bu_back1 = (Button)findViewById(R.id.bu_back1);
		
		
		
		
	}


	public void bu_clear(View v)
	{
		clear_text();
		//showToast("清除成功");
	}

	private void showToast(Object p0)
	{
		// TODO: Implement this method
		Toast.makeText(context, p0+"", 1).show();
	}
	
//统一清理
	private void clear_text()
	{
		// TODO: Implement this method
		ET_2.setText("");
		ET_8.setText("");
		ET_10.setText("");
		ET_16.setText("");	
	}

	
	//统一冰绿茶
	public void add_text(String i)
	{
		
		if (et_in == 2)
		{
		
			if("01".contains(i)){
				ET_2.setText(ET_2.getText().toString() + i);
				ET_2.setSelection(ET_2.getText().length());
			}
			
		}
		else if (et_in == 8)
		{
			
			if("0123456789".contains(i)){
			
			ET_8.setText(ET_8.getText().toString() + i);
			ET_8.setSelection(ET_8.getText().length());
			}
		}
		else if (et_in == 10)
		{
			
			if("0123456789".contains(i)){
			ET_10.setText(ET_10.getText().toString() + i);
			ET_10.setSelection(ET_10.getText().length());
			}
		}
		else if (et_in == 16)
		{
			if("0123456789ABCDEFabcdef".contains(i)){
			ET_16.setText((ET_16.getText().toString() + i).toUpperCase());
			ET_16.setSelection(ET_16.getText().length());
			}
		}
	}
	
	//统一冰红茶
	public void del_text()
	{

		if (et_in == 2)
		{
			ET_2.setText("");
			//showToast("二进制框清理成功");
		}
		else if (et_in == 8)
		{
			ET_8.setText("");
			//showToast("八进制框清理成功");
			
			}
		else if (et_in == 10)
		{
			ET_10.setText("");
			//showToast("十进制框清理成功");
		}
		else if (et_in == 16)
		{
			ET_16.setText("");
			//showToast("十六进制框清理成功");
		}
	}
	
	//统一不加冰红茶
	public void del_lasttext() throws Exception
	{

		if (et_in == 2)
		{
			String text = ET_2.getText().toString();
			ET_2.setText(text.substring(0,text.length()-1));	
			ET_2.setSelection(text.length()-1);
		}
		else if (et_in == 8)
		{
			String text = ET_8.getText().toString();
			ET_8.setText(text.substring(0,text.length()-1));	
			ET_8.setSelection(text.length()-1);

		}
		else if (et_in == 10)
		{
			String text = ET_10.getText().toString();
			ET_10.setText(text.substring(0,text.length()-1));	
			ET_10.setSelection(text.length()-1);
		}
		else if (et_in == 16)
		{
			String text = ET_16.getText().toString();
			ET_16.setText(text.substring(0,text.length()-1));	
			ET_16.setSelection(text.length()-1);
		}
	}
	
	
	
//康师傅按钮点击事件
	
	public void bu_back(View v)
	{
		try
		{
			del_lasttext();
		}
		catch (Exception e)
		{
			//showToast("内容为空,无法回退");
		}
	}
	
	
	public void bu_1(View v)
	{
		add_text("1");
	}
	public void bu_2(View v)
	{
		add_text("2");
	}
	public void bu_3(View v)
	{
		add_text("3");
	}

	public void bu_4(View v)
	{
		add_text("4");
	}
	public void bu_5(View v)
	{
		add_text("5");
	}
	public void bu_6(View v)
	{
		add_text("6");
	}
	
	public void bu_7(View v)
	{
		add_text("7");
	}
	public void bu_8(View v)
	{
		add_text("8");
	}
	public void bu_9(View v)
	{
		add_text("9");
	}
	
	public void bu_0(View v)
	{
		add_text("0");
	}
	public void bu_A(View v)
	{
		add_text("A");
	}
	public void bu_B(View v)
	{
		add_text("B");
	}
	
	public void bu_C(View v)
	{
		add_text("C");
	}
	public void bu_D(View v)
	{
		add_text("D");
	}
	public void bu_E(View v)
	{
		add_text("E");
	}
	
	public void bu_F(View v)
	{
		add_text("F");
	}
	public void bu_dian(View v)
	{
		add_text(".");
	}
	
	
	@Override 
    public boolean onKeyDown(int keyCode, KeyEvent event) 
    { 
        if (keyCode == KeyEvent.KEYCODE_BACK ) 
        { 
          
			new AlertDialog.Builder(this)
				.setTitle("提示")
				.setMessage("确定要退出嘛？")
				.setNeutralButton("确定",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						finish();
					}
				}) 
				.setPositiveButton("取消", null)
				.show();
        } 

        return false; 

    } 
    
	
}
