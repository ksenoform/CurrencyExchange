package com.luxoft.cantor.repository;

import java.math.BigDecimal;
import java.util.Date;

public class DateAndRateOfDibs {
	private Date dibsDate = null;
	private BigDecimal dibsRate = null;

	public DateAndRateOfDibs(String dibsRate) {
		this.dibsDate = new Date();
		this.dibsRate = new BigDecimal(dibsRate);
	}
	
	public DateAndRateOfDibs(BigDecimal dibsRate) {
		this.dibsDate = new Date();
		this.dibsRate = dibsRate;
	}

	public BigDecimal getDibsRate() {
		return dibsRate;
	}
	
	public void setDibsRate(BigDecimal dibsRate) {
		this.dibsRate = dibsRate;
	}
	
	public Date getDibsDate() {
		return dibsDate;
	}

	public void setDibsDate(Date dibsDate) {
		this.dibsDate = dibsDate;
	}
}
