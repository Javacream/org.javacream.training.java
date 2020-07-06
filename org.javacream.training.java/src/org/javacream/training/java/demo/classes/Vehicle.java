package org.javacream.training.java.demo.classes;

public class Vehicle {
	private int numberOfWheels;
	private static final String DESCRIPTION = "a vehicle";
	private TopLevelClassMotor topLevelClassMotor;
	private Motor motor;
	private InnerClassMotor innerClassMotor = new InnerClassMotor();
	

	public void drive(String destination) {
		int velocity = 42;

		class MethodClassMotor {
			public void power() {
				System.out.println(numberOfWheels);
				System.out.println(Vehicle.this.numberOfWheels);
				System.out.println(Vehicle.DESCRIPTION);
				System.out.println(velocity);
				System.out.println(destination);
			}
		}
		
		MethodClassMotor motor = new MethodClassMotor();
		motor.power();

	
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

class Motor {

	private Vehicle vehicle;
}

