package com.codemanship.testutils;

import java.util.Random;

public class RandomValueSelector {

	Object randomValue(Object[] parameter) {
		int valueIndex = new Random().nextInt(parameter.length);
		return parameter[valueIndex];
	}

}
