package com.samples.spring.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samples.spring.model.Person;

@Repository
public interface PersonSpringDataRepository 
				extends JpaRepository<Person, Integer>{
}
