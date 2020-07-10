package com.entity;

public class COM {
	private int id;
	private String mc;
	private String dz;
	
	private String fenlei;
	private String title;
	private String member;
	private String sj;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public String getDz() {
		return dz;
	}
	public void setDz(String dz) {
		this.dz = dz;
	}
	public String getFenlei() {
		return fenlei;
	}
	public void setFenlei(String fenlei) {
		this.fenlei = fenlei;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public String getSj() {
		return sj;
	}
	public void setSj(String sj) {
		this.sj = sj;
	}
	
	public COM(int id, String mc, String dz) {
		super();
		this.id = id;
		this.mc = mc;
		this.dz = dz;
	}
	public COM(String mc, String dz) {
		super();
		this.mc = mc;
		this.dz = dz;
	}
	public COM(int id) {
		super();
		this.id = id;
	}
	public COM() {
		super();
	}
	public COM(String fenlei, String title, String member, String sj) {
		super();
		this.fenlei = fenlei;
		this.title = title;
		this.member = member;
		this.sj = sj;
	}
	public void ft(String fl,String tt) {
		this.fenlei=fl;
		this.title=tt;
	}
	
	
	
}
