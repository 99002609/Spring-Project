package com.student.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.exceptions.StudentNotFoundException;
import com.student.model.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/student-api")
public class StudentResponseController {
	@Autowired
	StudentService studentService;
	@PostMapping("/students")
	 ResponseEntity<Student> addStudent(@RequestBody Student student)
	 {
		Student stud=studentService.addStudent(student);
		return ResponseEntity.ok(stud);
	 }
	
	@DeleteMapping("/students/delete-one/{studentId}")
	ResponseEntity<Boolean> deleteStudentById(@PathVariable("studentId")Integer studentId) {
		studentService.deleteStudentById(studentId);
		return ResponseEntity.status(HttpStatus.OK).build();

	}
	@GetMapping("/students/get-one/{studentId}")
	ResponseEntity<Student> getStudentById(@PathVariable("studentId") Integer studentId) throws StudentNotFoundException
	 {
		Student Stud=studentService.getStudentById(studentId);
		HttpHeaders header=new HttpHeaders();
		header.add("desc", "Getting Student By Id");
		header.add("title", "One Student");
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(Stud);
	 }
	
	 @GetMapping("/students")
	 ResponseEntity<List<Student>> getAllStudents()
	 {
		 List<Student> studentList=studentService.getAllStudents();
		 return ResponseEntity.ok(studentList);
	 }
	@GetMapping("/students/city/{city}")
	 ResponseEntity<List<Student>> findBycity(@PathVariable("city")String city) throws StudentNotFoundException{
	        List<Student> cityList =   studentService.findByAddressCity(city);
	        return ResponseEntity.ok(cityList);
	    }
	 @GetMapping("/students/department/{department}")
	 ResponseEntity<List<Student>> findByDepartment(@PathVariable("department")String department)throws StudentNotFoundException{
	        List<Student> departmentList = studentService.findByDepartment(department);    
	        return ResponseEntity.ok(departmentList);
	    }
	 @GetMapping("/students/age/{age}")
	 public ResponseEntity<List<Student>> findByAge(@PathVariable("age")int age) {
	        List<Student> ageList = studentService.findByAge(age);
	        return ResponseEntity.ok(ageList);
	        
	    }
	


}


