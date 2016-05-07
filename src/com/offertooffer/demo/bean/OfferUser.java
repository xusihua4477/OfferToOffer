package com.offertooffer.demo.bean;

import java.util.List;

import cn.bmob.v3.datatype.BmobRelation;

public class OfferUser extends User {
	/**
	 * 发布者的信用
	 */
	int credit;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 0表示招聘单位注册，1表示推荐人注册
	 */
	int userType;


	/**
	 * 其他人对发布者的评价
	 */
	List<PingJia> pingjia_list;

	public OfferUser(String username, int userType, Boolean sex, int credit) {
		super();
		this.userType = userType;
		this.setSex(sex);
		this.credit = credit;
		this.setUsername(username);
	}
	



	public int getCredit() {
		return credit;
	}




	public void setCredit(int credit) {
		this.credit = credit;
	}




	public int getUserType() {
		return userType;
	}




	public void setUserType(int userType) {
		this.userType = userType;
	}




	public List<PingJia> getPingjia_list() {
		return pingjia_list;
	}




	public void setPingjia_list(List<PingJia> pingjia_list) {
		this.pingjia_list = pingjia_list;
	}




	public OfferUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
