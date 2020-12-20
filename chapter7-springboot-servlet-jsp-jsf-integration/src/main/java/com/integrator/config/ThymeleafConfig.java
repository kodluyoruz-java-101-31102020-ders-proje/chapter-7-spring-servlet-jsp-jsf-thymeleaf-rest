package com.integrator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@Order(4)
public class ThymeleafConfig {

	@Autowired
    protected SpringTemplateEngine springTemplateEngine;
	
	// Thymeleaf config
	@Bean
	public ThymeleafViewResolver thymeleafViewResolver() {
		
		final ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		
		viewResolver.setViewNames(new String[] { "pages/*" });
		viewResolver.setExcludedViewNames(new String[] { "pages/jsp/*" });
		viewResolver.setTemplateEngine(springTemplateEngine);
		viewResolver.setCharacterEncoding("UTF-8");
		return viewResolver;
	}
}
