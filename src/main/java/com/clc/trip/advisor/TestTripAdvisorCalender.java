package com.clc.trip.advisor;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestTripAdvisorCalender {


	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Yogesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.tripadvisor.in/Flights-o304554-From_Mumbai-Cheap_Discount_Airfares.html");
		driver.findElement(By.id("roundtrip_picker")).click();
		List<WebElement> monthNYear = driver.findElements
				(By.className("rsdc-month"));
		for (WebElement webElement : monthNYear) {
			if(webElement.findElement(By.className("rsdc-month-title")).
					getText().contains("July")) {
			
				List<WebElement> days = webElement.findElements(By.className("rsdc-day"));
				for (WebElement day: days) {
							System.out.println(day.getText());
							if(day.getText().trim().equals("27")){
									day.click();
							}
				}
		}
			
		}
	}
	
}
