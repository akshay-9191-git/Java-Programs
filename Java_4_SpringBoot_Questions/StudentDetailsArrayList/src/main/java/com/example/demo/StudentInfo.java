package com.example.demo;

public class StudentInfo {
	private int id;
	private String name;
	private String course;
	private int rollno ;
	
	public StudentInfo() {
		
	}
	
	public StudentInfo(int id , String name , String course , int rollno) {
		this.id = id;
		this.name = name;
		this.course = course;
		this.rollno = rollno;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	public int getRoll() {
		return rollno;
	}
	public void setRoll(int rollno) {
		this.rollno = rollno;
	}

}
