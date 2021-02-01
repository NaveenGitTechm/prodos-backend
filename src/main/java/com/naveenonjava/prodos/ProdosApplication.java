package com.naveenonjava.prodos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.naveenonjava.prodos.security.CORSFilter;

@SpringBootApplication
public class ProdosApplication extends SpringBootServletInitializer{
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ProdosApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProdosApplication.class, args);
	}
	
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/products").
//						allowedOrigins("http://localhost:3000")
//						.allowedMethods("GET","POST");
//			}
//		};
//	}
	
	 @Bean
	    public FilterRegistrationBean dawsonApiFilter() {
	        FilterRegistrationBean registration = new FilterRegistrationBean();
	        registration.setFilter(new CORSFilter());
	        // In case you want the filter to apply to specific URL patterns only
	        registration.addUrlPatterns("/*");
	        return registration;
	    }
}
