package com.crm.qa.test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

public class LaunchTest extends TestBase
{
	public String title;
	public LaunchTest() throws IOException {
		super();
		
	}

	@BeforeMethod
    public void setUp()
    {
        initialization();
    }

    @Test
    public void launchApplication()
    {
        title=driver.getTitle();
        System.out.println(title);
    }

    @AfterMethod
    public void tearDown()
    {
      
    }
}
