package com.codemanship.testutils.numberconverters;

public class FloatConverter implements NumberConverter {

	@Override
	public Object convert(double number) {
		return (float)number;
	}

}
