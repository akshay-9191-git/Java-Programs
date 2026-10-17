package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	private List<StudentInfo> students = new ArrayList<>() ;
	
	@PostMapping
	public String addStudent(@RequestBody  StudentInfo student) {
		students.add(student);
		return "Student Details added successfully";
	}
	
	@GetMapping
	public List<StudentInfo> getAllStudents(){
		return students;
	}
	
	@GetMapping("/{id}")
	public StudentInfo getStudnetByid(@PathVariable int id) {
		for(StudentInfo s: students) {
			if(s.getId() == id) {
				return s;
			}
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public String deletebyid(@PathVariable int id) {
		boolean removed = students.removeIf(s-> s.getId() == id);
		if(removed) {
			return "Student Details successfully deleted by id : " + id;
		}else {
			return "No Student with id: "+ id + "found in the list";
		}
	}

}
