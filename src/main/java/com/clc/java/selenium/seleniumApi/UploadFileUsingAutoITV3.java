package com.clc.java.selenium.seleniumApi;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class UploadFileUsingAutoITV3 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		String downloadFilepath = "C:\\Users\\Yogesh\\Desktop\\demo\\";
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Yogesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver =new ChromeDriver(cap);
		driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.14.0");
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/table/tbody/tr[5]/td/a[2]/span")).click();;

		System.out.println(driver.getCurrentUrl());
		
		if(true)
			return;
		
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		driver.findElement(By.id("photo")).click();
		TimeUnit.SECONDS.sleep(3);
		Runtime.getRuntime().exec("C:\\Users\\Yogesh\\Desktop\\fileuploadscript.exe");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		for(int i=0;i<5;i++) {
			jse.executeScript("window.scrollBy(0,50)");
			TimeUnit.SECONDS.sleep(2);
		}
	}
	
}
