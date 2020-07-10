package com.entity;
//’Àªß–≈œ¢
public class member {
	private int id;
	private String username;
	private String password;
	private String type;
	private String regtime;
	private String ifuse;
	private String logintims;
	private String lasttime;
	private String lastIp;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public String getIfuse() {
		return ifuse;
	}
	public void setIfuse(String ifuse) {
		this.ifuse = ifuse;
	}
	public String getLogintims() {
		return logintims;
	}
	public void setLogintims(String logintims) {
		this.logintims = logintims;
	}
	public String getLasttime() {
		return lasttime;
	}
	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}
	public String getLastIp() {
		return lastIp;
	}
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	public member() {
		super();
	}
	public member(String username, String password, String type) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
	}
	public member(String username, String password, String type, String lastIp) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
		this.lastIp = lastIp;
	}
	public member(String username, String type) {
		super();
		this.username = username;
		this.type = type;
	}
	
}
