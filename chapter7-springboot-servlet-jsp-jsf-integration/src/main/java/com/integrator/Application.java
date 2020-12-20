package com.integrator;

import javax.faces.webapp.FacesServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.ServletContextAware;
import com.integrator.config.HibernateConfig;
import com.integrator.config.JspConfig;
import com.integrator.config.ServletFilterConfig;
import com.integrator.config.ThymeleafConfig;
import com.sun.faces.config.ConfigureListener;

@SpringBootApplication
@Import({ HibernateConfig.class, ServletFilterConfig.class, JspConfig.class, ThymeleafConfig.class })
public class Application extends SpringBootServletInitializer implements ServletContextAware {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	// JSF için gerekli Bean'ler.
	@Bean
	public ServletRegistrationBean<Servlet> servletRegistrationBean() {

		FacesServlet servlet = new FacesServlet();

		ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<Servlet>(servlet,
				"*.jsf", "*.xhtml");
		servletRegistrationBean.setLoadOnStartup(1);
		return servletRegistrationBean;
	}

	@Bean
	public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
		return new ServletListenerRegistrationBean<ConfigureListener>(new ConfigureListener());
	}

	@Override
	public void setServletContext(ServletContext servletContext) {

		servletContext.setInitParameter("com.sun.faces.enableRestoreView11Compatibility", "true");
		servletContext.setInitParameter("javax.faces.STATE_SAVING_METHOD", "client");
	}
}