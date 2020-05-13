package com.example.demo.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private static List<User> listOfUsers = new ArrayList<User>();
	
	static
	{
		listOfUsers.add(new User(1,"a",  LocalDate.now()));
		listOfUsers.add(new User(2,"e",  LocalDate.now().minusDays(20)));
		listOfUsers.add(new User(3,"d",  LocalDate.now().minusDays(10)));
		listOfUsers.add(new User(4,"c",  LocalDate.now().minusDays(30)));
		listOfUsers.add(new User(5,"b",  LocalDate.now().minusDays(200)));
	}
	
	public User getUserById(Integer id)
	{
		return listOfUsers.stream().filter( user -> user.getUserId() == id).findFirst().orElse(null);
	}
	
	public List<User> getUsers()
	{
		return listOfUsers;
	}

	public User createUser(User user) {
		listOfUsers.add(user);
		return user;
	}

}
