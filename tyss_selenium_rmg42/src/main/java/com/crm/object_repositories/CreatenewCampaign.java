package com.crm.object_repositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_crm_generic_utilities.Webdriver_utility;

public class CreatenewCampaign {

	//initialization
	public CreatenewCampaign(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement more;
	
	@FindBy(xpath = "//a[.='Campaigns']")
	private WebElement campaignlink;
	
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement newcampaign;
	
	@FindBy(name = "campaignname")
	private WebElement campaignname;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savecampaignname;

	//getter methods
	public WebElement getCampaignlink() {
		return campaignlink;
	}

	public WebElement getNewcampaign() {
		return newcampaign;
	}

	public WebElement getCampaignname() {
		return campaignname;
	}

	public WebElement getMore() {
		return more;
	}

	public WebElement getSavecampaignname() {
		return savecampaignname;
	}
	
	//business logic
	public void morebtn(WebDriver driver)
	{
		Webdriver_utility wlib = new Webdriver_utility();
		wlib.mouseOveronElement(driver, more);
	}
	public void campaignlink()
	{
		campaignlink.click();
	}
	public void newcampaign()
	{
		newcampaign.click();
	}
	public void namecampaign(String data)
	{
		campaignname.sendKeys(data);
	}
	public void savecampaign()
	{
		savecampaignname.click();
	}
}
