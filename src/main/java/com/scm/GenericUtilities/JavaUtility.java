package com.scm.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class JavaUtility {

	public int getRandomNo() 
	{
		Random r=new Random(9);
		int random = r.nextInt();
		return random;
	}
	
	public String getSystemDate()
	{
		Date dt=new Date();
		String date = dt.toString();
		return date;
	}
	
	public String getSystemDateAndTimeInFormat()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date systemDate = new Date();
		String getDateAndTime = dateFormat.format(systemDate);
		System.out.println(getDateAndTime);
		return getDateAndTime.replaceAll(":", "-");
	}

}
