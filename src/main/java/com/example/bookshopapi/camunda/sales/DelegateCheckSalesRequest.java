package com.example.bookshopapi.camunda.sales;

import com.example.bookshopapi.dto.request.SalesRequest;
import com.example.bookshopapi.service.SalesService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("delegateCheckSalesRequest")
public class DelegateCheckSalesRequest implements JavaDelegate {

    private final SalesService salesService;

    public DelegateCheckSalesRequest(SalesService salesService) {
        this.salesService = salesService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        SalesRequest salesRequest=new SalesRequest();
        String customerId= (String) delegateExecution.getVariable("customerId");
        String bookId= (String) delegateExecution.getVariable("bookId");
        String amount=(String)delegateExecution.getVariable("amount") ;
        String quantity=(String)delegateExecution.getVariable("quantity");
        salesRequest.setBook(Long.valueOf(bookId));
        salesRequest.setCustomer(Long.valueOf(customerId));
        salesRequest.setAmount(Double.parseDouble(amount));
        salesRequest.setQuantity(Integer.parseInt(quantity));
        delegateExecution.setVariable("checkSalesData",salesService.checkRequest(salesRequest));
    }
}
