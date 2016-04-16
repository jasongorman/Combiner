# Combiner
Spike for combinatorial test case generator

Provided with absolutely no warranty, though it has been sort-of kind-of tested.

To generate an Object array of combinations of values to be used in your parameterised tests, call the static Combiner.combine() method, with an array of parameter value arrays:

```java
import static org.junit.Assert.*;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static com.codemanship.testutils.Combiner.combine;

@RunWith(JUnitParamsRunner.class)
public class CombinerExampleTests {
	
	private Object programmingPairs(){
		return combine(new Object[][]{
				{new Programmer("Jane"), new Programmer("Fred"), new Programmer("Ivan")},
				{new Programmer("Paul"), new Programmer("Raj"), new Programmer("Claudia")}
				
		});
	}

	@Test
	@Parameters(method="programmingPairs")
	public void allPairsProduceGoodCode(Programmer mentor, Programmer trainee) {
		ProgrammingPair pair = new ProgrammingPair(mentor, trainee);
		Code code = pair.program();
		assertTrue(code.isGood());
	}
}
```

If your parameter values generate too many combinations, you can generate pairwise combinations instead, which should dramatically reduce the number of test cases while retaining decent assurance:

```java
import static com.codemanship.testutils.Pairwise.pairwise;

@RunWith(JUnitParamsRunner.class)
public class CombinerExampleTests {
	
	private Object programmingPairs(){
		return pairwise(new Object[][]{
				{new Programmer("Jane"), new Programmer("Fred"), new Programmer("Ivan")},
				{new Programmer("Paul"), new Programmer("Raj"), new Programmer("Claudia")}
				
		});
	}
```

To generate a range of numeric values for a test parameter, use the Range.range() static method:

```java
import static com.codemanship.testutils.Pairwise.pairwise;

@RunWith(JUnitParamsRunner.class)
import static com.codemanship.testutils.Range.range;

@RunWith(JUnitParamsRunner.class)
public class CombinerExampleTests {
	
	private Object locRange(){
		return range(1,100000, 100);
	}

	@Test
	@Parameters(method="locRange")
	public void sallyAndJimProduceGoodCodeAtAnyScale(long linesOfCode) {
		Programmer sally = new Programmer("Sally");
		Programmer jim = new Programmer("Jim");
		ProgrammingPair pair = new ProgrammingPair(sally , jim);
		Code code = pair.program(linesOfCode);
		assertTrue(code.isGood());
	}
}
```


