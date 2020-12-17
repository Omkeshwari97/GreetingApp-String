package com.bridgelabz.greetingapp.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.repository.GreetingRepository;

@Service
public class GreetingService implements IGreetingService
{
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private GreetingRepository greetingRepository;
	
	@Override
	public Greeting addGreeting(User user) 
	{
		String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
		return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
	}
	
	@Override
	public Greeting getGreetingById(long id) 
	{
		return greetingRepository.findById(id).get();
	}

	@Override
	public void updateGreetingById(long id, String message) 
	{
		Greeting greeting = getGreetingById(id);
		
		if(message != null)
		{
			greeting.setMessage(message);
		}
		
		greetingRepository.save(greeting);
	}

	@Override
	public void deleteGreetingById(long id) 
	{
		greetingRepository.deleteById(id);
	}

	@Override
	public List getAllGreetings() 
	{
		return greetingRepository.findAll();
	}

}
