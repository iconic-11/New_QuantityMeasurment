package org.example;

public class Length {
    private final double value;
    private final LengthUnit unit;


    public boolean compare(Length other) {
        if (other == null) return false;
        double epsilon = 0.0001; // tolerance
        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < epsilon;
    }


    public enum LengthUnit
    {
        Feet(12.0), // 1 feet= 12 inchs
        Inches(1.0),
        Yards(36.0),  // 1 yard = 3 inches = 36 feet
        Centimeters(0.3937);


        private final double conversionFactor;
        LengthUnit(double conversionFactor)
        {
            this.conversionFactor=conversionFactor;
        }

        public double toInches(double value) {
            return value * conversionFactor;
        }
        public double fromInches(double inches) {
            return inches / conversionFactor;
        }



        public double getConversionFactor()
        {
            return conversionFactor;
        }
    }

    public Length(double value,LengthUnit unit)
    {
        if(unit==null){
            throw new IllegalArgumentException("please enter valid unit");
        }
        this.value=value;
        this.unit=unit;
    }

    // Convert to base unit (inches)
    public double toBaseUnit() {
        return unit.toInches(value);
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean result=false;
        if(this==obj) return true;
        if(obj==null) return false;

        Length other =(Length) obj;
        return compare(other);
    }
    // conversion logic
    public static double convert(double value,LengthUnit sourceUnit,LengthUnit targetUnit)
    {
        if(sourceUnit==null || targetUnit==null){
            throw new IllegalArgumentException("source & target unit must not be null");
        }
        double inches = sourceUnit.toInches(value);
        return targetUnit.fromInches(inches);
    }
    //parsew logic
    public static LengthUnit parseUnit(String input) {
        if (input == null) return null;
        String s = input.trim().toLowerCase();
        switch (s) {
            case "feet":
            case "ft":
                return LengthUnit.Feet;

            case "inch":
            case "in":
                return LengthUnit.Inches;

            case "yard":
            case "yd":
                return LengthUnit.Yards;

            case "centimeter":
            case "cm":
                return LengthUnit.Centimeters;

            default:
                return null;
        }
    }

    /** Short label for printing results. */
    public static String unitLabel(LengthUnit u) {
        switch (u) {
            case Feet: return "ft";
            case Inches: return "in";
            case Yards: return "yd";
            case Centimeters: return "cm";
            default: return u.name();
        }
    }


}
