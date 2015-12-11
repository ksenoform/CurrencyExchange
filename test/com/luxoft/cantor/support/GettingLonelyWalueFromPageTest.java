package com.luxoft.cantor.support;

import static org.junit.Assert.*;

import org.junit.Test;

public class GettingLonelyWalueFromPageTest {
	GettingLonelyValueFromPage lonelyValue = new GettingLonelyValueFromPage();
	
	@Test
	public void testGetterAndSetterForLonelyValue() {
		String hermit = "hermit";
		lonelyValue.setHermit(hermit);
		assertEquals(hermit, lonelyValue.getHermit());
	}

}
