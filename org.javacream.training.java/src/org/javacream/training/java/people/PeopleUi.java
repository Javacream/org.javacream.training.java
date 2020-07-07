package org.javacream.training.java.people;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.javacream.training.java.people.api.PeopleController;

public class PeopleUi {

	public static void main(String[] args) {
		new PeopleUi();
	}

	private JFrame frame;
	private JButton createPersonButton;
	private JTextField lastnameInput;
	private JLabel outputLabel;
	private JTextField firstnameInput;
	private JButton clearButton;
	
	public PeopleUi() {
		initFrame();
		staticUi();
		registerEventListener();
		show();
	}
	
	private void show() {
		frame.setVisible(true);
	}

	private void registerEventListener() {
		createPersonButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PeopleController controller = PeopleApplicationContext.peopleController(); 
				String lastname = lastnameInput.getText();
				String firstname = firstnameInput.getText();
				Integer personId = controller.create(lastname, firstname, 80.0, 173, null);
				String result = "Created person with id " + personId;
				outputLabel.setText(result);
				controller.findAll().forEach(System.out::println);
			}
		});
		
		clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lastnameInput.setText("");
				firstnameInput.setText("");
			}
		});
	}

	private void staticUi() {
		Container container = frame.getContentPane();
		container.setLayout(new GridLayout(3,1));
		JPanel panelInput = new JPanel();
		panelInput.setLayout(new GridLayout(2,2));
		
		panelInput.add(new JLabel("Lastname:"));
		lastnameInput = new JTextField();
		panelInput.add(lastnameInput);

		
		panelInput.add(new JLabel("Firstname:"));
		firstnameInput = new JTextField();
		panelInput.add(firstnameInput);

		JPanel panelButtons = new JPanel();
		createPersonButton = new JButton("Create");
		clearButton = new JButton("Clear");
		panelButtons.setLayout(new GridLayout(1,2));
		panelButtons.add(createPersonButton);
		panelButtons.add(clearButton);
		
		outputLabel = new JLabel("Result");
		
		container.add(panelInput);
		container.add(panelButtons);
		container.add(outputLabel);
	}

	private void initFrame() {
		frame = new JFrame("P E O P L E");
		frame.setBounds(100,  100,  500,  500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
