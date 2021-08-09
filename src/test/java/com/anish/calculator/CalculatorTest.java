package com.anish.calculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
	private Calculator calculator = new Calculator();
	
	@Test
	public void testSum() {
		System.out.println("################################TEST APPLICATION TEST");
		assertEquals(5, calculator.sum(2, 3));
		assertEquals(5, calculator.sum(2, 3));
		assertEquals(5, calculator.sum(2, 3));
		assertEquals(5, calculator.sum(2, 3));
		assertEquals(5, calculator.sum(2, 3));
		assertEquals(5, calculator.sum(2, 3));
		assertEquals(54, calculator.sum(22, 32));
		assertEquals(50, calculator.sum(20, 30));
	}
}
