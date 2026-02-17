package org.example;

import java.util.Locale;

public enum WeightEnum {
    Kilogram(1.0, "kg"),                 // base
    Gram(1.0 / 1000.0, "gm"),             // 1 g  = 0.001 kg
    Pound(0.45359237, "lb");             // 1 lb = 0.45359237 kg

    private final double toKgFactor;     // multiply to get kilograms
    private final String label;

    WeightEnum(double toKgFactor, String label) {
        this.toKgFactor = toKgFactor;
        this.label = label;
    }

    /** Convert a numeric value in THIS unit to kilograms (base). */
    public double toBase(double value) {
        return value * toKgFactor;
    }

    /** Convert a numeric value in kilograms (base) to THIS unit. */
    public double fromBase(double kilograms) {
        return kilograms / toKgFactor;
    }

    public String label() {
        return label;
    }

    public static WeightEnum parseUnit(String input) {
        if (input == null) return null;
        String s = input.trim().toLowerCase(Locale.ROOT);

        switch (s) {
            case "kilogram":
            case "kg":
                return Kilogram;

            case "gram":
            case "gm":
                return Gram;

            case "pound":
            case "lb":
                return Pound;

            default:
                return null;
        }
    }

    // converting from source to target unit

    public static double convert(double value, WeightEnum source, WeightEnum target) {
        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }
        double kg = source.toBase(value);
        return target.fromBase(kg);
    }
}