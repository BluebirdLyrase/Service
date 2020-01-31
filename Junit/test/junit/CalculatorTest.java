/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author STD-PC
 */
public class CalculatorTest {
    
    public CalculatorTest() {
    }

    @Test
    public void testAdd() {
        Calculator cal = new Calculator(); 
        assertEquals(30f, cal.add(10, 20),0.0f);
        assertEquals(-30f, cal.add(-10, -20),0.0f);
        assertEquals(10f, cal.add(-10, 20),0.0f);
        assertEquals(-10f, cal.add(10, -20),0.0f);
    }

    @Test
    public void testMinus() {
        Calculator cal = new Calculator(); 
        assertEquals(15f, cal.minus(20, 5),0.0f);
        assertEquals(-10f, cal.minus(10, 20),0.0f);
        assertEquals(10f, cal.minus(-10, -20),0.0f);
        assertEquals(-5f, cal.minus(-10, -5),0.0f);
        assertEquals(-30f, cal.minus(-10, 20),0.0f);   
        assertEquals(30f, cal.minus(10, -20),0.0f);   
    }

    @Test
    public void testDivide() {
        Calculator cal = new Calculator();
        assertEquals(4f, cal.divide(20, 5),0.0f);
        assertEquals(-4f, cal.divide(20, -5),0.0f);
        assertEquals(-4f, cal.divide(-20, 5),0.0f);
        assertEquals(4f, cal.divide(-20, -5),0.0f);
        assertEquals(0f, cal.divide(0, 5),0.0f);
        assertEquals(Double.POSITIVE_INFINITY, cal.divide(5, 0),0.0f);
        assertEquals(Double.NEGATIVE_INFINITY, cal.divide(-5, 0),0.0f);
    }

    @Test
    public void testModule() {
        Calculator cal = new Calculator();
        assertEquals(0f, cal.module(20, 5),0.0f);
        assertEquals(2f, cal.module(20, 6),0.0f);
        assertEquals(-2f, cal.module(-20, -6),0.0f);
        assertEquals(-2f, cal.module(-20, 6),0.0f);
        assertEquals(2f, cal.module(20, -6),0.0f);
    }

    @Test
    public void testMultiply() {
        Calculator cal = new Calculator();
        assertEquals(10f, cal.multiply(2, 5),0.0f);
        assertEquals(-10f, cal.multiply(2, -5),0.0f);
        assertEquals(10f, cal.multiply(-2, -5),0.0f);
    }
    
}
