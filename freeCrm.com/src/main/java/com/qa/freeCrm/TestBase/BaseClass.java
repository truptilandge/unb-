package com.qa.freeCrm.TestBase;



import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.freeCrm.qa.config.constantdata;

public class BaseClass {

	FileInputStream fin; 
	public static Properties prop;
	
	public static WebDriver driver;
	
	public BaseClass(){
		
		try{
			fin= new FileInputStream(new File(constantdata.configPath));	
			prop=new Properties();
			prop.load(fin);
		
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public static void setBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.gecko.driver", "E:\\SETUP\\geckodriver-v0.21.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		else if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "E:\\selenium driver\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}

	
		else if(browserName.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "E:\\SETUP\\iedriver\\IEDriverServer_Win32_3.12.0 (1)\\IEDriverServer_Win32_2.47.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("freecrm"));
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
}
