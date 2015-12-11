package com.luxoft.cantor.support;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Modeling {
	private static String dataFormat = "yyyy-MM-dd-hh.mm.ss";
	
	public static String getCurrentDateAsString() {
	    Date today = Calendar.getInstance()
	    					 .getTime();
	    SimpleDateFormat formatter = new SimpleDateFormat(dataFormat);
	 
	    return formatter.format(today);
	}
}
