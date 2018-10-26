package org.javacream.training.java.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileDemo
{
	
	public void writeFile() throws Exception{
		FileWriter fileWriter = new FileWriter("data.txt");
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write("Hello");
		bufferedWriter.close();
	}
	public void readFile() throws Exception{
		FileReader fileReader = new FileReader("data.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String result = bufferedReader.readLine();
		bufferedReader.close();
		System.out.println(result);
	}
	
	public static void main(String[] args) throws Exception
	{
		FileDemo fileDemo = new FileDemo();
		fileDemo.writeFile();
		fileDemo.readFile();
	}
}
