package org.example;

import java.util.Scanner;

public class QuantityMeasurmentApp {

    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            Feet other = (Feet) obj;

            return Double.compare(this.value, other.value) == 0;
        }
    }


    static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            Inches other = (Inches) obj;

            return Double.compare(this.value, other.value) == 0;
        }
    }

    static void CheckFeetEquality(double v1, double v2) {
        Feet f1 = new Feet(v1);
        Feet f2 = new Feet(v2);

        if (f1.equals(f2)) {
            System.out.println("Feet values are equal");
        } else {
            System.out.println("Feet values are not equal");
        }
    }

    static void CheckInchesEquality(double v1, double v2) {
        Inches i1 = new Inches(v1);
        Inches i2 = new Inches(v2);

        if (i1.equals(i2)) {
            System.out.println("Inches values are equal");
        } else {
            System.out.println("Inches values are not equal");
        }

    }


    public static void main(String[] args) {
/*
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first value in feet:");
        double ft1 = sc.nextDouble();

        System.out.println("Enter second value in feet:");
        double ft2 = sc.nextDouble();


        CheckFeetEquality(ft1, ft2);


        System.out.println("Enter first value in Inches:");
        double in1 = sc.nextDouble();

        System.out.println("Enter second value in Inches:");
        double in2 = sc.nextDouble();


        CheckInchesEquality(in1, in2);
    } */

        Length l1 = new Length(3.0, Length.LengthUnit.Feet);
        Length l2 = new Length(36.0, Length.LengthUnit.Inches);
        System.out.println(l1.compare(l2)); // true

    }
}