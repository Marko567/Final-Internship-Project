package com.eng.marko.manojlovic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eng.marko.manojlovic.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
