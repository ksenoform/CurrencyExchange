package com.luxoft.cantor.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class DibsTest {
	private Dibs dibs;
	private Dibs emptyDids;
	
	@Before
	public void setup() {
		dibs = new Dibs.BuildDibs()
					   .addCode("ABC")
					   .addName("ABCDol")
					   .addRate("3")
					   .build();
		
		emptyDids = new Dibs();
	}
	
	@Test
	public void checkIfCodeIsABC() {
		assertEquals("ABC", dibs.getDibsCode());
	}
	
	@Test
	public void checkIfNameIsABCDol() {
		assertEquals("ABCDol", dibs.getDibsName());
	}
	
	@Test
	public void checkIfValueRateIsTheSameAsDefaultValueAndLastInDB() {
		assertEquals(dibs.getDibsRate(), dibs.getRateAndDateOfLastDibs().getDibsRate());
	}

	@Test
	public void checkIfRateVariableWillChangeAfterUpdateRate() {
		dibs.setDibsRate(new BigDecimal(8));
		assertEquals(dibs.getDibsRate(), dibs.getRateAndDateOfLastDibs().getDibsRate());
	}
	
	@Test
	public void checkIfInListAreMoreThen1Element() {
		dibs.setDibsRate(new BigDecimal(8));
		assertTrue(dibs.getDibsRateList().size() > 1);
	}
	
	@Test
	public void checkGeterAndSetterForDibsRate() {
		emptyDids.setDibsRate(new BigDecimal("2"));
		assertEquals(new BigDecimal(2), emptyDids.getDibsRate());
	}
	
	@Test
	public void checkGetterEndSetterForDibsName() {
		String name = "Some Name";
		emptyDids.setDibsName(name);
		assertEquals(name, emptyDids.getDibsName());
	}

	@Test
	public void checkGetterEndSetterForDibsCode() {
		String code = "Some Code";	
		emptyDids.setDibsCode(code);
		assertEquals(code, emptyDids.getDibsCode());
	}
	
	@Test
	public void checkIfTheChangeOfDibsRatesWorks() {
		DateAndRateOfDibs dateAndRateOfDibs = dibs.getRateAndDateOfLastDibs();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		dibs.setDibsRate(new BigDecimal(30));
		assertEquals(new BigDecimal(30), dibs.getDibsRate());
		dibs.setActiveRate(dateAndRateOfDibs.getDibsDate());
		assertEquals(new BigDecimal(3), dibs.getDibsRate());
	}

	@Test
	public void checkIfTheDeleteOfDibsRatesWorks() {
		DateAndRateOfDibs dateAndRateOfDibs = dibs.getRateAndDateOfLastDibs();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		dibs.setDibsRate(new BigDecimal(30));
		assertEquals(new BigDecimal(30), dibs.getDibsRate());
		dibs.deleteRateFromList(dateAndRateOfDibs.getDibsDate());
		assertEquals(1, dibs.getDibsRateList().size());
	}

	
}
