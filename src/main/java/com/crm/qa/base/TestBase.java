package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Hello world!
 *
 */
public class TestBase 
{	
    public static Properties prop;
    public static String browsername;
    public static WebDriver driver=null;
	String configFilePath="C:\\Users\\D E L L\\eclipse-workspace\\SingletonDesignPattern\\src\\main\\java\\com\\crm\\qa\\config\\config.properties";
	
	public TestBase() throws IOException{
    	//loading configuration file
		prop=new Properties();	
		File file=new File(configFilePath);
    	FileInputStream fis=new FileInputStream(file);
    	prop.load(fis);
    }
    
	//singleton design pattern as the driver object is getting initialized only at one place and once during the test run.
	//After the test run is complete the driver will get closed
	public static void initialization(){
		if (driver==null) {
			browsername=prop.getProperty("browser");
	        switch(browsername) {
	        case "chrome":
	        	System.setProperty("webdriver.chrome.driver","C:\\Study\\SeleniumDownloads\\Driver\\chromedriver_win32\\chromedriver_win32_2.35\\chromedriver.exe");
	        	driver=new ChromeDriver();
	        	break;
	                
			case "ie" :
	        	System.setProperty("webdriver.ie.driver","C:\\Study\\SeleniumDownloads\\Driver\\IEDriver\\IEDriverServer.exe");
	        	driver=new InternetExplorerDriver();
	        	break;
	        }
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
    }
	
	public void driverQuit() {
		driver.quit();
	}
	
	public void driverClose() {
		driver.close();
	}
	
	
}
