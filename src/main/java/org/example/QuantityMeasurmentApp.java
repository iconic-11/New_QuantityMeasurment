package org.example;

import java.util.Scanner;
import java.lang.Double;


class UnitMismatchException extends Exception {
    public UnitMismatchException(String message) {
        super(message);
    }
}

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

    static class Yards{
        private final double value;

        public Yards(double value)
        {
            this.value=value;
        }
        @Override
        public boolean equals(Object obj)
        {
            if(this==obj) return true;
            if(obj==null) return false;

            Inches other = (Inches)obj;

            return Double.compare(this.value,other.value)==0;

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
    static void CheckYardsEquality(double v1, double v2) {
        Yards y1 = new Yards(v1);
        Yards y2 = new Yards(v2);

        if (y1.equals(y2)) {
            System.out.println("Yards values are equal");
        } else {
            System.out.println("Yards values are not equal");
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

        Length l3 = new Length(5, Length.LengthUnit.Yards);
        Length l4 = new Length(6, Length.LengthUnit.Centimeters);
        System.out.println(l1.compare(l2)); // true

        System.out.println("---Length convertor");
        Scanner sc = new Scanner(System.in);
        double valueStr1 = 0.0,valueStr2=0.0;
        String sourceStr1 = "",sourceStr2="";
        try {
            System.out.print("Enter numeric value1: ");
            /*double*/ valueStr1 = sc.nextDouble();
            sc.nextLine();


            System.out.print("Enter source unit of first value(feet/ft, inches/in, yards/yd, centimeter/cm): ");
            /*String*/ sourceStr1 = sc.next();
            //  Length.LengthUnit sourceUnit = Length.parseUnit(sourceStr);

            System.out.print("Enter numeric value2: ");
            valueStr2 = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter source unit of second value (feet/ft, inches/in, yards/yd, centimeter/cm): ");
            /*String*/ sourceStr2 = sc.next();

            if (!sourceStr1.equalsIgnoreCase(sourceStr2)) {
                throw new UnitMismatchException("Both unit must be same in UC6");
            }
        }
        catch(UnitMismatchException ume){
            System.out.println("Error: " + ume.getMessage());

        }

    //    System.out.print("Enter target unit (feet/ft, inches/in, yards/yd, centimeter/cm): ");
    //    String targetStr = sc.next();

        Length.LengthUnit sourceUnit1 = Length.parseUnit(sourceStr1);
        Length.LengthUnit sourceUnit2 = Length.parseUnit(sourceStr2);
        double ans = valueStr1 + valueStr2;
        System.out.println(ans +" "+sourceStr2);

        //    Length.LengthUnit targetUnit = Length.parseUnit(targetStr);

        if(sourceUnit1 == null || sourceUnit2==null) {
            System.err.println("Invalid source unit: ");
            return;
        }
//        if (targetUnit == null) {
//            System.err.println("Invalid target unit: " + targetStr);
//            return;
//        }
//        double converted = Length.convert(ans, sourceUnit1, targetUnit);
//        System.out.println(converted +" "+targetStr);




    }
}