package com.offertooffer.demo.bean;

import cn.bmob.v3.BmobObject;

public class PingJia extends BmobObject {
	String pingjia;
	String author;
	Boolean isNiMing;
	/**
	 * 好评度从1到5
	 */
	int haopingdu;

	public PingJia(String pingjia, String author, Boolean isNiMing,
			int haopingdu) {
		super();
		this.pingjia = pingjia;
		this.author = author;
		this.isNiMing = isNiMing;
		this.haopingdu = haopingdu;

	}

	public PingJia(String pingjia, String author, Boolean isNiMing) {
		super();
		this.pingjia = pingjia;
		this.author = author;
		this.isNiMing = isNiMing;
	}

	public PingJia() {
	}

	public String getPingjia() {
		return pingjia;
	}

	public void setPingjia(String pingjia) {
		this.pingjia = pingjia;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Boolean getIsNiMing() {
		return isNiMing;
	}

	public void setIsNiMing(Boolean isNiMing) {
		this.isNiMing = isNiMing;
	}

}
