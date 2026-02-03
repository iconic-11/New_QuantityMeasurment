
package org.example;

import org.example.QuantityMeasurmentApp.Feet;
import org.example.QuantityMeasurmentApp.Inches;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void testFeetEquality_SameReferance(){
        Feet f1=new Feet(1.0);
        assertTrue(f1.equals(f1));
    }
    //for inches
    @Test
    public void testInchesEquality_SameValue(){
        Inches i1=new Inches(1.0);
        Inches i2=new Inches(1.0);
        assertTrue(i1.equals(i2));
    }

    @Test
    public void testInchesEquality_DifferentValue(){
        Inches i1=new Inches(1.0);
        Inches i2=new Inches(2.0);
        assertFalse(i1.equals(i2));
    }

    @Test
    public void testInchesEquality_NullComparison(){
        Inches i1=new Inches(1.0);
        assertFalse(i1.equals(null));
    }

    @Test
    public void testInchesEquality_NonNumericInput(){
        Inches i1=new Inches(1.0);
        assertFalse(i1.equals("one"));
    }

    @Test
    public void testInchesEquality_SameReferance(){
        Inches i1=new Inches(1.0);
        assertTrue(i1.equals(i1));
    }

    // Test cases for UC3 -> Length
    @Test
    public void testFeetEquality() {
        Length feet1 = new Length(1.0, Length.LengthUnit.Feet);
        Length feet2 = new Length(1.0, Length.LengthUnit.Feet);

        assertTrue(feet1.equals(feet2));
    }

    @Test
    public void testInchesEquality() {
        Length inches1 = new Length(1.0, Length.LengthUnit.Inches);
        Length inches2 = new Length(1.0, Length.LengthUnit.Inches);

        assertTrue(inches1.equals(inches2));
    }
    @Test
    public void testFeetInchesComparison()
    {
        Length feet = new Length(1.0, Length.LengthUnit.Feet);
        Length inch = new Length(12.0, Length.LengthUnit.Inches);

        assertTrue(feet.equals(inch));

    }
    @Test
    public void testFeetInequality()
    {
        Length feet1 = new Length(1.0,Length.LengthUnit.Feet);
        Length feet2 = new Length(3.0, Length.LengthUnit.Feet);

        assertFalse(feet1.equals(feet2));

    }
    @Test
    public void testInchesInequality()
    {
        Length inch1 = new Length(10.0,Length.LengthUnit.Inches);
        Length inch2 = new Length(30.0, Length.LengthUnit.Inches);
        assertFalse(inch1.equals(inch2));
    }
    @Test
    public void testcrossUnitInequality()
    {

        Length feet = new Length(1.0, Length.LengthUnit.Feet);
        Length inches = new Length(10.0, Length.LengthUnit.Inches);

        assertFalse(feet.equals(inches));
    }
    @Test
    public void testMultipleFeetComparison()
    {
        Length feet1 = new Length(3.0, Length.LengthUnit.Feet);
        Length feet2 = new Length(36.0, Length.LengthUnit.Inches);

        assertTrue(feet1.equals(feet2));

    }

}

