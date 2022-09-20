package org.tyss.ProvidenceSMS.genericUtility;

import java.util.Random;

public class JavaUtility {

	/**
	 * This method is used to generate random number
	 * @param limit
	 * @return
	 */
	public int getRandomNumber(int limit) 
	{
		return new Random().nextInt(limit);
	}
	
	/**
	 * This method is used to convert String to any DataType based on strategy
	 * @param data
	 * @param stratergy
	 * @return
	 */
	public Object convertStringToAnyData(String data, DataType stratergy)
	{
		Object obj =null;
		if(stratergy.toString().equalsIgnoreCase("long"))
		{
			obj=Long.parseLong(data);
		}
		else if(stratergy.toString().equalsIgnoreCase("int"))
		{
			obj=Integer.parseInt(data);
		}
		else if(stratergy.toString().equalsIgnoreCase("double"))
		{
			obj=Double.parseDouble(data);
		}
		return obj;
	}
}
	


