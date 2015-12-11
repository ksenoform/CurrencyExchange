package com.luxoft.cantor.repository;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

import com.luxoft.cantor.support.Modeling;

@Embeddable
public class DateAndRateOfDibs {
	private String dibsDate = null;
	private BigDecimal dibsRate = null;
	
	public DateAndRateOfDibs() {};

	public DateAndRateOfDibs(String dibsRate) {
		this.dibsDate = Modeling.getCurrentDateAsString();
		this.dibsRate = new BigDecimal(dibsRate);
	}
	
	public DateAndRateOfDibs(BigDecimal dibsRate) {
		this.dibsDate = Modeling.getCurrentDateAsString();
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
