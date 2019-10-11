package com.waes.assignment.rrichards.entities;

/**
 * @author Rafael Richards
 * Class to store the base 64 coded string received in the POST as requestBody    
 */
public class Base64String 
{
	private String data;

	public Base64String() 
	{
	}
	
	public Base64String(String data) 
	{
		super();
		this.data = data;
	}
	
	public String getData() 
	{
		return data;
	}

	public void setData(String data) 
	{
		this.data = data;
	}
}
