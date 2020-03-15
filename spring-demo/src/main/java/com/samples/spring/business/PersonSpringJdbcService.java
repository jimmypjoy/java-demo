package com.samples.spring.business;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samples.spring.data.PersonJbdcDao;
import com.samples.spring.model.Person;

@Service
public class PersonSpringJdbcService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJbdcDao dao;

	public void invokeSpringJdbcServices() throws Exception {

//		logger.info("All users -> {}", dao.findAll());
//
//		logger.info("User id 10001 -> {}", dao.findById(10001));
//
//		logger.info("Deleting 10002 -> No of Rows Deleted - {}", dao.deleteById(10002));

		logger.info("Inserting 10004 -> {}", dao.insert(new Person(10004, "jim", "joy", new Date())));

//		logger.info("Update 10003 -> {}", dao.update(new Person(10003, "first", "last", new Date())));

	}
}
