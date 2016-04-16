package com.codemanship.testutils;

import static org.junit.Assert.*;

import org.junit.Test;

public class RangeEdgeTests {

	
	@Test(expected=IllegalArgumentException.class)
	public void numberTypeMustBeATypeOfNumber() throws Exception {
		new Range().range(Range.class, 1, 2, 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void incrementMustBeGreaterThanZero() throws Exception {
		new Range().range(Range.class, 1, 2, -1);
	}
	
	@Test
	public void handlesBigRange() throws Exception {
		assertEquals(10000, new Range().range(float.class, 0,1000,0.1).length);
	}


}
