package org.example;

import java.util.Locale;
import java.util.Scanner;

public class QuantityMeasurmentApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        System.out.println("--- Weight Converter ---");

        System.out.print("Enter weight value1: ");
        double value1 = sc.nextDouble();
        System.out.print("Enter unit of first weight (kg/gm/pound): ");
        String sourceStr1 = sc.next();
        WeightEnum u1 = WeightEnum.parseUnit(sourceStr1);
        if(u1==null){
            System.err.println("Invalid first unit");
            return;
        }

        System.out.print("Enter weight value2: ");
        double value2 = sc.nextDouble();
        System.out.print("Enter unit for second weight (kg/gm/pound): ");
        String sourceStr2 = sc.next();
        WeightEnum u2 = WeightEnum.parseUnit(sourceStr2);

        if(u2==null){
            System.err.println("Invalid Second unit");
            return;
        }
        /*
        ---for equality----
        else{
            boolean equal=Weight.areEqual(value1,u1,value2,u2);
            System.out.println("Are the two weights equal ? " +equal);
        } */
        System.out.print("Enter target unit to print sum: ");
        String targetStr = sc.next();
        WeightEnum targetUnit = WeightEnum.parseUnit(targetStr);
        if (targetUnit == null) {
            System.err.println("Invalid target unit: " + targetStr);
            return;
        }
        double kg1=u1.toBase(value1);
        double kg2 =u2.toBase(value2);

        double ans = kg1+kg2;
        double targetSum = WeightEnum.convert(ans,WeightEnum.Kilogram, targetUnit);
        System.out.printf("%f %s%n", targetSum, targetUnit.label());


        /*
        System.out.println("--- Length Converter ---");

        System.out.print("Enter numeric value1: ");
        double value1 = sc.nextDouble();

        System.out.print("Enter first source unit: ");
        String sourceStr1 = sc.next(); // use next() not nextLine()

        LengthEnum u1 = LengthEnum.parseUnit(sourceStr1);
        if (u1 == null) {
            System.err.println("Invalid first unit: " + sourceStr1);
        }
        System.out.print("Enter numeric value2: ");
        double value2 = sc.nextDouble();

        System.out.print("Enter second source unit: ");
        String sourceStr2 = sc.next();
        LengthEnum u2 = LengthEnum.parseUnit(sourceStr2);
        if (u2 == null) {
            System.err.println("Invalid second unit: " + sourceStr2);
            return;
        }

        System.out.print("Enter target unit to print sum: ");
        String targetStr = sc.next();

    //    LengthEnum sourceUnit = LengthEnum.parseUnit(sourceStr);
        LengthEnum targetUnit = LengthEnum.parseUnit(targetStr);


        double feet1 = u1.toBase(value1);
        double feet2 = u2.toBase(value2);
        double totalFeet = feet1 + feet2;


        double targetSum = LengthEnum.convert(totalFeet, LengthEnum.Feet, targetUnit);
        System.out.printf("%f %s%n", targetSum, targetUnit.label());
        */
    }
}