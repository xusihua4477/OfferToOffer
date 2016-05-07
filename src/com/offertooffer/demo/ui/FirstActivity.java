package com.offertooffer.demo.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.offertooffer.demo.R;

public class FirstActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
	setContentView(R.layout.activity_first);
	
	
	}
	public void btn_needRen(View view){
		
		
		
		
	}
	public void btn_pushRen(View view){
		
		Intent i= new Intent(this, PublishTuiJianLiActivity.class);
		
		startActivity(i);
		finish();
		
		
	}
	public void btn_look_records(View view){
		
		
		
		
	}
}
