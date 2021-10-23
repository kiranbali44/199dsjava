package com.mph.model;

public class Employee {
	private int emno;
	private String emname;
	private String dept;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int emno, String emname, String dept) {
		super();
		this.emno = emno;
		this.emname = emname;
		this.dept = dept;
	}
	public int getEmno() {
		return emno;
	}
	public void setEmno(int emno) {
		this.emno = emno;
	}
	public String getEmname() {
		return emname;
	}
	public void setEmname(String emname) {
		this.emname = emname;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [emno=" + emno + ", emname=" + emname + ", dept=" + dept + "]";
	}

}
