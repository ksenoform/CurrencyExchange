package com.luxoft.cantor.repository;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.luxoft.cantor.support.Modeling;

@RunWith(MockitoJUnitRunner.class)
public class DateAndRateOfDibsTest {
	@Mock
	BigDecimal bigDecimal;
	DateAndRateOfDibs dateAndRate;
	
	@Test
	public void shouldReturnCorrectDataForAddedRateAsBigDecimal() {
		dateAndRate = new DateAndRateOfDibs(bigDecimal);
		assertEquals(Modeling.getCurrentDateAsString(), dateAndRate.getDibsDate());
	}
	
	@Test
	public void shouldReturnCorrectDataForAddedRateAsString() {
		dateAndRate = new DateAndRateOfDibs("22");
		assertEquals(Modeling.getCurrentDateAsString(), dateAndRate.getDibsDate());
	}
	
	@Test
	public void shouldChangeDate() {
		dateAndRate = new DateAndRateOfDibs(bigDecimal);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		dateAndRate.setDibsDate(Modeling.getCurrentDateAsString());
		assertEquals(Modeling.getCurrentDateAsString(), dateAndRate.getDibsDate());
	}
	
	@Test
	public void shouldChangeRate() {
		dateAndRate = new DateAndRateOfDibs();
		dateAndRate.setDibsRate(new BigDecimal(30));
		assertEquals(new BigDecimal(30), dateAndRate.getDibsRate());
	}
}
