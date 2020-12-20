package com.integrator.config;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration

// @ServletComponentScan etiketi @WebServlet, @WebFilter etiketiyle işaretlediğimiz sınıfları Spring Bean olarak,
// Spring Context'e dahil edecektir.

@ServletComponentScan(basePackages = { "com.integrator.servlet", "com.integrator.filter" })
@Order(2)
public class ServletFilterConfig {
	
}
