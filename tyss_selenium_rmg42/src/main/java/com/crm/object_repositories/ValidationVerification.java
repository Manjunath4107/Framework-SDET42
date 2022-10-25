package com.crm.object_repositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationVerification 
{
	public ValidationVerification(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css ="span.dvHeaderText")
	private  WebElement actualorganization;
	
	@FindBy(css ="span.lvtHeaderText")
	private WebElement actualproduct;
	
	@FindBy(css ="span.dvHeaderText")
	private WebElement actualcampaign;
	
	@FindBy(css ="span.dvHeaderText")
	private WebElement actualproductwithcampaign;
	
	//getter methods
	public WebElement getActualorganization() {
		return actualorganization;
	}

	public WebElement getActualproduct() {
		return actualproduct;
	}

	public WebElement getActualcampaign() {
		return actualcampaign;
	}

	public WebElement getActualproductwithcampaign() {
		return actualproductwithcampaign;
	}
	
	//business logic
	public void organizationValidation(WebDriver driver,String data)
	{
		String act_org = actualorganization.getText();
		if(act_org.contains(data))
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
	}
	
	public void productValidation(WebDriver driver,String data)
	{
		String act_pro = actualproduct.getText();
		if(act_pro.contains(data))
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
	}
	
	public void campaignValidation(WebDriver driver,String data)
	{
		String act_cam = actualcampaign.getText();
		if(act_cam.contains(data))
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
	}
	
	public void productwithcampaignValidation(WebDriver driver,String data)
	{
		String act_procam = actualproductwithcampaign.getText();
		if(act_procam.contains(data))
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
	}
	
}
