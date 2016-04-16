package com.codemanship.testutils.numberconverters;

public class IntegerConverter implements NumberConverter {

	@Override
	public Object convert(double number) {
		return (int)Math.floor(number);
	}

}
