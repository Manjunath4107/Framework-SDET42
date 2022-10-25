package com.crm.object_repositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_crm_generic_utilities.Webdriver_utility;

public class Homepage {
	
	//initialization
	public void homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//declaration
	@FindBy(linkText="Organizations")
	private WebElement organizationLinktext;
	
	@FindBy(linkText = "Products")
	private WebElement productsLinktext;
	
	@FindBy(xpath  = "//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreLinktext;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLinktext;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutImg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutLinktext;
	
	//getter methods
	public WebElement getOrganizationLinktext() {
		return organizationLinktext;
	}

	public WebElement getProductsLinktext() {
		return productsLinktext;
	}

	public WebElement getMoreLinktext() {
		return moreLinktext;
	}

	public WebElement getCampaignsLinktext() {
		return campaignsLinktext;
	}

	public WebElement getSignoutImg() {
		return signoutImg;
	}

	public WebElement getSignoutLinktext() {
		return signoutLinktext;
	}
	
	//business logic
	public void organization()
	{
		organizationLinktext.click();
	}
	public void product()
	{
		productsLinktext.click();
	}
	public void more(WebDriver driver)
	{
		Webdriver_utility wlib = new Webdriver_utility();
		wlib.mouseOveronElement(driver, moreLinktext);
	}
	public void campaign()
	{
		campaignsLinktext.click();
	}
	public void signoutimg(WebDriver driver)
	{
		Webdriver_utility wlib1 = new Webdriver_utility();
		wlib1.mouseOveronElement(driver, signoutImg);
	}
	public void signout()
	{
		signoutLinktext.click();
		
	}
}
