package org.javacream.training.java.util;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

public class FileDemo
{

	public void writeFile() throws Exception
	{
		FileWriter fileWriter = new FileWriter("data.txt");
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write("Hello");
		bufferedWriter.close();
	}

	public void readFile() throws Exception
	{
		FileReader fileReader = new FileReader("data.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String result = bufferedReader.readLine();
		bufferedReader.close();
		System.out.println(result);
	}

	public static void main(String[] args) throws Exception
	{
		FileDemo fileDemo = new FileDemo();
		//fileDemo.writeXmlFile();
		fileDemo.readXmlFile();
	}

	public void writeObjectFile() throws Exception
	{
		List<SimpleData> data = new LinkedList<SimpleData>();
		data.add(new SimpleData("A", "B", 'f'));
		data.add(new SimpleData("C", "B", 'f'));
		data.add(new SimpleData("D", "B", 'f'));
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.ser"));
		oos.writeObject(data);
		oos.close();
	}

	public void readObjectFile() throws Exception
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.ser"));
		Object o = ois.readObject();
		List<SimpleData> data = (List<SimpleData>) o;
		System.out.println(data);
	}

	public void writeXmlFile() throws Exception
	{
		List<SimpleData> data = new LinkedList<SimpleData>();
		data.add(new SimpleData("A", "B", 'f'));
		data.add(new SimpleData("C", "B", 'f'));
		data.add(new SimpleData("D", "B", 'f'));
		XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream("data.xml"));
		xmlEncoder.writeObject(data);
		xmlEncoder.close();
	}

	public void readXmlFile() throws Exception
	{
		XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream("data.xml"));
		Object o = xmlDecoder.readObject();
		List<SimpleData> data = (List<SimpleData>) o;
		System.out.println(data);
	}

}
