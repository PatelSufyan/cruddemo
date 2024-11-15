package com.cruddemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.cruddemo.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
