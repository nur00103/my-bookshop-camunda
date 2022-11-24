package com.example.bookshopapi.camunda;

import com.example.bookshopapi.dto.request.CustomerRequest;
import com.example.bookshopapi.dto.response.CustomerResponse;
import com.example.bookshopapi.dto.response.ResponseModel;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.stereotype.Service;

@Service
public class StartCamundaPut {

    private final RuntimeService runtimeService;

    public StartCamundaPut(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public ResponseModel<CustomerResponse> startBpmnPut(String bpmnName,Long customerId, CustomerRequest customerRequest){
        VariableMap variableMap= runtimeService.createProcessInstanceByKey(bpmnName)
                .setVariable("customerId",customerId)
                .setVariable("name",customerRequest.getName())
                .setVariable("surname",customerRequest.getSurname())
                .setVariable("username",customerRequest.getUsername())
                .setVariable("password",customerRequest.getPassword())
                .setVariable("email",customerRequest.getEmail())
                .setVariable("address",customerRequest.getAddress())
                .setVariable("phone",customerRequest.getPhone())
                .executeWithVariablesInReturn()
                .getVariables();
        return variableMap.getValue("putCustomerDa", ResponseModel.class);
    }
}
