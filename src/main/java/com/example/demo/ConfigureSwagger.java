package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.plaf.basic.BasicToolBarUI.DockingListener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ConfigureSwagger {

	public static final Contact DEFAULT_CONTACT = new Contact("Srik", "http://srik.com", "srik@gmail.com");
	  public static final ApiInfo DEFAULT = new ApiInfo("Srik API Documentation", "Srik Documentation", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
	  public static Set<String> set = new HashSet<>(
			  Arrays.asList("application/Json","application/xml")
			  );
	
	  
	  /*
	 * 
	 * Swagger Urls: http://localhost:8080/swagger-ui.html#/
	 *               http://localhost:8080/v2/api-docs
	 */
	  
	  /*
		 * @Api	Marks a class as a Swagger resource.  --> controller class level specification
		 					ex: 
@Api(value="Employee Management System", description="Operations pertaining to employee in Employee Management")

			@ApiModel	Provides additional information about Swagger models.
			@ApiModelProperty	Adds and manipulates data of a model property.
			
			@ApiOperation	Describes an operation or typically an HTTP method against a specific path.
							Request method level description
							ex: 
							@ApiOperation(value = "View a list of available employees", response = List.class)
			
			@ApiParam	Adds additional meta-data for operation parameters.
						ex: 
							
							@PostMapping("/employees")
							public Employee createEmployee(
							    @ApiParam(value = "Employee object store in database table", required = true) @Valid @RequestBody Employee employee) {
							    return employeeRepository.save(employee);
							}
					
			@ApiResponse	Describes a possible response of an operation.
			@ApiResponses	
					ex: 
						
						@ApiResponses(value = {
						    @ApiResponse(code = 200, message = "Successfully retrieved list"),
						    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
						    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
						    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
						})
			
			A wrapper to allow a list of multiple ApiResponse objects.
		 */
	
	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT)
				.produces(set)
				.consumes(set);
	}
}
