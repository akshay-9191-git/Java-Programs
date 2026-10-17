package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRep extends JpaRepository<StudentEntity , Long> {

}
