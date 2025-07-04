package org.javacream.oop;

public class Worker extends Person {
	@Override
	public String toString() {
		return "Worker [company=" + company + ", toString()=" + super.toString() + "]";
	}

	private Company company;
	public Worker(String lastname, String firstname, Integer height, Company company) {
		super(lastname, firstname, height);
		this.company = company;
		company.employ(this);
	}
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String work() {
		return this.greet() + ", i work at " + this.company.getName();
	}

}
