package com.example.demo;

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
	
	private final StudentRep studentRepo;
	
	public StudentController(StudentRep studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	@PostMapping
	public StudentEntity saveStudent(@RequestBody StudentEntity student) {
		return studentRepo.save(student);
	}
	
	@GetMapping
	public List<StudentEntity> getAll(){
		return studentRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public StudentEntity getById(@PathVariable Long id) {
		return studentRepo.findById(id).orElse(null);
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable Long id) {
		if(studentRepo.existsById(id)) {
			studentRepo.deleteById(id);
			return "Successfully deleted Student by id: "  + id;
		}else {
			return "Can't find student ny id: " + id;
		}
	}
	
	
	
	

}
