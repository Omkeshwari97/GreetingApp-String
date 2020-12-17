package com.bridgelabz.greetingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.service.IGreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingController 
{
	@Autowired
	private IGreetingService greetingService;

	@GetMapping(value = {"", "/", "/home"})
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name)
	{
		User user = new User();
		user.setFirstName(name);
		return greetingService.addGreeting(user);
	}
	
	@GetMapping("/get/{id}")
	public Greeting getGreetingById(@PathVariable("id") long id)
	{
		return greetingService.getGreetingById(id);
	}
	
	@PutMapping("/update/{id}")
	public void updateGreetingById(@PathVariable("id") long id, @RequestParam(value="message") String message)
	{
		greetingService.updateGreetingById(id, message);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteGreetingById(@PathVariable("id") long id)
	{
		greetingService.deleteGreetingById(id);
	}
	
	@GetMapping("/getall")
	public List<Greeting> getAllGreetings()
	{
		List list = greetingService.getAllGreetings();
		return list;
	}
}
