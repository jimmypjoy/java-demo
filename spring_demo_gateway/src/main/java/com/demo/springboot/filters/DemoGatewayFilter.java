package com.demo.springboot.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class DemoGatewayFilter implements GlobalFilter, Ordered {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// Log incoming request details using System.out.println
		ServerHttpRequest request = exchange.getRequest();
		System.out.println("#########################################################");
		System.out.println("Incoming request: Method = " + request.getMethod() + ", URL = " + request.getURI()
				+ ", Params = " + request.getQueryParams());

		// Proceed with the request and log the response details
		return chain.filter(exchange).then(Mono.fromRunnable(() -> {
			ServerHttpResponse response = exchange.getResponse();
			System.out.println("Outgoing response: Status code = " + response.getStatusCode());
		}));
	}

	@Override
	public int getOrder() {
		return 0; // Set the order if multiple filters are present
	}
}
