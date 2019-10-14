package com.example.demo.bean;

import java.io.Serializable;

public class Week2 implements Serializable{
	private int gid;
	private String gname;
	private String age;
	private String bfb;
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBfb() {
		return bfb;
	}
	public void setBfb(String bfb) {
		this.bfb = bfb;
	}
	@Override
	public String toString() {
		return "Week2 [gid=" + gid + ", gname=" + gname + ", age=" + age + ", bfb=" + bfb + "]";
	}
	public Week2(int gid, String gname, String age, String bfb) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.age = age;
		this.bfb = bfb;
	}
	public Week2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
