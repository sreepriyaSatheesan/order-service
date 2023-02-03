package com.foodhub.orderDetailsRepository;

import com.foodhub.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ItemRepositry extends JpaRepository<Item,Long> {
}
