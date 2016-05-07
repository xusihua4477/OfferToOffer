package com.offertooffer.demo.bean;

import cn.bmob.v3.BmobObject;
/**
 * 
 * @author asan
 * 存储应聘记录
 *
 */
public class Record_YingPin extends BmobObject {
	String city;
	/**
	 * 发布者的id
	 */
	String object_id;
	String recommend_reason;
	/**
	 * 被推荐人的年龄
	 */
	int age;
	int work_years;
    int  salary;
	/**
	 * 悬赏金额
	 */
	int zhongjiefei;
	Boolean sex;
	/**
	 * xueli,学历
	 */
	String qualifications;


	public Record_YingPin(String city, String object_id,
			String recommend_reason, int age, int work_years, int salary,
			int zhongjiefei, Boolean sex2, String qualifications) {
		super();
		this.city = city;
		this.object_id = object_id;
		this.recommend_reason = recommend_reason;
		this.age = age;
		this.work_years = work_years;
		this.salary = salary;
		this.zhongjiefei = zhongjiefei;
		this.sex = sex2;
		this.qualifications = qualifications;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getObject_id() {
		return object_id;
	}


	public void setObject_id(String object_id) {
		this.object_id = object_id;
	}


	public String getRecommend_reason() {
		return recommend_reason;
	}


	public void setRecommend_reason(String recommend_reason) {
		this.recommend_reason = recommend_reason;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getWork_years() {
		return work_years;
	}


	public void setWork_years(int work_years) {
		this.work_years = work_years;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public int getZhongjiefei() {
		return zhongjiefei;
	}


	public void setZhongjiefei(int zhongjiefei) {
		this.zhongjiefei = zhongjiefei;
	}


	public Boolean getSex() {
		return sex;
	}


	public void setSex(Boolean sex) {
		this.sex = sex;
	}


	public String getQualifications() {
		return qualifications;
	}


	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	
	
	
	
	

}
