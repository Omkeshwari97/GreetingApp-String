package com.bridgelabz.greetingapp.model;

public class User
{
	private String firstName;
	private String lastName;

	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setFirstName(String fname)
	{
		firstName = fname;
	}
	
	public void setLastName(String lname)
	{
		lastName = lname;
	}
	
	@Override
	public String toString() 
	{
		String str = (firstName != null) ? firstName + " " : "";
		str += (lastName != null) ? lastName : "";
		return str;
	}
}
