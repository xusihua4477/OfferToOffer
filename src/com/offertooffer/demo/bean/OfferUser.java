package com.offertooffer.demo.bean;

import java.util.List;

import cn.bmob.v3.datatype.BmobRelation;

public class OfferUser extends User {
	/**
	 * �����ߵ�����
	 */
	int credit;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 0��ʾ��Ƹ��λע�ᣬ1��ʾ�Ƽ���ע��
	 */
	int userType;


	/**
	 * �����˶Է����ߵ�����
	 */
	List<PingJia> pingjia_list;

	public OfferUser(String username, int userType, Boolean sex, int credit) {
		super();
		this.userType = userType;
		this.setSex(sex);
		this.credit = credit;
		this.setUsername(username);
	}
	



	public OfferUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
