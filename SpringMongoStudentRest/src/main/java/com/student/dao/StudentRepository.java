package com.student.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.exceptions.StudentNotFoundException;
import com.student.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student,Integer>{

		List<Student> findByAddressCity(String city) throws StudentNotFoundException;
		List<Student> findByDepartment(String department) ;
		@Query("{'age':{$gt:?0}}")
		List<Student> findByAge(int age);
}
