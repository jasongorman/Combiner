package com.codemanship.testutils;

import java.util.ArrayList;
import java.util.List;

public class ValuePair {

	private int indexA;
	private Object valueA;
	private int indexB;
	private Object valueB;
	private Object[][] parameters;
	private List<ValuePair> allPairs;
	private boolean covered;
	
	public ValuePair(Object[][] parameters, int indexA, Object valueA, int indexB, Object valueB, List<ValuePair> allPairs) {
		this.parameters = parameters;
		this.indexA = indexA;
		this.valueA = valueA;
		this.indexB = indexB;
		this.valueB = valueB;
		this.allPairs = allPairs;
		this.setCovered(false);
	}

	Object[][] getParameters() {
		return parameters;
	}

	Object getValueB() {
		return valueB;
	}

	int getIndexB() {
		return indexB;
	}

	Object getValueA() {
		return valueA;
	}

	int getIndexA() {
		return indexA;
	}

	Object[] toTestCase() {
		Attempt best = new AttemptList().generateBestTestCase(this);
		updateCoverage(best);		
		return best.getValues();
	}

	List<ValuePair> findCoveredPairs(Object[] values) {
		List<ValuePair> covered = new ArrayList<ValuePair>();
		for (ValuePair pair : allPairs) {
			updatePairCoverage(values, covered, pair);
		}
		return covered;
	}
	
	private void updateCoverage(Attempt bestAttempt) {
		for (ValuePair valuePair : bestAttempt.getCovered()) {
			valuePair.setCovered(true);
		}
	}

	private void updatePairCoverage(Object[] values, List<ValuePair> covered,
			ValuePair pair) {
		if(!pair.isCovered()){
			addCoveredPair(values, covered, pair);
		}
	}

	private void addCoveredPair(Object[] values, List<ValuePair> covered,
			ValuePair pair) {
		if(pair.coveredBy(values)){
			covered.add(pair);
		}
	}

	private boolean coveredBy(Object[] values) {
		return values[getIndexA()] == valueA && values[indexB] == valueB;
	}

	boolean isCovered() {
		return covered;
	}

	private void setCovered(boolean covered) {
		this.covered = covered;
	}

}
