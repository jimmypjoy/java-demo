package com.example.springdemo1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samples.junit.spring.business.ItemBusinessService;
import com.samples.junit.spring.model.Item;

@RestController
public class JunitTestController {

	@Autowired
	private ItemBusinessService businessService;

	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1, "Ball", 10, 100);
	}

	@GetMapping("/item-from-business-service")
	public Item itemFromBusinessService() {
		Item item = businessService.retreiveHardcodedItem();

		return item;
	}

//	@GetMapping("/all-items-from-database")
//	public List<Item> retrieveAllItems() {
//		return businessService.retrieveAllItems();
//	}

	@GetMapping("/junit")
	public String juntTest() {
		return "test junit";
	}
}
