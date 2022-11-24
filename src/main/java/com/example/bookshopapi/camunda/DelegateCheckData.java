package com.example.bookshopapi.camunda;

import com.example.bookshopapi.dto.request.CustomerRequest;
import com.example.bookshopapi.service.CustomerService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("delegateCheckData")
public class DelegateCheckData implements JavaDelegate {

    private final CustomerService customerService;

    public DelegateCheckData(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        CustomerRequest customerRequest=new CustomerRequest();
        customerRequest.setName((String) delegateExecution.getVariable("name"));
        customerRequest.setSurname((String) delegateExecution.getVariable("surname"));
        customerRequest.setUsername((String) delegateExecution.getVariable("username"));
        customerRequest.setPassword((String) delegateExecution.getVariable("password"));
        customerRequest.setEmail((String) delegateExecution.getVariable("email"));
        customerRequest.setPhone((String) delegateExecution.getVariable("phone"));
        customerRequest.setAddress((String) delegateExecution.getVariable("address"));
        Long customerId= (Long) delegateExecution.getVariable("customerId");
        delegateExecution.setVariable("checkData",customerService.checkCustomerData(customerId,customerRequest));
    }
}
