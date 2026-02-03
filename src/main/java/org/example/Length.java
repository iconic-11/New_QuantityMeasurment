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
    private double toBaseUnit() {
        return value * unit.getConversionFactor();
    }
    @Override
    public boolean equals(Object obj)
    {
        if(this==obj) return true;
        if(obj==null) return false;

        Length other =(Length) obj;
        return compare(other);
    }
    
}
