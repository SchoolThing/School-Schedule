package testPackage;
import static org.junit.Assert.*;

import org.junit.Test;

import service.NumberClasses;


public class NumberClassesTest {

	@Test
	public void NumberClassesIncreaseTestOK() {
		NumberClasses num = new NumberClasses();	
		String result = num.increase(6);
		assertEquals("Increasing done.", result);
	}
	
	@Test
	public void NumberClassesIncreaseTestLesserThanZero(){
		NumberClasses num = new NumberClasses();
		String result = num.increase(-3);
		assertEquals("Error: Invalid argument. Amount should be equal to or greater than 0", result);
	}
	
	@Test
	public void NumberClassesIncreaseTestBigInitialIncrease(){
		NumberClasses num = new NumberClasses();
		String result = num.increase(10);
		assertEquals("Error: Maximum number exceeded (it's 9)", result);
	}
	
	@Test
	public void NumberClassesIncreaseTestLimit(){
		NumberClasses num = new NumberClasses();
		String result = num.increase(6);
		assertEquals("Increasing done.", result);
		result = num.increase(4);
		assertEquals("Error: Maximum number exceeded (it's 9)", result);
	}
}