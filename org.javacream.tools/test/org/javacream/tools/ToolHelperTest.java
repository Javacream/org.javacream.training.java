package org.javacream.tools;

import org.javacream.tools.api.Hammer;
import org.javacream.tools.api.Screwdriver;
import org.javacream.tools.api.SonicScrewdriver;
import org.javacream.tools.api.ToolContainer;
import org.javacream.tools.helper.ToolHelper;
import org.junit.Assert;
import org.junit.Test;

public class ToolHelperTest
{

	@Test public void testInventoryNumberCreation() {
		ToolHelper toolHelper = new ToolHelper();
		Long number1 = toolHelper.createInventoryNumber();
		Long number2 = toolHelper.createInventoryNumber();
		Assert.assertNotEquals(number1, number2);
	}
	
	@Test public void testFillContainer() {
		ToolHelper toolHelper = new ToolHelper();
		ToolContainer toolContainer = new ToolContainer();
		toolHelper.fill(toolContainer);
		Assert.assertNotNull(toolContainer.get(Screwdriver.class));
		Assert.assertNotNull(toolContainer.get(Screwdriver.class));
		Assert.assertNotNull(toolContainer.get(Screwdriver.class));
		Assert.assertNotNull(toolContainer.get(Screwdriver.class));
		Assert.assertNull(toolContainer.get(Screwdriver.class));
		Assert.assertNotNull(toolContainer.get(SonicScrewdriver.class));
		Assert.assertNotNull(toolContainer.get(SonicScrewdriver.class));
		Assert.assertNull(toolContainer.get(SonicScrewdriver.class));
		Assert.assertNotNull(toolContainer.get(Hammer.class));
		Assert.assertNotNull(toolContainer.get(Hammer.class));
		Assert.assertNull(toolContainer.get(Hammer.class));
	}
}
