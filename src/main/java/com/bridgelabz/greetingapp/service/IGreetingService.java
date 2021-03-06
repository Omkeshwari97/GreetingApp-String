package com.bridgelabz.greetingapp.service;

import java.util.List;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;

public interface IGreetingService 
{
	Greeting addGreeting(User user);
	Greeting getGreetingById(long id);
	void updateGreetingById(long id, String message);
	void deleteGreetingById(long id);
	List getAllGreetings();
}
