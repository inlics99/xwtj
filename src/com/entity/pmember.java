package com.entity;
//用户个人信息
public class pmember {
	private String id;
	private String mid;
	private String realname;
	private String sex;
	private String bir;
	private String sheng;
	private String city;
	private String telphone;
	private String email;
	private String question;
	private String answer;
	private String address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBir() {
		return bir;
	}
	public void setBir(String bir) {
		this.bir = bir;
	}
	public String getSheng() {
		return sheng;
	}
	public void setSheng(String sheng) {
		this.sheng = sheng;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public pmember() {
		super();
	}
	public pmember(String realname, String sex, String bir, String sheng, String city, String telphone,
			String email, String question, String answer, String address) {
		super();
		this.realname = realname;
		this.sex = sex;
		this.bir = bir;
		this.sheng = sheng;
		this.city = city;
		this.telphone = telphone;
		this.email = email;
		this.question = question;
		this.answer = answer;
		this.address = address;
	}
	public pmember(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}
	
	
}
