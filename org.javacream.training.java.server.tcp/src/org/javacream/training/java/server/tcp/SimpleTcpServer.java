package org.javacream.training.java.server.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleTcpServer
{

	public static void main(String[] args) throws Exception
	{
		new SimpleTcpServer();
	}

	private ExecutorService executorService;
	private Boolean running = true;

	public SimpleTcpServer() throws Exception
	{
		executorService = Executors.newFixedThreadPool(10);
		final ServerSocket serverSocket = new ServerSocket(9999);
		executorService.execute(new Runnable()
		{
			@Override
			public void run()
			{
				while (running)
				{
					try
					{
						final Socket clientSocket = serverSocket.accept();
						executorService.execute(new Runnable()
						{

							@Override
							public void run()
							{
								try
								{
									BufferedReader reader = new BufferedReader(
											new InputStreamReader(clientSocket.getInputStream()));
									String payload = reader.readLine();
									System.out.println("Reading payload: " + payload);
									BufferedWriter writer = new BufferedWriter(
											new OutputStreamWriter(clientSocket.getOutputStream()));
									StringBuilder builder = new StringBuilder(payload);
									writer.write(builder.reverse().toString());
									writer.flush();
									clientSocket.close();
								} catch (Exception e)
								{
									e.printStackTrace();
								}
							}

						});
					} catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		});
	}

}
