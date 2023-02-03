package com.foodhub.controller;

import com.foodhub.dto.OrderDto;
import com.foodhub.model.Order;
import com.foodhub.orderservice.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/foodhub")
public class OrderAndItemsController {

    Logger logger  = LoggerFactory.getLogger(OrderAndItemsController.class);
    @Autowired
    private OrderService orderAndItemService;

    @PostMapping(path = "/orders")
    public ResponseEntity<Order> registerCustomer(@RequestBody @Valid OrderDto orderDto) {
        //if plan selected, then subscriberService

        try {
            Order object = orderAndItemService.createFoodOrder(orderDto);
            return new ResponseEntity<>(object, HttpStatus.CREATED);
        } catch (Exception ex) {
            logger.info("Caught exceptionex",ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(path = "/getById/{orderId}")
    public ResponseEntity<Order> retrieveCustomer(@PathVariable(name = "orderId") Long orderId){
        logger.info("Entered into retrieveCustomer method");
        Order orderDto = orderAndItemService.getOrderById(orderId);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @PutMapping("/cancel-order/{orderId}")
    public Order cancelOrder( @PathVariable(name = "orderId") Long orderId) {
        logger.info("Entered into cancelOrder method");
        return orderAndItemService.cancelOrder(orderId);

    }

    @PutMapping("/update-order/{orderId}/{itemId}")
    public Order updateOrder(@RequestBody OrderDto orderDto,
                             @PathVariable(name = "orderId") Long orderId,@PathVariable Long itemId) {
        logger.info("Entered into updateOrder method");
        return orderAndItemService.updateOrder(orderDto,orderId,itemId);

    }

}