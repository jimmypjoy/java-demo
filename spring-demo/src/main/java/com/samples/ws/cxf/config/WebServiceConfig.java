package com.samples.ws.cxf.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class WebServiceConfig {

//	@Autowired
//	private Bus bus;
//
//	@Bean
//	public Endpoint endpoint() {
//		EndpointImpl endpoint = new EndpointImpl(bus, new PaymentProcessorImpl());
//		endpoint.publish("/paymentProcessor");
//		
//		Map<String, Object> inProps = new HashMap<>();
//		inProps.put(ConfigurationConstants.ACTION, ConfigurationConstants.USERNAME_TOKEN);
//		inProps.put(ConfigurationConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
//		inProps.put(ConfigurationConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());
//		
//		WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
//		endpoint.getInInterceptors().add(wssIn);
//		
//		return endpoint;
//
//	}

}
