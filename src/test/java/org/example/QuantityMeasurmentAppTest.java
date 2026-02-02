package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.example.QuantityMeasurmentApp.Feet;


public class QuantityMeasurmentAppTest {

    @Test
    public void testFeetEquality_SameValue(){
        Feet f1=new Feet(1.0);
        Feet f2=new Feet(1.0);
        assertTrue(f1.equals(f2));
    }

    @Test
    public void testFeetEquality_DifferentValue(){
        Feet f1=new Feet(1.0);
        Feet f2=new Feet(2.0);
        assertFalse(f1.equals(f2));
    }

    @Test
    public void testFeetEquality_NullComparison(){
        Feet f1=new Feet(1.0);
        assertFalse(f1.equals(null));
    }

    @Test
    public void testFeetEquality_NonNumericInput(){
        Feet f1=new Feet(1.0);
        assertFalse(f1.equals("one"));
    }
}
