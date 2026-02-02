package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

public class QuantityMeasurmentApp{

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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first value in feet:");
        double n1 = sc.nextDouble();

        System.out.println("Enter second value in feet:");
        double n2 = sc.nextDouble();

        Feet f1 = new Feet(n1);
        Feet f2 = new Feet(n2);

        boolean result = f1.equals(f2);

        System.out.println("Are both values equal? " + result);
    }
}