package com.codemanship.testutils.numberconverters;

public class ShortConverter implements NumberConverter {

	@Override
	public Object convert(double number) {
		return (short)Math.floor(number);
	}

}
