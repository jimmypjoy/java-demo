package com.samples.spring.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samples.spring.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
