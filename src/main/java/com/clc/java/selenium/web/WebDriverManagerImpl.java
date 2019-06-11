package com.clc.java.selenium.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerImpl {

	public static void main(String[] args) {

		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
/*
		 Map<String, Object> prefs = new HashMap<String, Object>();
		 prefs.put("download.default_directory",  "C:\\Users\\Yogesh\\Desktop\\demo\\pattern\\");
		 ChromeOptions options = new ChromeOptions();
		 options.setExperimentalOption("prefs", prefs);
		 ChromeDriver driver = new ChromeDriver(options);
	        //Navigate to a URL
*/
	        driver.get("http://toolsqa.com");
	
	}
}
