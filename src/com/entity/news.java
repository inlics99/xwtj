package com.entity;

public class news {
	private int id;
	private String title;
	private String fenlei;
	private String content;
	private String addtime;
	private String adder;
	private int visit;
	private String gjz;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFenlei() {
		return fenlei;
	}
	public void setFenlei(String fenlei) {
		this.fenlei = fenlei;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public String getAdder() {
		return adder;
	}
	public void setAdder(String adder) {
		this.adder = adder;
	}
	public int getVisit() {
		return visit;
	}
	public void setVisit(int visit) {
		this.visit = visit;
	}
	public String getGjz() {
		return gjz;
	}
	public void setGjz(String gjz) {
		this.gjz = gjz;
	}
	public news() {
		super();
	}
	public news(String title, String fenlei, String content, String adder, String gjz) {
		super();
		this.title = title;
		this.fenlei = fenlei;
		this.content = content;
		this.adder = adder;
		this.gjz = gjz;
	}
	
}
