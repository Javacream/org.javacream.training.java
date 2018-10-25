package org.javacream.tools.api;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ToolContainer
{

	private Map<Class<? extends Tool>, LinkedList<Tool>> toolsMap;
	
	public void add(Tool tool) {
		LinkedList<Tool> tools = toolsMap.get(tool.getClass());
		if (tools == null) {
			tools = new LinkedList<Tool>();
			toolsMap.put(tool.getClass(), tools);
		}
		tools.add(tool);
	}
	{
		toolsMap = new HashMap<Class<? extends Tool>, LinkedList<Tool>>();
	}
	public Tool get(Class<? extends Tool> type) {
		LinkedList<Tool> tools = toolsMap.get(type);
		if (tools != null && tools.size() > 0) {
			return tools.removeFirst();
		}else {
			return null;
		}
		
	}
}
