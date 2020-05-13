package com.example.demo;

import java.util.Arrays;
import java.util.Locale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.LocaleResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
@ComponentScan(basePackageClasses = HelloController.class)
public class DemoApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(DemoApplication.class, args);
	}
	
	/*@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}*/
	
	/*
	 *  can be replaced via configuring in application.properties file as
	 *  spring.messages.basename=messages
	 */
	/*@Bean
	public ResourceBundleMessageSource msgresourceBundle()
	{
		ResourceBundleMessageSource m = new ResourceBundleMessageSource();
		m.setBasename("messages");
		return m;
		
	}*/
	

	/*
	 * Instead of Session LoacleResolver we can use Accept Header loacle resolver 
	 * which make the header common for all API
	 */
	public AcceptHeaderLocaleResolver localeResolver()
	{
		AcceptHeaderLocaleResolver m = new AcceptHeaderLocaleResolver();
		/*SessionLocaleResolver m = new SessionLocaleResolver();*/
		m.setDefaultLocale(Locale.US);
		return m;
		
	}

}
