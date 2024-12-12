package assignments.ex1;

// ID 325619773

import java.util.Scanner;

public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";

        System.out.println("Ex1 class solution:");

        while (true) {
            System.out.print("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();

            if (num1.equals(quit)) {
                System.out.println("Quitting now...");
                break;
            }

            boolean isNum1Valid = Ex1.isNumber(num1);
            int value1 = Ex1.number2Int(num1);
            System.out.println("num1= " + num1 + " is number: " + isNum1Valid + " , value: " + value1);

            if (!isNum1Valid) {
                System.out.println("ERR: num1 \"" + num1 + "\" is in the wrong format! Please use the correct format, such as 'numberbbase' (e.g., '101b2').");
                continue;
            }

            System.out.print("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.next();

            if (num2.equals(quit)) {
                System.out.println("Quitting now...");
                break;
            }

            boolean isNum2Valid = Ex1.isNumber(num2);
            int value2 = Ex1.number2Int(num2);
            System.out.println("num2= " + num2 + " is number: " + isNum2Valid + " , value: " + value2);

            if (!isNum2Valid) {
                System.out.println("ERR: num2 \"" + num2 + "\" is in the wrong format! Please use the correct format, such as 'numberbbase' (e.g., '101b2').");
                continue;
            }

            System.out.print("Enter a base for output (a number [2,16]): ");
            int base = sc.nextInt();

            if (base < 2 || base > 16) {
                System.out.println("ERR: Base out of range (must be between 2 and 16).");
                continue;
            }

            int sum = value1 + value2;
            int product = value1 * value2;

            String sumBase = Ex1.int2Number(sum, base);
            String productBase = Ex1.int2Number(product, base);


            if(base < 10){
                System.out.println(num1 + " + " + num2 + " = " + sumBase+ "b" + base);
                System.out.println(num1 + " * " + num2 + " = " + productBase+ "b" + base);
            }
            if(base>10){
                if(base == 16){
                    System.out.println(num1 + " + " + num2 + " = " + sumBase+"bG");
                    System.out.println(num1 + " * " + num2 + " = " + productBase+"bG");
                }

                else if (base > 10 && base < 16) {
                    System.out.println(num1 + " + " + num2 + " = " + sumBase+ "b" + Integer.toHexString(base).toUpperCase());
                    System.out.println(num1 + " * " + num2 + " = " + productBase+ "b" + Integer.toHexString(base).toUpperCase());
                }
            }

            if(base == 10){
                System.out.println(num1 + " + " + num2 + " = " + sumBase);
                System.out.println(num1 + " * " + num2 + " = " + productBase);
            }
            String[] numbers = {num1, num2, sumBase, productBase};
            int maxIndex = Ex1.maxIndex(numbers);
            if(base < 10){
                System.out.println("Max number over " + java.util.Arrays.toString(numbers) + " is: " + numbers[maxIndex] + "b" + base );
            }
            if(base>10){
                if(base == 16){
                    System.out.println("Max number over " + java.util.Arrays.toString(numbers) + " is: " + numbers[maxIndex] + "bG");

                }

                else if (base > 10 && base < 16) {
                    System.out.println("Max number over " + java.util.Arrays.toString(numbers) + " is: " + numbers[maxIndex]+ "b" + Integer.toHexString(base).toUpperCase());

                }
            }

        if(base == 10){
            System.out.println("Max number over " + java.util.Arrays.toString(numbers) + " is: " + numbers[maxIndex]);
        }
        }

        sc.close();
    }
}
