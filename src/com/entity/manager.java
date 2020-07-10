package com.entity;

import java.util.Date;

public class manager {
	private int id;
	private String username;
	private String password;
	private Date createtime;
	private String flag;
	private String isuse;
	private String logintimes;
	private String quanxian;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getIsuse() {
		return isuse;
	}
	public void setIsuse(String isuse) {
		this.isuse = isuse;
	}
	public String getLogintimes() {
		return logintimes;
	}
	public void setLogintimes(String logintimes) {
		this.logintimes = logintimes;
	}
	public String getQuanxian() {
		return quanxian;
	}
	public void setQuanxian(String quanxian) {
		this.quanxian = quanxian;
	}
	public manager() {
		super();
	}
	
}
