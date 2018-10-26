package org.javacream.training.java.util;

import java.io.Serializable;

public class SimpleData implements Serializable
{
	private static final long serialVersionUID = 1L;

	public SimpleData(String lastname, String firstname, Character gender)
	{
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.gender = gender;
	}
	private String lastname;
	private String firstname;
	private Character gender;
	public String getLastname()
	{
		return lastname;
	}
	public SimpleData()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}
	public String getFirstname()
	{
		return firstname;
	}
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}
	public Character getGender()
	{
		return gender;
	}
	public void setGender(Character gender)
	{
		this.gender = gender;
	}
	@Override
	public String toString()
	{
		return "SimpleData [lastname=" + lastname + ", firstname=" + firstname + ", gender=" + gender + "]";
	}
}
