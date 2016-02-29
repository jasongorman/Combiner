package com.codemanship.testutils;

import java.util.ArrayList;
import java.util.List;

public class Pairwise {

	private Object[][] parameters;
	private List<ValuePair> valuePairs;

	public Object[][] pairwiseArray(Object[][] parameters) {
		this.parameters = parameters;
		if(parameters.length == 1)
			return parameters;
		
		this.valuePairs = calculatePairs();
		
		Object[][] testCases = generateTestCases(getValuePairs());
		
		return testCases;
	}

	private Object[][] generateTestCases(List<ValuePair> valuePairs) {
		List<Object[]> testCases = new ArrayList<Object[]>();
		for (ValuePair pair : valuePairs) {
			if(!pair.isCovered()){
				testCases.add(pair.toTestCase());
			}
		}
		return convertToArray(testCases);
	}

	private List<ValuePair> calculatePairs() {
		List<int[]> paramPairs = calculateParamPairs();
		
		List<ValuePair> valuePairs = new ArrayList<ValuePair>();
		
		for (int[] paramPair : paramPairs) {
			valuePairs = allValuePairs(paramPair, valuePairs);
		}
		return valuePairs;
	}

	List<int[]> calculateParamPairs() {
		List<int[]> paramPairs = new ArrayList<int[]>();

		for (int i = 0; i < parameters.length; i++) {
			for (int j = 0; j < parameters.length; j++) {
				if(j > i) paramPairs.add(new int[]{i,j});
			}
		}
		return paramPairs;
	}

	private Object[][] convertToArray(List<Object[]> testCases) {
		Object[][] combined = new Object[testCases.size()][];
		
		for (int combinationIndex = 0; combinationIndex < testCases.size(); combinationIndex++) {
			combined[combinationIndex] = testCases.get(combinationIndex);
		}
		return combined;
	}

	private List<ValuePair> allValuePairs(int[] paramPair, List<ValuePair> valuePairs) {		
		Object[] parameterA = parameters[paramPair[0]];
		Object[] parameterB = parameters[paramPair[1]];
		for (Object valueA : parameterA ) {
			for (Object valueB : parameterB) {
				ValuePair pair  = new ValuePair(parameters, paramPair[0], valueA, paramPair[1], valueB, valuePairs);
				valuePairs.add(pair);
			}
		}
		return valuePairs;
	}

	public static Object[][] pairwise(Object[][] input) {
		return new Pairwise().pairwiseArray(input );
	}

	public List<ValuePair> getValuePairs() {
		return valuePairs;
	}

}
