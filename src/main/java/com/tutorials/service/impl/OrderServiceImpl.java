package com.tutorials.service.impl;

import com.tutorials.dtos.OrderDto;
import com.tutorials.exception.ResourceNotFoundException;

import com.tutorials.models.Product_Order;
import com.tutorials.repository.OrderRepository;
import com.tutorials.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Product_Order order = this.modelMapper.map(orderDto, Product_Order.class);
        Product_Order savedOrder = this.orderRepository.save(order);
        return this.modelMapper.map(savedOrder, OrderDto.class);
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto, Integer orderId) {
        Product_Order order = this.orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid order id: " + orderId));
        order.setOrderCreated(orderDto.getOrderCreated());
        order.setOrderDelivered(orderDto.getOrderDelivered());
        order.setBillingAddress(orderDto.getBillingAddress());
        order.setTotalAmount(orderDto.getTotalAmount());
        order.setPaymentStatus(orderDto.getPaymentStatus());
        order.setOrderStatus(orderDto.getOrderStatus());
        // to save updated order in database.
        Product_Order savedOrder = orderRepository.save(order);

        return this.modelMapper.map(savedOrder, OrderDto.class);
    }

    @Override
    public String deleteOrder(Integer orderId) {
        Product_Order order = this.orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid order id: " + orderId));
        orderRepository.delete(order);
        return "Your current order is deleted successfully..!!";
    }

    @Override
    public OrderDto getOrder(Integer orderId) {
        Product_Order order = this.orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid order id: " + orderId));
        return this.modelMapper.map(order, OrderDto.class);

    }

    @Override
    public List<OrderDto> getOrder() {
        List<Product_Order> allOrders = orderRepository.findAll();
        List<OrderDto> orderDtos = allOrders.stream().map(order -> modelMapper.map(order, OrderDto.class)).collect(Collectors.toList());
        return orderDtos;
    }
}
