package com.example.bookshopapi.controller;


import com.example.bookshopapi.camunda.StartCamundaPost;
import com.example.bookshopapi.camunda.StartCamundaPut;
import com.example.bookshopapi.dto.request.CustomerRequest;
import com.example.bookshopapi.dto.response.CustomerResponse;
import com.example.bookshopapi.dto.response.ResponseModel;
import com.example.bookshopapi.service.CustomerService;
import com.example.bookshopapi.camunda.StartCamundaGetAll;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    private final StartCamundaGetAll startCamunda;
    private final StartCamundaPost startCamundaPost;
    private final StartCamundaPut startCamundaPut;

//    @Value("${bpmnName.value}")
//    private final String bpmnName;


    @GetMapping()
    public ResponseModel<List<CustomerResponse>> getAllCustomer(){
        return startCamunda.startBpmnGetAll("getCustomer");
    }
    @PostMapping("/add")
    public ResponseModel<CustomerResponse> addCustomer(@RequestBody @Valid CustomerRequest customerRequest){
        return startCamundaPost.startBpmnPost("postCustomer",customerRequest);
    }
    @PutMapping("/{customerId}")
    public ResponseModel<CustomerResponse> updateCustomer(@PathVariable @Valid Long customerId
            ,@RequestBody @Valid CustomerRequest customerRequest){
        return startCamundaPut.startBpmnPut("putCustomer",customerId,customerRequest);
    }
    @GetMapping("/{customerId}")
    public ResponseModel<CustomerResponse> getCustomerById(@PathVariable @Valid Long customerId){
        return customerService.getCustomerById(customerId);
    }

    @DeleteMapping("/{customerId}")
    public ResponseModel<CustomerResponse> deleteCustomer(@PathVariable @Valid Long customerId){
        return customerService.deleteCustomer(customerId);
    }
}
