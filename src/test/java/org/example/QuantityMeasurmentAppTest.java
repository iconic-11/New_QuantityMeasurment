
package org.example;

//import org.example.QuantityMeasurmentApp.Feet;
//import org.example.QuantityMeasurmentApp.Inches;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.LengthEnum.convert;
import static org.example.LengthEnum.parseUnit;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurmentAppTest {

//    @Test
//    public void testFeetEquality_SameValue() {
//        Feet f1 = new Feet(1.0);
//        Feet f2 = new Feet(1.0);
//        assertTrue(f1.equals(f2));
//    }
//
//    @Test
//    public void testFeetEquality_DifferentValue() {
//        Feet f1 = new Feet(1.0);
//        Feet f2 = new Feet(2.0);
//        assertFalse(f1.equals(f2));
//    }
//
//    @Test
//    public void testFeetEquality_NullComparison() {
//        Feet f1 = new Feet(1.0);
//        assertFalse(f1.equals(null));
//    }
//
//    @Test
//    public void testFeetEquality_NonNumericInput() {
//        Feet f1 = new Feet(1.0);
//        assertFalse(f1.equals("one"));
//    }
//
//    @Test
//    public void testFeetEquality_SameReferance() {
//        Feet f1 = new Feet(1.0);
//        assertTrue(f1.equals(f1));
//    }
//
//    //for Inches
//    @Test
//    public void testInchesEquality_SameValue() {
//        Inches i1 = new Inches(1.0);
//        Inches i2 = new Inches(1.0);
//        assertTrue(i1.equals(i2));
//    }
//
//    @Test
//    public void testInchesEquality_DifferentValue() {
//        Inches i1 = new Inches(1.0);
//        Inches i2 = new Inches(2.0);
//        assertFalse(i1.equals(i2));
//    }
//
//    @Test
//    public void testInchesEquality_NullComparison() {
//        Inches i1 = new Inches(1.0);
//        assertFalse(i1.equals(null));
//    }
//
//    @Test
//    public void testInchesEquality_NonNumericInput() {
//        Inches i1 = new Inches(1.0);
//        assertFalse(i1.equals("one"));
//    }
//
//    @Test
//    public void testInchesEquality_SameReferance() {
//        Inches i1 = new Inches(1.0);
//        assertTrue(i1.equals(i1));
//    }

    // Test cases for UC3 -> Length
    @Test
    public void testFeetEquality() {
        Length Feet1 = new Length(1.0, LengthEnum.Feet);
        Length Feet2 = new Length(1.0, LengthEnum.Feet);

        assertTrue(Feet1.equals(Feet2));
    }

    @Test
    public void testInchesEquality() {
        Length Inches1 = new Length(1.0, LengthEnum.Inches);
        Length Inches2 = new Length(1.0, LengthEnum.Inches);

        assertTrue(Inches1.equals(Inches2));
    }

    @Test
    public void testFeetInchesComparison() {
        Length Feet = new Length(1.0, LengthEnum.Feet);
        Length inch = new Length(12.0, LengthEnum.Inches);

        assertTrue(Feet.equals(inch));

    }

    @Test
    public void testFeetInequality() {
        Length Feet1 = new Length(1.0, LengthEnum.Feet);
        Length Feet2 = new Length(3.0, LengthEnum.Feet);

        assertFalse(Feet1.equals(Feet2));

    }

    @Test
    public void testInchesInequality() {
        Length inch1 = new Length(10.0, LengthEnum.Inches);
        Length inch2 = new Length(30.0, LengthEnum.Inches);
        assertFalse(inch1.equals(inch2));
    }

    @Test
    public void testcrossUnitInequality() {

        Length Feet = new Length(1.0, LengthEnum.Feet);
        Length Inches = new Length(10.0, LengthEnum.Inches);

        assertFalse(Feet.equals(Inches));
    }

    @Test
    public void testMultipleFeetComparison() {
        Length Feet1 = new Length(3.0, LengthEnum.Feet);
        Length Feet2 = new Length(36.0, LengthEnum.Inches);

        assertTrue(Feet1.equals(Feet2));

    }

    @Test
    public void testEquality_YardtoYard() {
        Length yard1 = new Length(34, LengthEnum.Yards);
        Length yard2 = new Length(34, LengthEnum.Yards);

        assertTrue(yard1.equals(yard2));
    }

    @Test
    public void testInEquality_YardtoYard() {
        Length yard1 = new Length(34, LengthEnum.Yards);
        Length yard2 = new Length(37, LengthEnum.Yards);

        assertFalse(yard1.equals(yard2));
    }

    @Test
    public void testEquality_YardtoFeet() {
        Length yard1 = new Length(1, LengthEnum.Yards);
        Length Feet1 = new Length(3, LengthEnum.Feet);

        assertTrue(yard1.equals(Feet1));
    }

    @Test
    public void testInEquality_YardtoFeet() {
        Length yard1 = new Length(10, LengthEnum.Yards);
        Length Feet1 = new Length(37, LengthEnum.Feet);

        assertFalse(yard1.equals(Feet1));
    }

    @Test
    public void testEquality_YardtoInches() {
        Length yard1 = new Length(1, LengthEnum.Yards);
        Length inch1 = new Length(36, LengthEnum.Inches);

        assertTrue(yard1.equals(inch1));
    }

    @Test
    public void testInEquality_YardtoInches() {
        Length yard1 = new Length(1, LengthEnum.Yards);
        Length inch1 = new Length(35, LengthEnum.Inches);

        assertFalse(yard1.equals(inch1));
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {
        Length cm = new Length(30.48, LengthEnum.Centimeters);
        Length foot = new Length(1.0, LengthEnum.Feet);

        assertTrue(cm.equals(foot));
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {
        Length l1 = new Length(1.0, LengthEnum.Yards);
        Length l2 = new Length(3.0, LengthEnum.Feet);
        Length l3 = new Length(36.0, LengthEnum.Inches);

        assertTrue(l1.equals(l2)); // symmetric
        assertTrue(l2.equals(l3)); // transitive
        assertTrue(l1.equals(l3)); // transitive
    }

    @Test
    void testEquality_YardToInches_equivalentValue() {
        Length len1 = new Length(1.0, LengthEnum.Yards);
        Length len2 = new Length(36.0, LengthEnum.Inches);

        assertTrue(len1.equals(len2), "Expected 1 YARD to be equal to 36 Inches");
        assertTrue(len2.equals(len1), "Expected symmetry: 36 Inches equals 1 YARD");
    }

    @Test
    void testEquality_CmToInches_equivalentValue() {
        // 2.54 cm = 1 inch
        Length len1 = new Length(2.54, LengthEnum.Centimeters);
        Length len2 = new Length(1.0, LengthEnum.Inches);

        assertTrue(len1.equals(len2), "Expected 2.54 CM to be equal to 1 Inch");
        assertTrue(len2.equals(len1), "Expected symmetry: 1 Inch equals 2.54 CM");
    }

    @Test
    void testEquality_YardToInches_notEquivalentValue() {
        Length len1 = new Length(1.0, LengthEnum.Yards);
        Length len2 = new Length(35.0, LengthEnum.Inches);

        assertFalse(len1.equals(len2), "Expected 1 YARD to NOT be equal to 35 Inches");
        assertFalse(len2.equals(len1), "Expected symmetry: 35 Inches to NOT equal 1 YARD");
    }

    @Test
    void testEquality_CmToInches_notEquivalentValue() {
        // 2.54 cm = 1 inch, so 2.0 cm must NOT equal 1 inch
        Length len1 = new Length(2.0, LengthEnum.Centimeters);
        Length len2 = new Length(1.0, LengthEnum.Inches);

        assertFalse(len1.equals(len2), "Expected 2.0 CM to NOT be equal to 1 Inch");
        assertFalse(len2.equals(len1), "Expected symmetry: 1 Inch to NOT equal 2.0 CM");
    }

    @Test
    public void FeetToFeet_sameValue() {
        Length len1 = new Length(1.0, LengthEnum.Feet);
        Length len2 = new Length(1.0, LengthEnum.Feet);
        boolean result = len1.equals(len2);
        assertTrue(result, "Expected 1 Feet to be equal to 1 Feet");
    }

    @Test
    public void inchToInch_sameValue() {
        Length len1 = new Length(1.0, LengthEnum.Inches);
        Length len2 = new Length(1.0, LengthEnum.Inches);
        boolean result = len1.equals(len2);
        assertTrue(result, "Expected 1 INCH to be equal to 1 INCH");
    }

    @Test
    public void test_Equality_NullComparison() {
        Length len = new Length(1.0, LengthEnum.Feet);
        assertNotEquals(null, len, "Expected equals(null) to return false");
    }

    @Test
    public void testEquality_12InchEquals1Feet_symmetry() {
        Length lenInInch = new Length(12.0, LengthEnum.Inches);
        Length lenInFeet = new Length(1.0, LengthEnum.Feet);
        assertEquals(lenInInch, lenInFeet);
        assertEquals(lenInFeet, lenInInch);
    }

    @Test
    public void testEquality_InchToInch_DifferentValue() {
        Length len1 = new Length(10.0, LengthEnum.Inches);
        Length len2 = new Length(12.0, LengthEnum.Inches);
        boolean result = len1.equals(len2);

        assertFalse(result, "Expected 10 Inches to NOT be equal to 12 Inches");
    }

    @Test
    public void TesteEquality_NullComparison() {
        Length len = new Length(1.0, LengthEnum.Feet);
        boolean result = len.equals(null);
        assertFalse(result, "Expected equals(null) to return false");
    }

    @Test
    public void testEquality_FeetToFeet_sameValue() {
        Length len1 = new Length(1.0, LengthEnum.Feet);
        Length len2 = new Length(1.0, LengthEnum.Feet);
        assertEquals(len1, len2, "Expected 1 Feet to be equal to 1 Feet");
    }

    @Test
    public void testEquality_InchToInch_sameValue() {
        Length len1 = new Length(1.0, LengthEnum.Inches);
        Length len2 = new Length(1.0, LengthEnum.Inches);
        assertEquals(len1, len2, "Expected 1 Inch to be equal to 1 Inch");
    }

    @Test
    public void testEquality_InchToInch_differentValue() {
        Length len1 = new Length(10.0, LengthEnum.Inches);
        Length len2 = new Length(12.0, LengthEnum.Inches);
        assertNotEquals(len1, len2, "Expected 10 Inches to NOT be equal to 12 Inches");
    }


    @Test
    public void testEquality_FeetToInch_symmetry_12InchEquals1Feet() {
        Length lenInInch = new Length(12.0, LengthEnum.Inches);
        Length lenInFeet = new Length(1.0, LengthEnum.Feet);
        assertEquals(lenInInch, lenInFeet, "Expected 12 Inches to be equal to 1 Feet");
        assertEquals(lenInFeet, lenInInch, "Expected symmetry for equals()");
    }

    @Test
    public void testEquality_NullComparison() {
        Length len = new Length(1.0, LengthEnum.Feet);
        assertNotEquals(null, len, "Expected equals(null) to return false");
    }

    @Test
    public void testEquality_YardToYard_sameValue() {
        Length len1 = new Length(1.0, LengthEnum.Yards);
        Length len2 = new Length(1.0, LengthEnum.Yards);
        assertEquals(len1, len2, "Expected 1 YARD to be equal to 1 YARD");
    }

    @Test
    public void testEquality_YardToFeet_equivalentValue() {
        Length len1 = new Length(1.0, LengthEnum.Yards);
        Length len2 = new Length(3.0, LengthEnum.Feet);
        assertEquals(len1, len2, "Expected 1 YARD to be equal to 3 Feet");
        assertEquals(len2, len1, "Expected symmetry: 3 Feet equals 1 YARD");
    }

    @Test
    public void testEquality_CmToCm_sameValue() {
        Length len1 = new Length(50.0, LengthEnum.Centimeters);
        Length len2 = new Length(50.0, LengthEnum.Centimeters);
        assertEquals(len1, len2, "Expected 50 CM to be equal to 50 CM");
    }

    @Test
    public void testEquality_YardToYard_differentValue() {
        Length len1 = new Length(1.0, LengthEnum.Yards);
        Length len2 = new Length(2.0, LengthEnum.Yards);
        assertNotEquals(len1, len2, "Expected 1 YARD to NOT be equal to 2 YARD");
    }

    @Test
    public void testEquality_YardToFeet_notEquivalentValue() {
        Length len1 = new Length(1.0, LengthEnum.Yards);
        Length len2 = new Length(2.0, LengthEnum.Feet);
        assertNotEquals(len1, len2, "Expected 1 YARD to NOT be equal to 2 Feet");
        assertNotEquals(len2, len1, "Expected symmetry: 2 Feet to NOT equal 1 YARD");
    }

    @Test
    public void testEquality_YardToCm_notEquivalentValue() {
        // 1 yard = 91.44 cm, so comparing with 90 cm must be false
        Length len1 = new Length(1.0, LengthEnum.Yards);
        Length len2 = new Length(90.0, LengthEnum.Centimeters);
        assertNotEquals(len1, len2, "Expected 1 YARD to NOT be equal to 90 CM");
        assertNotEquals(len2, len1, "Expected symmetry: 90 CM to NOT equal 1 YARD");
    }

    @Test
    public void testEquality_CmToCm_differentValue() {
        Length len1 = new Length(50.0, LengthEnum.Centimeters);
        Length len2 = new Length(49.0, LengthEnum.Centimeters);
        assertNotEquals(len1, len2, "Expected 50 CM to NOT be equal to 49 CM");
    }

    @Test
    public void testEquality_CmToFeet_notEquivalentValue() {
        // 30.48 cm = 1 foot, so 30 cm must NOT equal 1 foot
        Length len1 = new Length(30.0, LengthEnum.Centimeters);
        Length len2 = new Length(1.0, LengthEnum.Feet);
        assertNotEquals(len1, len2, "Expected 30.0 CM to NOT be equal to 1 Feet");
        assertNotEquals(len2, len1, "Expected symmetry: 1 Feet to NOT equal 30.0 CM");
    }

    @Test
    public void testEquality_CmToYard_notEquivalentValue() {
        // 91.44 cm = 1 yard, so 92 cm must NOT equal 1 yard
        Length len1 = new Length(92.0, LengthEnum.Centimeters);
        Length len2 = new Length(1.0, LengthEnum.Yards);
        assertNotEquals(len1, len2, "Expected 92.0 CM to NOT be equal to 1 YARD");
        assertNotEquals(len2, len1, "Expected symmetry: 1 YARD to NOT equal 92.0 CM");
    }

    @Test
    @DisplayName("Cross-unit precision with centimeters")
    void centimetersPrecision() {
        // Because Centimeters uses ~0.3937, allow a looser delta in equality checks if needed.
        Length cm254 = new Length(2.54, LengthEnum.Centimeters); // ≈ 1 inch
        Length oneIn = new Length(1.0, LengthEnum.Inches);

        assertTrue(cm254.compare(oneIn));
        assertEquals(oneIn, cm254);
    }
    @Test
    @DisplayName("parseUnit returns null for null input")
    void parseNull() {
        assertNull(parseUnit(null));
    }

    @Test
    @DisplayName("convert preserves sign for negative values")
    void convertNegative() {
        double v = convert(-2.0, LengthEnum.Feet, LengthEnum.Inches);
        assertEquals(-24.0, v, 0.0001);
    }
    @Test
    @DisplayName("convert throws on null source or target")
    void convertNulls() {
        assertThrows(IllegalArgumentException.class,
                () -> convert(1.0, null, LengthEnum.Inches));
        assertThrows(IllegalArgumentException.class,
                () -> convert(1.0, LengthEnum.Inches, null));
    }


}
