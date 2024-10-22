package com.tutorials.controller;

import com.tutorials.dtos.OrderDto;
import com.tutorials.service.OrderService;
import com.tutorials.utils.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/")
    public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody OrderDto orderDto){
        OrderDto orderDto1 = this.orderService.createOrder(orderDto);
        return new ResponseEntity<>(orderDto1, HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderDto> updateOrder(@Valid @RequestBody OrderDto orderDto, @PathVariable Integer orderId){
        OrderDto orderDto1 = this.orderService.updateOrder(orderDto, orderId);
        return new ResponseEntity<>(orderDto1,HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<ApiResponse> deleteOrder(@PathVariable Integer orderId){
        String message = this.orderService.deleteOrder(orderId);
        return new ResponseEntity<>(new ApiResponse(message,true),HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Integer orderId){
        OrderDto orderDto = this.orderService.getOrder(orderId);
        return new ResponseEntity<>(orderDto,HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<OrderDto>> getOrder(){
        List<OrderDto> orderDtos = this.orderService.getOrder();
        return new ResponseEntity<>(orderDtos,HttpStatus.OK);
    }


}
