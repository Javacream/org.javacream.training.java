package org.javacream.training.java.demo.classes;

import javax.xml.ws.Provider;

public class Vehicle {
	private int numberOfWheels;
	private static final String DESCRIPTION = "a vehicle";
	private TopLevelClassMotor topLevelClassMotor;
	private Motor motor;
	private InnerClassMotor innerClassMotor = new InnerClassMotor();
	

	public void drive(String destination) {
		int velocity = 42;

		class MethodClassMotor implements PowerProvider{
			public int power() {
				System.out.println(numberOfWheels);
				System.out.println(Vehicle.this.numberOfWheels);
				System.out.println(Vehicle.DESCRIPTION);
				System.out.println(velocity);
				System.out.println(destination);
				return 42;
			}
		}
		
		MethodClassMotor motor = new MethodClassMotor();
		motor.power();
		
		//Anonyme innere Klasse
		PowerProvider powerProvider = new PowerProvider() {
			
			@Override
			public int power() {
				System.out.println(numberOfWheels);
				System.out.println(Vehicle.this.numberOfWheels);
				System.out.println(Vehicle.DESCRIPTION);
				System.out.println(velocity);
				System.out.println(destination);
				return 42;
			}
		};
		
		powerProvider.power();
		
		
		new PowerProvider() {
			
			@Override
			public int power() {
				// TODO Auto-generated method stub
				return 0;
			}
		}.power();
		
		//Ein erster Lambda-Ausdruck
		PowerProvider provider = () -> {
			System.out.println(numberOfWheels);
			System.out.println(Vehicle.this.numberOfWheels);
			System.out.println(Vehicle.DESCRIPTION);
			System.out.println(velocity);
			System.out.println(destination);
			return 42;
		};
		
		
	
	}
	class InnerClassMotor {
		public void power() {
			System.out.println(numberOfWheels);
			System.out.println(Vehicle.this.numberOfWheels);
			System.out.println(Vehicle.DESCRIPTION);
		}
	}

	static class StaticInnerClassMotor {
		public void power() {
			System.out.println(Vehicle.DESCRIPTION);
		}
	}

}

class Motor implements PowerProvider{

	private Vehicle vehicle;

	@Override
	public int power() {
		// TODO Auto-generated method stub
		return 0;
	}
}

