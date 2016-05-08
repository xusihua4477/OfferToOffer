package com.offertooffer.demo.ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import cn.bmob.im.bean.BmobChatUser;
import cn.bmob.v3.listener.SaveListener;

import com.offertooffer.demo.R;
import com.offertooffer.demo.bean.Record_YingPin;
import com.offertooffer.demo.bean.Record_ZhaoPin;
import com.offertooffer.demo.ui.fragment.ZhaoPinListFragment;

public class PublishZhaoPinActivity extends ActivityBase {

	EditText etExperience;
	EditText etSalaryLeast;
	EditText etSalaryMax;
	RadioButton radioDaZhuan;
	RadioButton radioBenKe;
	RadioButton radioShuoShi;
	EditText etJob_description;
	Spinner spinner_citys;
	EditText etZhongjiefei;
	EditText etZhiwei;

	private int experience;
	private int salaryleast;
	private int salarymax;
	private int zhongjiefei;
	private Boolean sex;
	private String city;
	private String qualifications;

	private String job_descrption;
	private String zhiwei;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_fill_zhaopinlist);

		initView();
	}

	public <T> T findViewById_Mine(T t, int id) {
		return t;
	}

	private void initView() {
		// TODO Auto-generated method stub

		etExperience = (EditText) findViewById(R.id.etexperience);
		etSalaryLeast = (EditText) findViewById(R.id.etSalaryLeast);
		etSalaryMax = (EditText) findViewById(R.id.etSalaryMax);
		etZhiwei = (EditText) findViewById(R.id.etZhiwei);
		etJob_description = (EditText) findViewById(R.id.ablility_description);
		radioDaZhuan = (RadioButton) findViewById(R.id.rbDazhuan);
		radioBenKe = (RadioButton) findViewById(R.id.rbBenKe);
		radioShuoShi = (RadioButton) findViewById(R.id.rbShuoshi);
		etZhongjiefei = (EditText) findViewById(R.id.etZhongjiefei);
		spinner_citys = (Spinner) findViewById(R.id.spinner_citys);
	}

	public void btn_Publish(View view) {

		experience = Integer.parseInt(etExperience.getText().toString());
		salaryleast = Integer.parseInt(etSalaryLeast.getText().toString());
		salarymax = Integer.parseInt(etSalaryMax.getText().toString());
		zhongjiefei = Integer.parseInt(etZhongjiefei.getText().toString());
		zhiwei = etZhiwei.getText().toString();
		job_descrption = etJob_description.getText().toString();
	
		if (spinner_citys.getSelectedItem() != null) {

			city = spinner_citys.getSelectedItem().toString();
		} else {
			city = "北京";
		}

		if (radioBenKe.isChecked()) {
			qualifications = radioBenKe.getText().toString();
		}

		if (radioDaZhuan.isChecked()) {
			qualifications = radioDaZhuan.getText().toString();
		}

		if (radioShuoShi.isChecked()) {
			qualifications = radioShuoShi.getText().toString();
		}
		BmobChatUser currentUser = userManager.getCurrentUser();
     
		
		String objectId = currentUser.getObjectId();
		String username = currentUser.getUsername();
		Record_ZhaoPin record_ZhaoPin = new Record_ZhaoPin(city, objectId,
				job_descrption, experience, salaryleast, salarymax,
				zhongjiefei, qualifications,zhiwei,username);

		record_ZhaoPin.save(this, new SaveListener() {

			@Override
			public void onSuccess() {
				// TODO Auto-generated method stub
				System.out.println("悬赏记录创建成功");
				System.out.println("悬赏记录创建成功");
			}

			@Override
			public void onFailure(int arg0, String arg1) {
				// TODO Auto-generated method stub
				System.out.println("悬赏记录创建失败" + arg1);
				System.out.println("悬赏记录创建失败" + arg1);
				System.out.println("悬赏记录创建失败" + arg1);

			}
		});

	}

	public void btn_Return(View view) {
      finish();
      
	}
}
