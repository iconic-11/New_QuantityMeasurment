
package org.example;

import java.util.Objects;

/**
 * Immutable value object representing a weight.
 * Internally compared via base unit (kilograms) with a small tolerance for doubles.
 */
public final class Weight {
    private final double value;
    private final WeightEnum unit;

    public Weight(double value, WeightEnum unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        this.value = value;
        this.unit = unit;
    }

    /** Convert this instance to base unit (kilograms). */
    private double toBaseUnit() {
        return unit.toBase(value);
    }

    /** Tolerant physical equality in terms of kilograms. */
    public boolean compare(Weight other) {
        if (other == null) return false;
        final double EPS = 1e-9; // ~nanogram precision in kg scale
        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) <= EPS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weight)) return false;
        Weight other = (Weight) o;
        return this.compare(other);
    }


    /** Convert this weight to a target unit. */
    public double to(WeightEnum target) {
        return target.fromBase(this.toBaseUnit());
    }

   // for equality checking
    public static boolean areEqual(double v1, WeightEnum u1, double v2, WeightEnum u2) {
        return new Weight(v1, u1).equals(new Weight(v2, u2));
    }
}