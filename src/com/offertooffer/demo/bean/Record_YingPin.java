package com.offertooffer.demo.bean;

import cn.bmob.v3.BmobObject;
/**
 * 
 * @author asan
 * �洢ӦƸ��¼
 *
 */
public class Record_YingPin extends BmobObject {
	@Override
	public String toString() {
		String xingbie ="��";
		if (!this.sex) {
			xingbie ="Ů";
		} 
		
		return   age+"�� "
				+ "/" + work_years + "�꾭��/н��" + salary
				+  "/" + xingbie
				+ "/" + qualifications 
				;
	}


	String city;
	/**
	 * �����ߵ�id
	 */
	String object_id;
	String recommend_reason;
	/**
	 * ���Ƽ��˵�����
	 */
	int age;
	int work_years;
    int  salary;
	/**
	 * ���ͽ��
	 */
	int zhongjiefei;
	Boolean sex;
	/**
	 * xueli,ѧ��
	 */
	String qualifications;
	String zhiwei;
/**
 * �Ƽ�������
 */
String tuijianren;
	




	public Record_YingPin(String city, String object_id,
			String recommend_reason, int age, int work_years, int salary,
			int zhongjiefei, Boolean sex2, String qualifications,String tuijianren,String job) {
		super();
		
		this.tuijianren=tuijianren;
		this.city = city;
		this.object_id = object_id;
		this.recommend_reason = recommend_reason;
		this.age = age;
		this.work_years = work_years;
		this.salary = salary;
		this.zhongjiefei = zhongjiefei;
		this.sex = sex2;
		this.qualifications = qualifications;
		this.zhiwei=job;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getZhiwei() {
		return zhiwei;
	}


	public void setZhiwei(String zhiwei) {
		this.zhiwei = zhiwei;
	}


	public String getTuijianren() {
		return tuijianren;
	}


	public void setTuijianren(String tuijianren) {
		this.tuijianren = tuijianren;
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
