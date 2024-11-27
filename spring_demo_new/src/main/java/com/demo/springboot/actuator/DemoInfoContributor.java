package com.demo.springboot.actuator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class DemoInfoContributor implements InfoContributor {

	@Override
	public void contribute(Info.Builder builder) {
		Map<String, Object> customDetails = new HashMap<>();
		customDetails.put("App description", "Demo spring boot application");
		customDetails.put("maintainer", "JJ");
		customDetails.put("contact", "jj@jj.com");
		customDetails.put("release-date", "2024-11-20");

		builder.withDetail("custom", customDetails);
	}
}
