package org.javacream.training.java.basic;

public class Person
{

	private String lastname;
	private String firstname;
	private Integer height;
	private Character gender;
	private Double id;
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public static final Integer numberOfEyes = 2;
	private static Integer numberOfCreatedPeople = 0;

	{
		numberOfCreatedPeople++;
		id = Math.random();
	}

	public Person(String lastname, String firstname, Integer height, Character gender)
	{
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.height = height;
		this.gender = gender;
	}

	public String getLastname()
	{
		return lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	public Integer getHeight()
	{
		return height;
	}

	public void setHeight(Integer height)
	{
		this.height = height;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public Character getGender()
	{
		return gender;
	}

	public Person(String firstname, Character gender)
	{
		super();
		this.firstname = firstname;
		this.gender = gender;
	}

	@Override
	public String toString()
	{
		return "Person [lastname=" + lastname + ", firstname=" + firstname + ", height=" + height + ", gender=" + gender
				+ "]";
	}
}
