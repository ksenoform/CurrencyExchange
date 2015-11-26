package com.luxoft.cantor.repository;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DateAndRateOfDibsTest {
	@Mock
	BigDecimal bigDecimal;
	DateAndRateOfDibs dateAndRate;
	
	@Test
	public void shouldReturnCorrectDataForAddedRate() {
		dateAndRate = new DateAndRateOfDibs(bigDecimal);
		assertEquals(new Date(), dateAndRate.getDibsDate());
	}

}
