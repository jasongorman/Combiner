package com.codemanship.testutils;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RangeTests {
	
	private final Object[] expectedValues;
	private final double start;
	private final double end;
	private final double increment;
	private final Class<Integer> numberType;

	public RangeTests(Class<Integer> numberType, Object[] expected, double start, double end, double increment) {
		this.numberType = numberType;
		this.expectedValues = expected;
		this.start = start;
		this.end = end;
		this.increment = increment;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
				{int.class, new Object[]{1,2,3}, 1,3,1},
				{long.class, new Object[]{1L, 2L, 3L}, 1L, 3L, 1L},
				{short.class, new Object[]{(short)1,(short)2,(short)3}, 1, 3, 1},
				{float.class, new Object[]{1f,2f,3f},1,3,1},
				{double.class, new Object[]{1d,2d,3d},1,3,1},
				{int.class, new Object[]{}, 3,1,1}
		});
	}

	@Test
	public void generatesArrayOfValuesBetweenStartAndEnd() {
		assertArrayEquals(expectedValues, new Range().range(numberType,start,end,increment));
	}

}
