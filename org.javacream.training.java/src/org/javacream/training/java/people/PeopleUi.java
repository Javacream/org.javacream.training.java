package org.javacream.training.java.people;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PeopleUi {

	public static void main(String[] args) {
		new PeopleUi();
	}

	private JFrame frame;
	private JButton saveButton;
	private JTextField inputText;
	private JLabel outputLabel;
	
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
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = inputText.getText();
				String result = input.toUpperCase();
				outputLabel.setText(result);
			}
		});
	}

	private void staticUi() {
		Container container = frame.getContentPane();
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		saveButton = new JButton("Save");
		inputText = new JTextField("CHANGE ME");
		outputLabel = new JLabel("Result");
		
		panel.add(saveButton);
		panel.add(inputText);
		panel.add(outputLabel);
		container.add(panel);
	}

	private void initFrame() {
		frame = new JFrame("P E O P L E");
		frame.setBounds(100,  100,  500,  500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
