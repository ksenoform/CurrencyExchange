package com.luxoft.cantor.repository;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateAndRateOfDibs {
	private String dibsDate = null;
	private BigDecimal dibsRate = null;
	
	private String getCurrentDateAsString() {
	    Date today = Calendar.getInstance().getTime();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
	 
	    return formatter.format(today);
	}
	
	public DateAndRateOfDibs() {};

	public DateAndRateOfDibs(String dibsRate) {
		this.dibsDate = getCurrentDateAsString();
		this.dibsRate = new BigDecimal(dibsRate);
	}
	
	public DateAndRateOfDibs(BigDecimal dibsRate) {
		this.dibsDate = getCurrentDateAsString();
		this.dibsRate = dibsRate;
	}

	public BigDecimal getDibsRate() {
		return dibsRate;
	}
	
	public void setDibsRate(BigDecimal dibsRate) {
		this.dibsRate = dibsRate;
	}
	
	public String getDibsDate() {
		return dibsDate;
	}

	public void setDibsDate(String dibsDate) {
		this.dibsDate = dibsDate;
	}
}
