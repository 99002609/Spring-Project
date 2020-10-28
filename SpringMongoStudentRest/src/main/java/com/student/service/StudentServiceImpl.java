package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentRepository;
import com.student.exceptions.StudentNotFoundException;
import com.student.model.Student;
@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
    StudentRepository studentRepository;

	public StudentServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Student addStudent(Student student) {
		Student newStudent=studentRepository.save(student);
		return newStudent;
	}

	
	@Override
	public Student getStudentById(Integer id) throws StudentNotFoundException {
		return studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Id not available") );
	
	}

	@Override
	public boolean deleteStudentById(Integer id) {
		studentRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Student> findByAddressCity(String city) throws StudentNotFoundException {
		List<Student> studentList=studentRepository.findByAddressCity(city);
		if( studentList.isEmpty())
		{
			throw new StudentNotFoundException("invalid city");
		}
		return studentList;

	}

	@Override
	public List<Student> findByDepartment(String department) throws StudentNotFoundException {
		List<Student> studentList=studentRepository.findByDepartment(department);
		if( studentList.isEmpty())
		{
			throw new StudentNotFoundException("Invalid department");
		}
		return studentList;

	}

	@Override
	public List<Student> findByAge(int age)  {
		List<Student> studentList=studentRepository.findByAge(age);
				return studentList;

	}

	@Override
	public List<Student> getAllStudents() {
				return studentRepository.findAll();

	}

}
