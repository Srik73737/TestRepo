package com.example.demo.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/*
 * 
 * Simple scenario where building app the api expected only name parameter
 * that consits of both first and last name as part of enhancement we need to create 
 * new model class that accepts both first name and last name with versioning enabled for API
 */

@RestController
public class PersonController {
	
	@GetMapping(value = "/person/mediatype" , produces = "application/com.person.versionv1")
	public PersonV1 m1()
	{
		return new PersonV1();
	}
	
	@GetMapping(value = "/person/mediatype" , produces = "application/com.person.versionv2 ")
	public PersonV2 m2()
	{
		return new PersonV2();
	}
	
	@GetMapping(value = "/person/header" , headers = "API_VERSION=1")
	public PersonV1 m3()
	{
		return new PersonV1();
	}
	
	@GetMapping(value = "/person/header" , headers = "API_VERSION=2")
	public PersonV2 m4()
	{
		return new PersonV2();
	}
	
	@GetMapping(value = "/v1/person")
	public PersonV1 m5()
	{
		return new PersonV1();
	}
	
	@GetMapping(value = "/v2/person" )
	public PersonV2 m6()
	{
		return new PersonV2();
	}
	
	@GetMapping(value = "/person/param" ,params = "version=1")
	public PersonV1 m7()
	{
		return new PersonV1();
	}
	
	@GetMapping(value = "/person/param" ,params = "version=2" )
	public PersonV2 m8()
	{
		return new PersonV2();
	}

}
