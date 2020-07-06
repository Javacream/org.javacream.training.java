package org.javacream.training.java.demo.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.javacream.training.java.demo.classes.Vehicle.InnerClassMotor;

public class DemoApp {

	public static void main(String[] args) {
		TopLevelClassMotor topLevelClassMotor = new TopLevelClassMotor();
		Motor motor = new Motor();
		Vehicle.StaticInnerClassMotor staticInnerClassMotor = new Vehicle.StaticInnerClassMotor();
		Vehicle vehicle = new Vehicle();
		InnerClassMotor innerClassMotor = vehicle.new InnerClassMotor();
		
		
		//Scratch für UIU-Programmierung
		JButton button = new JButton();
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("clicked on button");
			}
		};
		button.addActionListener(action);
		
		//Verkürzt:
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("clicked on button");
			}
		});
		
	}

}
