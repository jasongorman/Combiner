package com.codemanship.testutils;

import java.util.List;

public class Attempt {

	private List<ValuePair> covered;
	private Object[] values;

	public Attempt(ValuePair valuePair) {
		create(valuePair);
	}

	private void create(ValuePair valuePair) {
		Object[] values = new Object[valuePair.getParameters().length];
		values[valuePair.getIndexA()] = valuePair.getValueA();
		values[valuePair.getIndexB()] = valuePair.getValueB();
		for (int i = 0; i < valuePair.getParameters().length; i++) {
			if(i != valuePair.getIndexA() && i != valuePair.getIndexB()){
				values[i] = new RandomValueSelector().randomValue(valuePair.getParameters()[i]);
			}
		}
		List<ValuePair> covered = valuePair.findCoveredPairs(values);
		this.values = values;
		this.covered = covered;
	}

	int valuePairsCovered() {
		return getCovered().size();
	}

	List<ValuePair> getCovered() {
		return covered;
	}

	Object[] getValues() {
		return values;
	}

}
