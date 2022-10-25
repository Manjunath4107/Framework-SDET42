package com.crm.object_repositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatenewOrganization {

	//initialization
	public CreatenewOrganization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(xpath = "(//a[text()='Organizations'])[1]")
	private WebElement organizationlink;
	
	@FindBy(xpath = "(//img[@title='Create Organization...'])")
	private WebElement neworganization;
	
	@FindBy(name = "accountname")
	private WebElement orgname;
	
	@FindBy(name = "button")
	private WebElement savebtn;
	
	//getter methods
	
	public WebElement getNeworganization()
	{
		return neworganization;
	}

	public WebElement getOrganizationlink()
	{
		return organizationlink;
	}

	public WebElement getOrgname()
	{
		return orgname;
	}

	public WebElement getSavebtn()
	{
		return savebtn;
	}
	
	//business logic
	public void organization()
	{
		organizationlink.click();
	}
	public void createneworganization()
	{
		neworganization.click();
	}
	public void organizationName(String data)
	{
		orgname.sendKeys(data);
	}
	public void saveorgname()
	{
		savebtn.click();
	}
	
}
