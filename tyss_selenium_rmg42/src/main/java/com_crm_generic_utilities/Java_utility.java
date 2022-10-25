package com_crm_generic_utilities;

import java.util.Random;

public class Java_utility {
	
	/*
	 * this method is used to avoid duplicate value
	 * return
	 * author manjunath
	 */
	
	public int getRandomNum()
	{
		Random ran = new Random();
		int rannum = ran.nextInt(1000);
		
		return rannum;
	}

}
