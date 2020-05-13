package com.example.demo;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Autowired
	private MessageSource msgresourceBundle;

	@GetMapping(path ="/hello")
	public String m1()
	{
		return "sadvsdv";
	}
	
	/*
	 * http://localhost:8080/hello-var/sdvcsd
	 */
	@GetMapping(path ="/hello-var/{name}")
	public MessageBean m2(@PathVariable String name)
	{
		return new MessageBean(String.format("Hello, %s", name));
	}
	/*
	 * Instead of defining locale to each and every method we can globalise it by Accept Header locale Resolver
	 * LocaleContextHolder has been used to fetch loacle
	 */
	@GetMapping(path ="/hello-var/i18n")
	public MessageBean m2(/*@RequestHeader(name="Accept-Language",required = false) Locale locale*/)
	{
		
		return new MessageBean(String.format("Hello, %s", msgresourceBundle.getMessage("greeting", null, LocaleContextHolder.getLocale())));
	}
}
