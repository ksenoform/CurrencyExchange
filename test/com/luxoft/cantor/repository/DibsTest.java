package com.luxoft.cantor.repository;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class DibsTest {
	private Dibs dibs;
	
	@Before
	public void setup() {
		dibs = new Dibs.BuildDibs()
					   .addCode("ABC")
					   .addName("ABCDol")
					   .addRate("3")
					   .build();
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
		assertTrue(dibs.getAllDibsValue().size() > 1);
	}
	
}
