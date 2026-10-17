package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class StudentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private String name;
	private String course;
	private int rollno;
	
	public StudentEntity() {
		
	}
	
	public StudentEntity(String name , String course , int rollno) {
		this.name = name;
		this.course = course;
		this.rollno = rollno;
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
