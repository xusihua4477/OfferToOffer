package com.offertooffer.demo.bean;



import java.util.List;

import cn.bmob.im.bean.BmobChatUser;
import cn.bmob.v3.datatype.BmobGeoPoint;
import cn.bmob.v3.datatype.BmobRelation;

/** ����BmobChatUser����������������Ҫ���ӵ����Կ��ڴ����
  * @ClassName: TextUser
  * @Description: TODO
  * @author smile
  * @date 2014-5-29 ����6:15:45
  */
public class User extends BmobChatUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * �����Ĳ����б�
	 */
	private BmobRelation blogs;
	
	/**
	 * //��ʾ����ƴ��������ĸ
	 */
	private String sortLetters;
	
	/**
	 * //�Ա�-true-��
	 */
	private Boolean sex;
	
	private Blog blog;
	/**
	 * 0��ʾ��Ƹ��λע�ᣬ1��ʾ�Ƽ���ע��
	 */
	int userType;
	/**
	 * �����ߵ�����
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
	 * 0��ʾ��Ƹ��λע�ᣬ1��ʾ�Ƽ���ע��,2��ʾ��ȡ����δ֪����������ʧ�ܲ�֪��ʲô���ͣ�
	 */
	public int getUserType() {
		return userType;
	}
	/**
	 * 0��ʾ��Ƹ��λע�ᣬ1��ʾ�Ƽ���ע��
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
	 * �����˶Է����ߵ�����
	 */
	List<PingJia> pingjia_list;
	/**
	 * ��������
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
