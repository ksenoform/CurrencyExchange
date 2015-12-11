package com.luxoft.cantor.support;

import static org.junit.Assert.*;

import org.junit.Test;

public class Getting3TextValuesFromPageTest {
	private Getting3TextValuesFromPage value3 = new Getting3TextValuesFromPage();
	
	@Test
	public void testGetterAndSetterForCode() {
		String code = "code";
		value3.setCode(code);
		assertEquals(code, value3.getCode());
	}

	@Test
	public void testGetterAndSetterForName() {
		String name = "name";
		value3.setName(name);
		assertEquals(name, value3.getName());
	}

	@Test
	public void testGetterAndSetterForValue() {
		String value = "value";
		value3.setValue(value);
		assertEquals(value, value3.getValue());
	}

}
