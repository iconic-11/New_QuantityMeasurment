package org.example;

import java.util.Locale;

public enum LengthEnum {

    Feet(1.0, "ft"),
    Inches(1.0 / 12.0, "in"),
    Yards(3.0, "yd"),            // 1 yard = 3 ft
    Centimeters(1.0 / 30.48, "cm"); // 1 cm = 1/30.48 ft

    private final double toFeetFactor;
    private final String label;

    LengthEnum(double toFeetFactor, String label) {
        this.toFeetFactor = toFeetFactor;
        this.label = label;
    }

    /** Convert numeric value in THIS unit to base (feet). */
    public double toBase(double value) {
        return value * toFeetFactor;
    }

    /** Convert numeric value in feet (base) to THIS unit. */
    public double fromBase(double feetValue) {
        return feetValue / toFeetFactor;
    }

    /** Short label for printing. */
    public String label() {
        return label;
    }


    public static LengthEnum parseUnit(String input) {
        if (input == null) return null;

        String s = input.trim().toLowerCase(Locale.ROOT);

        switch (s) {
            case "feet":
            case "foot":
            case "ft":
                return Feet;

            case "inch":
            case "inches":
            case "in":
                return Inches;

            case "yard":
            case "yards":
            case "yd":
                return Yards;

            case "centimeter":
            case "centimeters":
            case "cm":
                return Centimeters;

            default:
                return null;
        }
    }

    // ------------------ Static conversion API ------------------
    public static double convert(double value, LengthEnum source, LengthEnum target) {
        if (source == null || target == null)
            throw new IllegalArgumentException("Units cannot be null");

        double feet = source.toBase(value);  // source → feet
        return target.fromBase(feet);        // feet → target
    }
}