package practice;

import org.testng.annotations.Test;

public class SampleTest {

	@Test
	public void createcustomerTest()
	{
		System.out.println("customer created");	
	}
	@Test(dependsOnMethods = "createcustomerTest")
	public void modifycustomerTest()
	{
		System.out.println("customer modified");
	}
	@Test(dependsOnMethods = "createcustomerTest")
	public void deletecustomerTest()
	{
		System.out.println("customer deleted");
	}
}
