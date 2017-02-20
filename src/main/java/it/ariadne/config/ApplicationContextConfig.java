package it.ariadne.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import it.ariadne.dao.UserCollectionRepository;
import it.ariadne.model.UserRepository;


@Configuration
@ComponentScan("it.ariadne.*") 
public class ApplicationContextConfig { 


	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean(name = "userRepo")
	public UserRepository getUserRepository() {
		return new UserCollectionRepository();
	}

}