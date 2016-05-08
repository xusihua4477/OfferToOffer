package com.offertooffer.demo.ui;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.offertooffer.demo.R;
import com.offertooffer.demo.adapter.ShowTuiJianAdapter;
import com.offertooffer.demo.bean.Record_YingPin;

public class FirstActivity extends Activity{
	ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	
	
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
