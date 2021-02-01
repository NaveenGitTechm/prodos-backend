package com.naveenonjava.prodos.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ConnectionSettings.class)
public class FeedbackClientConfiguration {

	// Spring initialized this automatically
	@Autowired
	ConnectionSettings connectionSettings;
	
	@Bean
	public FeedbackClient feedbackClient() {
		return new FeedbackClient(
				connectionSettings.getHost(),
				connectionSettings.getPort()
				);
	}
}
