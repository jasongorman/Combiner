package com.codemanship.testutils;
import static com.codemanship.testutils.Combiner.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.codemanship.testutils.Combiner;

public class CombinerTests {

	@Test
	public void foo() {
		assertArrayEquals(new Object[][]{{1}}, combine(new Object[][]{{1}}));
	}
	
	@Test
	public void twoArraysWithOneElementAndTwoElementsReturnedAsTwoCombinations() throws Exception {
		assertArrayEquals(new Object[][]{{1,2},{1,3}}, 
								combine(new Object[][]{{1},{2,3}}));
	}
	
	@Test
	public void twoArraysWithTwoElementsEachReturnedAsFourCombinations() throws Exception {
		assertArrayEquals(new Object[][]{{1,3},{1,4},{2,3},{2,4}}, 
								combine((new Object[][]{{1,2},{3,4}})));
	}
	
	@Test
	public void threeArraysReturnCombinationsWithThreeElements() throws Exception {
		assertArrayEquals(new Object[][]{{1,2,3}}, 
								combine(new Object[][]{{1},{2},{3}}));
	}
	
	@Test
	public void threeArraysOfTwoElementsReturnEightCombinations() throws Exception {
		assertArrayEquals(new Object[][]{
				{1,"A",true}, 
				{1,"A",false},
				{1,"B",true},
				{1,"B",false},
				{2,"A",true}, 
				{2,"A",false},
				{2,"B",true},
				{2,"B",false}},
				combine(new Object[][]{{1,2},{"A","B",},{true,false}}));
	}
	
	@Test
	public void fourArraysOfOneTwoThreeAndOneElementsReturnSixCombinations() throws Exception {
		Object a = new Integer(1);
		Object b = new Combiner();
		
		assertArrayEquals(new Object[][]{
				{a,b,1,"A"},
				{a,b,2,"A"},
				{a,b,3,"A"},
				{a,null,1,"A"},
				{a,null,2,"A"},
				{a,null,3,"A"}},		
				combine(new Object[][]{{a},{b,null},{1,2,3},{"A"}}));
	}
	
}
