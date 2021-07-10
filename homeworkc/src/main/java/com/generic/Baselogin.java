package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pageFactory.MasterPF;
import com.util.ConfigProperty;
import com.util.Highlighter;
import com.util.Screenshot;

public class Baselogin {
public static void getlogin() {
	System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	//driver.navigate().to(ConfigProperty.getConfigFile("URL"));
	driver.navigate().to(ConfigProperty.getConfigFile("URL"));
	driver.manage().window().maximize();
	MasterPF obj = new MasterPF(driver);
	Screenshot.getpics(driver,"Before sign in ");
	Highlighter.getColor(driver, obj.getSignIn());
	obj.getSignIn().click();
	
	Highlighter.getColor(driver,obj.getEmail());
	obj.getEmail().sendKeys(ConfigProperty.getConfigFile("username"));
	Highlighter.getColor(driver,obj.getPassword());
	obj.getPassword().sendKeys(ConfigProperty.getConfigFile("password"));
	obj.getSubmit().click();
	Screenshot.getpics(driver,"After sign out");
	obj.getSignOut().click();
}

}