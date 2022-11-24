package com.example.bookshopapi.camunda;

import com.example.bookshopapi.exceptions.MyException;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class DelegateMyException implements JavaDelegate {


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        int code= (int) delegateExecution.getVariable("globalErrorCode");
        String message= (String) delegateExecution.getVariable("globalErrorMessage");
        throw new MyException(code,message);
    }
}
