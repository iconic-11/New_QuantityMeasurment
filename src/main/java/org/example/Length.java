//package org.example;
//
//public class Length {
//    private final double value;
//    private final LengthEnum unit;
//
//
//    public boolean compare(Length other) {
//        if (other == null) return false;
//        double epsilon = 0.0001; // tolerance
//        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < epsilon;
//    }
//
//
//    public enum LengthEnum
//    {
//        Feet(12.0), // 1 feet= 12 inchs
//        Inches(1.0),
//        Yards(36.0),  // 1 yard = 3 inches = 36 feet
//        Centimeters(0.3937);
//
//
//        private final double conversionFactor;
//        LengthEnum(double conversionFactor)
//        {
//            this.conversionFactor=conversionFactor;
//        }
//
//        public double toInches(double value) {
//            return value * conversionFactor;
//        }
//        public double fromInches(double inches) {
//            return inches / conversionFactor;
//        }
//
//
//
//        public double getConversionFactor()
//        {
//            return conversionFactor;
//        }
//    }
//
//    public Length(double value,LengthEnum unit)
//    {
//        if(unit==null){
//            throw new IllegalArgumentException("please enter valid unit");
//        }
//        this.value=value;
//        this.unit=unit;
//    }
//
//    // Convert to base unit (inches)
//    public double toBaseUnit() {
//        return unit.toInches(value);
//    }
//
//    @Override
//    public boolean equals(Object obj)
//    {
//        boolean result=false;
//        if(this==obj) return true;
//        if(obj==null) return false;
//
//        Length other =(Length) obj;
//        return compare(other);
//    }
//    // conversion logic
//    public static double convert(double value,LengthEnum sourceUnit,LengthEnum targetUnit)
//    {
//        if(sourceUnit==null || targetUnit==null){
//            throw new IllegalArgumentException("source & target unit must not be null");
//        }
//        double inches = sourceUnit.toInches(value);
//        return targetUnit.fromInches(inches);
//    }
//    //parsew logic
//    public static LengthEnum parseUnit(String input) {
//        if (input == null) return null;
//        String s = input.trim().toLowerCase();
//        switch (s) {
//            case "feet":
//            case "ft":
//                return LengthEnum.Feet;
//
//            case "inch":
//            case "in":
//                return LengthEnum.Inches;
//
//            case "yard":
//            case "yd":
//                return LengthEnum.Yards;
//
//            case "centimeter":
//            case "cm":
//                return LengthEnum.Centimeters;
//
//            default:
//                return null;
//        }
//    }
//
//    /** Short label for printing results. */
//    public static String unitLabel(LengthEnum u) {
//        switch (u) {
//            case Feet: return "ft";
//            case Inches: return "in";
//            case Yards: return "yd";
//            case Centimeters: return "cm";
//            default: return u.name();
//        }
//    }
//}


package org.example;

import java.util.Objects;

public class Length {

    private final double value;
    private final LengthEnum unit;

    public Length(double value, LengthEnum unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");
        this.value = value;
        this.unit = unit;
    }

    // Delegate to unit (base = feet)
    private double toBaseUnit() {
        return unit.toBase(value);
    }

    public boolean compare(Length other) {
        if (other == null) return false;
        double epsilon = 1e-4;
        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < epsilon;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Length)) return false;
        Length other = (Length) obj;
        return compare(other);
    }

    @Override
    public int hashCode() {
        long roundedFeet = Math.round(this.toBaseUnit() * 1000);
        return Objects.hash(roundedFeet);
    }

    // Convert this length to another unit
    public double to(LengthEnum target) {
        return target.fromBase(this.toBaseUnit());
    }

    // Static helper (optional)
    public static double convert(double value, LengthEnum source, LengthEnum target) {
        return LengthEnum.convert(value, source, target);
    }

    // Factory helpers
    public static Length feet(double v) { return new Length(v, LengthEnum.Feet); }
    public static Length inches(double v) { return new Length(v, LengthEnum.Inches); }
    public static Length yards(double v) { return new Length(v, LengthEnum.Yards); }
    public static Length centimeters(double v) { return new Length(v, LengthEnum.Centimeters); }
}