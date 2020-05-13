package com.example.demo.user;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srik.exception.UserNotFoundException;
import com.srik.model.ResponseDetails;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "User Mngmnt" ,  description = " All user operations done here") // swagger
@RestController
public class UserController {

	@Autowired
	private UserService userSvc;
	
	@ApiOperation(value = "get user by id",response = User.class)
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	@GetMapping(path = "/user/{id}")
	private ResponseDetails getUserById(@PathVariable Integer id)
	{
		ResponseDetails res = new ResponseDetails();
		User user = userSvc.getUserById(id);
		if(user == null)
		{
			throw new UserNotFoundException("Invalid User Id");
		}
		else
		{
			List<User> listOfUser = new ArrayList<User>();
			listOfUser.add(user);
			res.setResult(listOfUser);
		}
		return res;
	}
	
	@ApiResponses(value = {
		    @ApiResponse(code = 201, message = "Successfully created user"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	@PostMapping(path ="/user")
	private ResponseDetails createUser(
			@ApiParam(value="User object to create user")
			@Valid @RequestBody User user) throws Exception
	{
		ResponseDetails res = new ResponseDetails();
		User u = userSvc.createUser(user);
				if(u == null) {
					throw new Exception();
				}
				else
				{
					List<User> listOfUser = new ArrayList<User>();
					listOfUser.add(u);
					res.setResult(listOfUser);
				}
		return res;
	}
	
}
