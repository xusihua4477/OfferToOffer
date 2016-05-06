package com.offertooffer.demo.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.offertooffer.demo.R;
import com.offertooffer.demo.adapter.base.ViewHolder;
import com.offertooffer.demo.bean.Record_ZhaoPin;

/**
 * 设置昵称和性别
 * 
 * @ClassName: SetNickAndSexActivity
 * @Description: TODO
 * @author smile
 * @date 2014-6-7 下午4:03:40
 */

public class CreateNewSimpleJianLiActivity extends ActivityBase {

	EditText etAge;
	EditText etExperience;
	EditText etSalary;
	Spinner spinner_citys;
	EditText etZhongjiefei;
	View view;
	private int age;
	private int experience;
	private int salary;
	private int zhongjiefei;
	private String city;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send_push_rencai_record);

	}

	private void initView() {

		view = View.inflate(this, R.layout.send_push_rencai_record, null);
		etAge = findViewbyid_mine(etAge, R.id.etAge, view);
		etExperience = findViewbyid_mine(etExperience, R.id.etexperience, view);
		etSalary = findViewbyid_mine(etSalary, R.id.etSalary, view);
		etZhongjiefei = findViewbyid_mine(etZhongjiefei, R.id.etZhongjiefei,
				view);

	}

	public void btn_publish(View view) {
		boolean validateDate = validateDate();

		if (!validateDate) {
			return;
		}

	}

	private boolean validateDate() {
         age = Integer.parseInt(etAge.getText().toString());
         experience = Integer.parseInt(etExperience.getText().toString());
         salary = Integer.parseInt(etSalary.getText().toString());
         zhongjiefei = Integer.parseInt(etZhongjiefei.getText().toString());
           city = spinner_citys.getSelectedItem().toString();
           new Record_ZhaoPin()；
		return true;
		// TODO Auto-generated method stub

	}

	public void btn_return(View view) {

		finish();

	}
}
