package com.cruddemo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cruddemo.entity.Student;
import com.cruddemo.repository.StudentRepository;

@SpringBootTest
class CruddemoApplicationTests {

	@Autowired
	private StudentRepository studentRepo;

	@Test
	void studentReg() {
		Student s = new Student();
		s.setName("John");
		s.setCourse("Testing");
		s.setFee(12000);
		studentRepo.save(s);
	}
	
	@Test
	void deleteById() {
		studentRepo.deleteById(10L);
	}
	
	@Test
	void findOneStudent() {
		Optional<Student> findById = studentRepo.findById(2L);
		Student student = findById.get();
		System.out.println(student.getName());
		System.out.println(student.getCourse());
		System.out.println(student.getFee());
	}
	
	@Test
	void updateOneStudent() {
		Optional<Student> findById = studentRepo.findById(2L);
		Student student = findById.get();
		student.setCourse("Development");
		
		studentRepo.save(student);
	}
	
	@Test
	void getAllStudents() {
		Iterable<Student> findAll = studentRepo.findAll();
		System.out.println(findAll);
		for(Student student : findAll) {
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getCourse());
			System.out.println(student.getFee());
		}
	}
	
}
