package com.example.bookshopapi.camunda.sales;

import com.example.bookshopapi.dto.request.SalesRequest;
import com.example.bookshopapi.dto.response.ResponseModel;
import com.example.bookshopapi.dto.response.SalesResponse;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.stereotype.Service;

@Service
public class StartCamundaSalesPost {

    private final RuntimeService runtimeService;

    public StartCamundaSalesPost(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public ResponseModel<SalesResponse> startCamundaSalesPost(String bpmnName, SalesRequest salesRequest){
        VariableMap variableMap= runtimeService.createProcessInstanceByKey(bpmnName)
                .setVariable("customerId",salesRequest.getCustomer())
                .setVariable("bookId",salesRequest.getBook())
                .setVariable("amount",salesRequest.getAmount())
                .setVariable("quantity",salesRequest.getQuantity())
                .executeWithVariablesInReturn()
                .getVariables();
        return variableMap.getValue("postSales",ResponseModel.class);
    }
}
