package com.javafirst.cxfsoapws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.javafirst.cxfsoapws.dto.PaymentProcessorRequest;
import com.javafirst.cxfsoapws.dto.PaymentProcessorResponse;

@WebService(name = "PaymentProcessor")
public interface PaymentProcessor {

	@WebMethod
	public @WebResult(name = "response") PaymentProcessorResponse processPayment(
			@WebParam(name = "paymentProcessorRequest") PaymentProcessorRequest paymentProcessorRequest);
}
