package com.entity;

public class affiche {
	private int id;
	private String title;
	private String content;
	private String addtime;
	private String adder;
	private String ifhide;
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
	public String getIfhide() {
		return ifhide;
	}
	public void setIfhide(String ifhide) {
		this.ifhide = ifhide;
	}
	public affiche() {
		super();
	}
	public affiche(String title, String content, String adder, String ifhide) {
		super();
		this.title = title;
		this.content = content;
		this.adder = adder;
		this.ifhide = ifhide;
	}
	public affiche(int id, String title, String content, String adder, String ifhide) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.adder = adder;
		this.ifhide = ifhide;
	}
	
}
