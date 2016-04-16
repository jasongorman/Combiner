package com.codemanship.testutils.numberconverters;

public class LongConverter implements NumberConverter {

	@Override
	public Object convert(double number) {
		return (long)Math.floor(number);
	}

}
