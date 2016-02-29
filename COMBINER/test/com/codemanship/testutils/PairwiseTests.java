package com.codemanship.testutils;

import static org.junit.Assert.*;
import static com.codemanship.testutils.Pairwise.pairwise;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PairwiseTests {

	@Test
	public void pairwiseOfSingleParameterIsSameAsInput() {
		assertArrayEquals(new Object[][]{{1}}, pairwise(new Object[][]{{1}}));
	}
	
	@Test
	public void pairwiseOfTwoParametersIsCombinationOfBoth() throws Exception {
		assertArrayEquals(new Object[][]{{1,2}}, pairwise(new Object[][]{{1},{2}}));
	}
	
	@Test
	public void pairwisedTestCasesCoverAllValuePairs() throws Exception {
		Pairwise pairwise = new Pairwise();
		pairwise.pairwiseArray(new Object[][]{
				{1,2,3},
				{1,2},
				{1,2,3,4}}		
				);
		List<ValuePair> valuePairs = pairwise.getValuePairs();	
		for (ValuePair valuePair : valuePairs) {
			assertTrue(valuePair.isCovered());
		}
	}
	
	@Test
	public void largeNumberOfPossibleCombinationsReducedDramaticallyWhenPairwised() throws Exception {
		Object[][] testCases = pairwise(new Object[][]{
				{1,2,3,4,5,6,7,8,9,10},
				{1,2,3,4,5,6,7,8,9,10},
				{1,2,3,4,5,6,7,8,9,10},
				{1,2,3,4,5,6,7,8,9,10},
				{1,2,3,4,5,6,7,8,9,10},
				{1,2,3,4,5,6,7,8,9,10}}			
				);
		System.out.println(testCases.length);
		assertTrue(testCases.length < 300);		
	}

}
