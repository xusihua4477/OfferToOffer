package com.offertooffer.demo.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import cn.bmob.im.BmobUserManager;
import cn.bmob.im.bean.BmobChatUser;
import cn.bmob.v3.listener.SaveListener;

import com.offertooffer.demo.R;
import com.offertooffer.demo.adapter.base.ViewHolder;
import com.offertooffer.demo.bean.Record_YingPin;

/**
 * 设置昵称和性别
 * 
 * @ClassName: SetNickAndSexActivity
 * @Description: TODO
 * @author smile
 * @date 2014-6-7 下午4:03:40
 */

public class PublishTuiJianLiActivity extends ActivityBase {

	EditText etAge;
	EditText etExperience;
	EditText etSalary;
	RadioButton radioSex;
	RadioButton radioDaZhuan;
	RadioButton radioBenKe;
	RadioButton radioShuoShi;
	private EditText etTuijian_reasion;
	Spinner spinner_citys;
	EditText etZhongjiefei;
	View view;
	private int age;
	private int experience;
	private int salary;
	private int zhongjiefei;
	private Boolean sex;
	private String city;
	private String tuijianren_name;
	private String qualifications;

	private String recommend_reason;
	private EditText etJob;
	private String zhiwei;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send_push_rencai_record);
		initView();
	}

	private void initView() {

		etAge = (EditText) findViewById(R.id.etAge);
		etJob = (EditText) findViewById(R.id.etJob);
		etExperience = (EditText) findViewById(R.id.etexperience);
		etSalary =(EditText) findViewById(R.id.etSalary);
		etTuijian_reasion = (EditText) findViewById(R.id.etTuijian_reasion);
		radioSex = (RadioButton) findViewById(R.id.rbMale);
		 radioDaZhuan = (RadioButton) findViewById(R.id.rbDazhuan);
		radioBenKe = (RadioButton) findViewById(R.id.rbBenKe);
		radioShuoShi = (RadioButton) findViewById(R.id.rbShuoshi);
		etZhongjiefei = (EditText) findViewById(R.id.etZhongjiefei);
		spinner_citys=(Spinner) findViewById(R.id.spinner_citys);
	}

	public void btn_publish(View view) {
		boolean validateDate = validateDate();

		if (!validateDate) {
			return;
		}

		userManager = BmobUserManager.getInstance(getApplicationContext());
		BmobChatUser currentUser = userManager.getCurrentUser();
		String username = currentUser.getUsername();
		
		String objectId = currentUser.getObjectId();
		Record_YingPin yingPinlist = new Record_YingPin(city, objectId, recommend_reason, age, experience, salary, zhongjiefei, sex, qualifications, username, zhiwei);
		yingPinlist.save(this, new SaveListener() {
			
			@Override
			public void onSuccess() {
				// TODO Auto-generated method stub
				System.out.println("悬赏记录创建成功");
				System.out.println("悬赏记录创建成功");
			}
			
			@Override
			public void onFailure(int arg0, String arg1) {
				// TODO Auto-generated method stub
				System.out.println("悬赏记录创建失败"+arg1);
				System.out.println("悬赏记录创建失败"+arg1);
				System.out.println("悬赏记录创建失败"+arg1);
				
			}
		});
		
	}
	public   <T> T findViewbyid_mine(T t,int id){
		View view1 =findViewById(id);
		
		return   (T) view1;
	}
	private boolean validateDate() {
		String age1 = etAge.getText().toString();
		age = Integer.parseInt(age1);
		experience = Integer.parseInt(etExperience.getText().toString());
		salary = Integer.parseInt(etSalary.getText().toString());
		zhongjiefei = Integer.parseInt(etZhongjiefei.getText().toString());
		 recommend_reason = etTuijian_reasion.getText().toString();
		 zhiwei = etJob.getText().toString();
		 
		 
		 if(spinner_citys.getSelectedItem()!=null){
			 
			 city = spinner_citys.getSelectedItem().toString();
		 }else{
			 city ="北京";
			 
		 }
		
		if (radioSex.isChecked()) {
			sex=true;
		} else {
			sex=false;
		}
		if (radioBenKe.isChecked()) {
			 qualifications=radioBenKe.getText().toString();
		}
       
		if (radioDaZhuan.isChecked()) {
			qualifications=radioDaZhuan.getText().toString();
		}
		
		if (radioShuoShi.isChecked()) {
			qualifications=radioShuoShi.getText().toString();
		}
		
		return true;
		// TODO Auto-generated method stub

	}

	public void btn_return(View view) {

		finish();

	}
}
