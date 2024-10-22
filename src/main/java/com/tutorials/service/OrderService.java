package com.tutorials.service;

import com.tutorials.dtos.OrderDto;

import java.util.List;

public interface OrderService {

    //create

    public OrderDto createOrder(OrderDto orderDto);

    //update
    public OrderDto updateOrder(OrderDto orderDto, Integer orderId);

    //delete

    public String deleteOrder(Integer orderId);

    //get
    public OrderDto getOrder(Integer orderId);

    //get all
    public List<OrderDto> getOrder();


}
