package org.javacream.training.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SimpleTcpClient
{

	public static void main(String[] args) throws Exception
	{
		Socket socket = new Socket("localhost", 9999);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		writer.write("Hello\n");
		writer.flush();
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String result = reader.readLine();
		System.out.println(result);
		socket.close();
	}

}
