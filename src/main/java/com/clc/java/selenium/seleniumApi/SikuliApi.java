package com.clc.java.selenium.seleniumApi;

import java.util.concurrent.TimeUnit;

import org.sikuli.hotkey.Keys;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliApi {

	public static void main(String[] args) throws FindFailed, InterruptedException {
		Screen screen = new Screen();
		Pattern p1 = new Pattern("C:\\Users\\Yogesh\\Desktop\\demo\\pattern\\1.PNG");
		Pattern p2 = new Pattern("C:\\Users\\Yogesh\\Desktop\\demo\\pattern\\2.PNG");
		Pattern p3 = new Pattern("C:\\Users\\Yogesh\\Desktop\\demo\\pattern\\3.PNG");
		Pattern p4 = new Pattern("C:\\Users\\Yogesh\\Desktop\\demo\\pattern\\4.PNG");
		
		screen.click(p1);
		TimeUnit.SECONDS.sleep(5);
		screen.type(p2,"download sikuli jar file");
		TimeUnit.SECONDS.sleep(2);
		screen.type(Keys.ENTER);
		TimeUnit.SECONDS.sleep(5);
		screen.click(p3);
		TimeUnit.SECONDS.sleep(5);
		screen.click(p4);
		TimeUnit.SECONDS.sleep(5);
		
	}
}
