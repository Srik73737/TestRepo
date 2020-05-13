package com.example.demo.jpa;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;

import com.srik.model.ResponseDetails;

import io.swagger.annotations.Authorization;

@RestController
public class JpaUserController {

	@Autowired
	private JpaUserRepository jpaUserRepository;
	
	@Autowired
	private JpaPostRepo jpaPostRepo;
	
	ResponseDetails res = new ResponseDetails();
	
	@PostMapping("/jpa/user")
	public ResponseDetails creteUser(@RequestBody User user)
	{
		res.setStatus(HttpStatus.CREATED);
		User created = jpaUserRepository.save(user);
		if(created == null)
			res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		else
		{
			URI uri =null;
				res.setResult(Arrays.asList("http://loclohost:8080/jpa/user/"+user.getId()));
			
		}
		return res;
	}
	
	@PostMapping("/jpa/user/{id}/post")
	public ResponseDetails creteUser(@RequestBody Post post,@PathVariable int id)
	{
		res.setStatus(HttpStatus.CREATED);
		Optional<User> created = jpaUserRepository.findById(id);
		if(!created.isPresent())
			res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		else
		{
			post.setUser(created.get());
			Post p =jpaPostRepo.save(post);
			URI uri =null;
				res.setResult(Arrays.asList("http://loclohost:8080/jpa/user/"+id+"/post/"+p.getId()));
			
		}
		return res;
	}
	
	@GetMapping("/jpa/user/{id}/post")
	public ResponseDetails creteUser(@PathVariable int id)
	{
		res.setStatus(HttpStatus.CREATED);
		Optional<User> created = jpaUserRepository.findById(id);
		if(!created.isPresent())
			res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		else
		{
			
				res.setResult(created.get().getListOfPosts());
			
		}
		return res;
	}
	
	@PutMapping("/jpa/user")
	public ResponseDetails updateUser(@RequestBody User user)
	{
		res.setStatus(HttpStatus.OK);
		User created = jpaUserRepository.save(user);
		if(created == null)
			res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		else
		{
			URI uri =null;
				res.setResult(Arrays.asList("http://loclohost:8080/jpa/user/"+user.getId()));
			
		}
		return res;
	}
	
	@GetMapping("/jpa/user/{id}")
	public ResponseDetails getUserById(@PathVariable int id)
	{
		res.setStatus(HttpStatus.OK);
		Optional<User> created = jpaUserRepository.findById(id);
		if(!created.isPresent())
			res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		else
		{
			URI uri =null;
				res.setResult(Arrays.asList(created.get()));
			
		}
		return res;
	}
	
	@GetMapping("/jpa/user")
	public ResponseDetails getAllUser()
	{
		res.setStatus(HttpStatus.OK);
		List<User> created = jpaUserRepository.findAll();
		res.setResult(created);
		return res;
	}
}
