package org.javacream.tools.helper;

import java.util.Properties;

import org.javacream.tools.api.Tool;
import org.javacream.tools.api.ToolContainer;

public class ToolHelper
{

	public Long createInventoryNumber()
	{
		Double d = Math.random() * 10e6;
		return d.longValue();
	}

	public void fill(ToolContainer container)
	{
		try
		{
			Properties properties = new Properties();
			properties.load(ToolContainer.class.getResourceAsStream("tools.properties"));
			Integer counter = 1;
			String value;
			String packageName = ToolContainer.class.getPackage().getName();
			while ((value = properties.getProperty("tool" + counter)) != null)
			{

				String classToInstantiate = packageName + "." + value;
				Object object = Class.forName(classToInstantiate).getConstructor().newInstance();
				Tool t = (Tool) object;
				container.add(t);
				counter++;
			}
		} catch (Exception e)
		{
			System.out.println("exception reading properties");
		}
	}
}
