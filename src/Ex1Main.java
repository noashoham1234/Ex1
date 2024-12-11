import java.util.Arrays;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 */
public class Ex1Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            boolean isNum1 = Ex1.isNumber(num1);
            int valueNum1 = Ex1.number2Int(num1);
            if (isNum1) {
                if (!num1.equals("quit")) {
                    System.out.println("num1 = " + num1 + " is number:" + isNum1 + "," + valueNum1);
                } else {
                    break;
                }
            } else {
                System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");
                continue;
            }

            System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.next();
            boolean isNum2 = Ex1.isNumber(num2);
            int valueNum2 = Ex1.number2Int(num2);
            if (isNum2) {
                if (!num2.equals("quit")) {
                    System.out.println("num2 = " + num2 + " is number:" + isNum2 + "," + valueNum2);
                } else {
                    break;
                }
            } else {
                System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");
                continue;
            }
            System.out.println("Enter a base for output: (a number [2,16])");
            int base = Integer.parseInt(sc.next());
            String valueSumPluse = Ex1.int2Number(Ex1.number2Int(num1) + Ex1.number2Int(num2), base);
            String valueSumMult = Ex1.int2Number(Ex1.number2Int(num1) * Ex1.number2Int(num2), base);
            String[] arr = {num1, num2, valueSumPluse, valueSumMult};
            int maxIndex = Ex1.maxIndex(arr);
            String maxNum = arr[maxIndex];
            if (!Ex1.checkIfValidBase(base)) {
                System.out.println("ERR: wrong base, should be [2,16], got (" + base + ")");
                continue;

            } else {
                System.out.println(num1 + " + " + num2 + " = " + valueSumPluse);
                System.out.println(num1 + " * " + num2 + " = " + valueSumMult);
                System.out.println("Max number over " + Arrays.toString(arr) + "is: " + maxNum);
            }
        }
        System.out.println("quiting now...");
    }
}