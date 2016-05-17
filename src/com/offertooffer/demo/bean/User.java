package com.offertooffer.demo.bean;



import java.util.List;

import cn.bmob.im.bean.BmobChatUser;
import cn.bmob.v3.datatype.BmobGeoPoint;
import cn.bmob.v3.datatype.BmobRelation;

/** 重载BmobChatUser对象：若还有其他需要增加的属性可在此添加
  * @ClassName: TextUser
  * @Description: TODO
  * @author smile
  * @date 2014-5-29 下午6:15:45
  */
public class User extends BmobChatUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 发布的博客列表
	 */
	private BmobRelation blogs;
	
	/**
	 * //显示数据拼音的首字母
	 */
	private String sortLetters;
	
	/**
	 * //性别-true-男
	 */
	private Boolean sex;
	
	private Blog blog;
	/**
	 * 0表示招聘单位注册，1表示推荐人注册
	 */
	int userType;
	/**
	 * 发布者的信用
	 */
	int credit;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public User(String username, int userType, Boolean sex, int credit) {
		super();
		this.userType = userType;
		this.setSex(sex);
		this.credit = credit;
		this.setUsername(username);
	}
	
	/**
	 * 0表示招聘单位注册，1表示推荐人注册,2表示获取类型未知（网络连接失败不知道什么类型）
	 */
	public int getUserType() {
		return userType;
	}
	/**
	 * 0表示招聘单位注册，1表示推荐人注册
	 */
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public List<PingJia> getPingjia_list() {
		return pingjia_list;
	}
	public void setPingjia_list(List<PingJia> pingjia_list) {
		this.pingjia_list = pingjia_list;
	}
	/**
	 * 其他人对发布者的评价
	 */
	List<PingJia> pingjia_list;
	/**
	 * 地理坐标
	 */
	private BmobGeoPoint location;//
	
	private Integer hight;
	
	
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public Integer getHight() {
		return hight;
	}
	public void setHight(Integer hight) {
		this.hight = hight;
	}
	public BmobRelation getBlogs() {
		return blogs;
	}
	public void setBlogs(BmobRelation blogs) {
		this.blogs = blogs;
	}
	public BmobGeoPoint getLocation() {
		return location;
	}
	public void setLocation(BmobGeoPoint location) {
		this.location = location;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public String getSortLetters() {
		return sortLetters;
	}
	public void setSortLetters(String sortLetters) {
		this.sortLetters = sortLetters;
	}
	
}
