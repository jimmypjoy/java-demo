package com.samples.junit.spring.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.samples.junit.spring.data.ItemRepository;
import com.samples.junit.spring.data.ItemRepository2;
import com.samples.junit.spring.model.Item;

@Component
public class ItemBusinessService {
	
	@Autowired
	private ItemRepository2 repository;
	
	public Item retreiveHardcodedItem() {
		return new Item(1, "Ball", 10, 100);
	}
	
//	public List<Item> retrieveAllItems() {
//		List<Item> items = repository.findAll();
//		
//		for(Item item:items) {
//			item.setValue(item.getPrice() * item.getQuantity());
//		}
//		
//		return items;	
//		return null;
//	}
	
}
