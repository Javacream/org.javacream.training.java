package org.javacream.training.java.demo.classes;

import org.javacream.training.java.demo.classes.Vehicle.InnerClassMotor;

public class DemoApp {

	public static void main(String[] args) {
		TopLevelClassMotor topLevelClassMotor = new TopLevelClassMotor();
		Motor motor = new Motor();
		Vehicle.StaticInnerClassMotor staticInnerClassMotor = new Vehicle.StaticInnerClassMotor();
		Vehicle vehicle = new Vehicle();
		InnerClassMotor innerClassMotor = vehicle.new InnerClassMotor();
	}

}
