package com.juannaza.exam.configurations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	@Bean
	public RestTemplate restTemplate() {
		String debbug = System.getenv("debbug");
		RestTemplate restTemplate;
		if (debbug != null && "true".equals(debbug)) {
			//SSLUtil.disableSslVerification();
			restTemplate = new RestTemplate(
					new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));

			List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
			//interceptors.add(new LoggingRequestInterceptor());
			restTemplate.setInterceptors(interceptors);
		} else {
			restTemplate = new RestTemplate();
		}
		return restTemplate;
	}

}
