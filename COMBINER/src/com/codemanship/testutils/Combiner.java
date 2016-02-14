package com.codemanship.testutils;

public class Combiner {

	private Object[][] combined;

	private Object[][] combineArrays(Object[][] arrays) {
		buildEmptyCombinedArray(arrays);		
		populateCombinedArray(arrays);			
		return combined;
	}

	private void populateCombinedArray(Object[][] arrays) {
		for (int i = 0; i < arrays.length; i++) {
			populateColumn(arrays, i);
		}
	}

	private void populateColumn(Object[][] arrays, int columnIndex) {
		int repetitions = calculateRepetitions(arrays, columnIndex);
		insertColumnValues(columnIndex, repetitions, arrays[columnIndex]);
	}

	private void insertColumnValues(int columnIndex, int repetitions,
			Object[] columnSource) {
		for(int i = 0; i < combined.length; i += (repetitions * columnSource.length)){
			for(int j = 0;j < columnSource.length;j++){ 
				for(int k = 0;k < repetitions;k++){
					combined[i + (j * repetitions) + k][columnIndex] = columnSource[j];
				}
			}
		}
	}

	private int calculateRepetitions(Object[][] arrays, int columnIndex) {
		int repetitions = 1;
		for (int i = 0; i < arrays.length; i++) {
			if(i > columnIndex){
				repetitions *= arrays[i].length;
			}
		}
		return repetitions;
	}

	private void buildEmptyCombinedArray(Object[][] arrays) {
		int numberOfArrays = arrays.length;
		int numberOfCombinations = 1;
		for (Object[] array : arrays) {
			numberOfCombinations *= array.length;
		}
		combined = new Object[numberOfCombinations][numberOfArrays];
	}

	public static Object[][] combine(Object[][] arrays) {
		return new Combiner().combineArrays(arrays);
	}

}
