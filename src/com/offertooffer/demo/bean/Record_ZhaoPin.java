package com.offertooffer.demo.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.a.a.This;

/**
 * 
 * @author asan �洢��ҵ��������Ƹ��¼
 * 
 */
public class Record_ZhaoPin extends BmobObject implements Serializable{
	String city;
	/**
	 * �����ߵ�id
	 */
	String object_id;
	String company_name;
	String zhiwei;
	/**
	 * ����ְ�ߵľ���Ҫ��
	 */
	String description;

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getZhiwei() {
		return zhiwei;
	}

	public void setZhiwei(String zhiwei) {
		this.zhiwei = zhiwei;
	}

	int work_years;
	int salary_least;
	int salary_most;
	/**
	 * ���ͽ��
	 */
	int zhongjiefei;
	Boolean sex=true;
	/**
	 * xueli,ѧ��
	 */
	String qualifications;

	/**
	 * �Ƿ��Ѿ��򱾹�˾�ύ���ͽ�(���ͽ�) �ͽ�ѹ�ڹ�˾,�ȴ��ɽ�
	 */
	Boolean isOfferdToMe = false;
	/**
	 * �Ƿ��Ѿ��򱾹�˾�ύ���ͽ�(���ͽ�) �ͽ�ѹ�ڹ�˾,�ȴ��ɽ�
	 */
	Boolean is_offerdToZhongJie = false;

	public Record_ZhaoPin(String city, String object_id, String description,
			int work_years, int salary_least, int salary_most, int zhongjiefei,
			String qualifications,String zhiwei,String company_name) {
		super();
		this.city = city;
		this.object_id = object_id;
		this.description = description;
		this.work_years = work_years;
		this.salary_least = salary_least;
		this.salary_most = salary_most;
		this.zhongjiefei = zhongjiefei;
		this.company_name=company_name;
		this.qualifications = qualifications;
		this.zhiwei=zhiwei;
	}

	public Record_ZhaoPin() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getWork_years() {
		return work_years;
	}

	public void setWork_years(int work_years) {
		this.work_years = work_years;
	}

	public int getSalary_least() {
		return salary_least;
	}

	public void setSalary_least(int salary_least) {
		this.salary_least = salary_least;
	}

	public int getSalary_most() {
		return salary_most;
	}

	public void setSalary_most(int salary_most) {
		this.salary_most = salary_most;
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

	public Boolean getIsOfferdToMe() {
		return isOfferdToMe;
	}

	public void setIsOfferdToMe(Boolean isOfferdToMe) {
		this.isOfferdToMe = isOfferdToMe;
	}

	public Boolean getIs_offerdToZhongJie() {
		return is_offerdToZhongJie;
	}

	public void setIs_offerdToZhongJie(Boolean is_offerdToZhongJie) {
		this.is_offerdToZhongJie = is_offerdToZhongJie;
	}

	@Override
	public String toString() {
		String xingbie=null;
		if (this.sex) {
			xingbie="��";
		} else {
			xingbie="Ů";

		}
	
		return  work_years + "������/��н"
				+ salary_least + "��" + salary_most + "k /"
				+ xingbie + "/ѧ�� " + qualifications ;
	}


	

}
