package com.codemanship.testutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combiner {

	private Object[][] combined;

	private Object[][] combineArrays(Object[][] arrays) {
		List<List<Object>> combinations = new ArrayList<List<Object>>();
		for (Object[] parameterValues : arrays) {
			combinations = combine(combinations, parameterValues);
		}
		combined = new Object[combinations.size()][];
		for (int combinationIndex = 0; combinationIndex < combinations.size(); combinationIndex++) {
			combined[combinationIndex] = combinations.get(combinationIndex).toArray();
		}
		return combined;
	}

	private List<List<Object>> combine(List<List<Object>> existingCombinations, Object[] parameterValues) {
		List<List<Object>> newCombinations = new ArrayList<List<Object>>();
		initialiseCombinations(existingCombinations, parameterValues, newCombinations);
		for (List<Object> existingCombination : existingCombinations) {
			for (Object parameterValue : parameterValues) {
				List<Object> newCombination = new ArrayList<Object>();
				newCombination.addAll(existingCombination);
				newCombination.add(parameterValue);
				newCombinations.add(newCombination);
			}
		}
		return newCombinations;
	}

	private void initialiseCombinations(List<List<Object>> existingCombinations, Object[] parameterValues, List<List<Object>> newCombinations) {
		if (existingCombinations.isEmpty()) {
			for (Object parameterValue : parameterValues) {
				newCombinations.add(Arrays.asList(parameterValue));
			}
		}
	}

	public static Object[][] combine(Object[][] arrays) {
		return new Combiner().combineArrays(arrays);
	}


}
