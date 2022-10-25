package com.crm.object_repositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatenewProduct {

	//initialization
	public CreatenewProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(xpath = "//a[.='Products']")
	private WebElement productlinktext;
	
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement newproduct;
	
	@FindBy(name = "productname")
	private WebElement nameofproduct;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveproductname;
	
	@FindBy(name = "Delete")
	private WebElement deleteproduct;
	
	//getter methods
	public WebElement getDeleteproduct() {
		return deleteproduct;
	}

	public WebElement getProductlinktext() {
		return productlinktext;
	}

	public WebElement getNewproduct() {
		return newproduct;
	}

	public WebElement getNameofproduct() {
		return nameofproduct;
	}

	public WebElement getSaveproductname() {
		return saveproductname;
	}
	
	//business logic
	public void productlink()
	{
		productlinktext.click();
	}
	public void newProduct()
	{
		newproduct.click();
	}
	public void productname(String value)
	{
		nameofproduct.sendKeys(value);
	}
	public void productdelete()
	{
		deleteproduct.click();
	}
}
