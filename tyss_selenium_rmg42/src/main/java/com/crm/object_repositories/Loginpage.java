package com.crm.object_repositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	//initialization
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(name="user_name")
	private WebElement usernametextfield;
	
	@FindBy(name="user_password")
	private WebElement passwordtextfield;
	
	@FindBy(id="submitButton")
	private WebElement submitbutton;
	
	//getter methods
	public WebElement getUsernametextfield() 
	{
		return usernametextfield;
	}

	public WebElement getPasswordtextfield() 
	{
		return passwordtextfield;
	}

	public WebElement getSubmitbutton() 
	{
		return submitbutton;
	}
	
	public void login(String username,String password)
	{
		usernametextfield.sendKeys(username);
		passwordtextfield.sendKeys(password);
		submitbutton.click();
	}
	
}
