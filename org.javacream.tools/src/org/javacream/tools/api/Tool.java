package org.javacream.tools.api;

import org.javacream.tools.helper.ToolHelper;

public abstract class Tool
{
	private ToolHelper toolHelper;
	private Long inventory;
	private String description;
	private Boolean attached;
	private Coordinate coordinate;
	private ToolStatus toolStatus;
	
	{
		toolHelper = new ToolHelper();
		inventory = toolHelper.createInventoryNumber();
		toolStatus = ToolStatus.OK;
	}
	public Long getInventory()
	{
		return inventory;
	}
	public String getDescription()
	{
		return description;
	}
	public Tool(Long inventory, String description)
	{
		super();
		this.inventory = inventory;
		this.description = description;
	}
	public Tool(String description)
	{
		super();
		this.description = description;
	}
	public Boolean getAttached()
	{
		return attached;
	}
	public void setAttached(Boolean attached)
	{
		this.attached = attached;
	}
	public Coordinate getCoordinate()
	{
		return coordinate;
	}
	public void setCoordinate(Coordinate coordinate)
	{
		this.coordinate = coordinate;
	}
	public ToolStatus getToolStatus()
	{
		return toolStatus;
	}
	public void setToolStatus(ToolStatus toolStatus)
	{
		this.toolStatus = toolStatus;
	}
	 
	public abstract void doWork();
}