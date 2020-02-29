package com.samples.ws.cxf.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.samples.ws.cxf.dto.PaymentProcessorRequest;
import com.samples.ws.cxf.dto.PaymentProcessorResponse;

@WebService(name = "PaymentProcessor")
public interface PaymentProcessor {

	@WebMethod
	public @WebResult(name = "response") PaymentProcessorResponse processPayment(
			@WebParam(name = "paymentProcessorRequest") PaymentProcessorRequest paymentProcessorRequest);
}
