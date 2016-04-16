package com.codemanship.testutils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codemanship.testutils.numberconverters.DoubleConverter;
import com.codemanship.testutils.numberconverters.FloatConverter;
import com.codemanship.testutils.numberconverters.IntegerConverter;
import com.codemanship.testutils.numberconverters.LongConverter;
import com.codemanship.testutils.numberconverters.NumberConverter;
import com.codemanship.testutils.numberconverters.ShortConverter;

public class Range {

	private Map<Class<?>, NumberConverter> converters;
	
	Range(){
		initConverters();
	}
	
	public static Object[] range(short start, short end, short increment){
		return new Range().range(short.class, start, end, increment);
	}
	
	public static Object[] range(int start, int end, int increment){
		return new Range().range(int.class, start, end, increment);
	}	
	
	public static Object[] range(long start, long end, long increment){
		return new Range().range(long.class, start, end, increment);
	}
	
	public static Object[] range(float start, float end, float increment){
		return new Range().range(float.class, start, end, increment);
	}
	
	public static Object[] range(double start, double end, double increment){
		return new Range().range(double.class, start, end, increment);
	}


	Object[] range(Class<?> T, double start, double end, double increment) {
		if(increment <= 0)
			throw new IllegalArgumentException("Increment must be a positive non-zero number");
		List<Object> values = new ArrayList<Object>();
		while (start <= end){
			values.add(convert(T, start));
			start += increment;
		}
		return values.toArray();
	}

	private void initConverters() {
		converters = new HashMap<Class<?>,NumberConverter>();
		converters.put(int.class, new IntegerConverter());
		converters.put(long.class, new LongConverter());
		converters.put(short.class, new ShortConverter());
		converters.put(float.class, new FloatConverter());
		converters.put(double.class, new DoubleConverter());
	}
	
	private Object convert(Class<?> numericType, double number) {
		NumberConverter converter = converters.get(numericType);
		if(converter == null)
			throw new IllegalArgumentException("Number type must be short, int, long, float or double");
		return converter.convert(number);
	}

}
