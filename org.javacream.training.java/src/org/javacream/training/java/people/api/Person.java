package org.javacream.training.java.people.api;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.javacream.training.java.util.Address;
import org.javacream.training.java.util.AddressProvider;

/**
 * This class is a simple abstraction of a person
 * 
 * @author Rainer Sawitzki
 *
 */
public class Person implements AddressProvider {

	private int id;
	private static ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
	// Das wird bei jeder Konstruktion aufgerufen!
	{
		counter += 1;
		id = counter;
		if (HEARTBEAT) {
			
			scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("pulse for " + this), 0, 3,
					TimeUnit.SECONDS);
		}
	}
	
	public static void stopHeartbeat() {
		scheduledExecutorService.shutdownNow();
	}

	public int getId() {
		return id;
	}

	public Person(String lastname, String firstname, Double weight, Integer height, Address address) {
		this(lastname, firstname, weight, height, GeneticGender.UNKNOWN, address);
	}

	public Person(String lastname, String firstname, Double weight, Integer height, GeneticGender gender,
			Address address) {
		this(lastname, firstname, weight, height, gender, address, new HashSet<>());
		this.firstnames.add(firstname);
	}

	public Person(String lastname, String firstname, Double weight, Integer height, GeneticGender gender,
			Address address, Set<String> firstnames) {
		super();
		this.firstnames = firstnames;
		this.lastname = lastname;
		this.firstname = firstname;
		this.weight = weight;
		this.height = height;
		this.address = address;
		this.gender = gender;
	}

	public Set<String> getFirstnames() {
		return firstnames;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.javacream.training.java.AddressProvider#getAddress()
	 */
	@Override
	public Address getAddress() {
		return address;
	}

	public String getFirstname() {
		return firstname;
	}

	public AddressProvider getPartner() {
		return partner;
	}

	public static Integer getNumberOfEyes() {
		return NUMBER_OF_EYES;
	}

	public static Integer getCounter() {
		return counter;
	}

	private Address address;
	private String lastname;
	private String firstname;
	private Set<String> firstnames;
	private Double weight;
	private Integer height;
	private Person partner;
	private GeneticGender gender;

	public GeneticGender getGender() {
		return gender;
	}

	private final static Integer NUMBER_OF_EYES = 2;
	private static Integer counter = 0;
	public static boolean HEARTBEAT = false;

	/**
	 * sayHello prints a simple message on the system console
	 */
	public void sayHello() {
		String message = "Hello, my name is " + this.lastname;
		if (this.partner != null) {
			message = message + ", i am married with " + this.partner.lastname;
		}
		System.out.println(message);
	}

	public void marry(Person newPartner) throws IllegalArgumentException {
		if (newPartner != null && newPartner != this && newPartner.partner == null && this.partner == null) {
			this.partner = newPartner;
			newPartner.partner = this;
		} else {
			throw new IllegalArgumentException("marriage not possible!");
		}
	}

	public void divorce() throws IllegalArgumentException {
		if (this.partner != null) {
			this.partner.partner = null;
			this.partner = null;
		} else {
			throw new IllegalArgumentException("divorce not possible!");
		}
	}

	@Override
	public String toString() {
		return "Person [address=" + address + ", lastname=" + lastname + ", firstname=" + firstname + ", firstnames="
				+ firstnames + ", weight=" + weight + ", height=" + height + "]";
	}

//	@Override
//	public boolean equals(Object obj) {
//		return true;
//	}

}
