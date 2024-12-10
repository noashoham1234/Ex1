import java.util.Arrays;

/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,...G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”, “012b5” , “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {

    /**
     * a function that gets a String that isn't empty or null
     * converts the string into a number in int of its hexa value.
     */
    public static int convertBaseStringToNum(String b) {
        int ans;
        try {
            ans = switch (b) {
                case "A" -> 10;
                case "B" -> 11;
                case "C" -> 12;
                case "D" -> 13;
                case "E" -> 14;
                case "F" -> 15;
                case "G" -> 16;
                default -> Integer.parseInt(b);
            };
        } catch (Exception e) {
            ans = -1;
        }

        return ans;
    }

    /**
     * a function that gets an int that isn't null and bigger than 2
     * converts the string into a letter/number in String of its hexa value.
     */
    public static String convertBaseIntToString(int b) {
        String ans = switch (b) {
            case 10 -> "A";
            case 11 -> "B";
            case 12 -> "C";
            case 13 -> "D";
            case 14 -> "E";
            case 15 -> "F";
            case 16 -> "G";
            default -> String.valueOf(b);
        };
        return ans;
    }

    /**
     * function that gets a number in int
     * checks if it equals to one of the valid bases = [2, 16]
     */
    public static boolean checkIfValidBase(int base) {
        int[] basisim = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        boolean ans = false;

        if (base > 0) {
            for (int i = 0; i < basisim.length; i++) {
                if (base == basisim[i]) {
                    ans = true;
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * Convert the given number (num) to a decimal representation (as int).
     * If the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return number in int form
     */
    public static int number2Int(String num) {
        int ans = -1;
        if (isNumber(num)) {
            if (!num.contains("b")) {
                num += "bA";
            }
            String[] arr = num.split("b");

            String valueNum = arr[0];
            StringBuilder res = new StringBuilder();
            res.append(valueNum);
            res.reverse();

            int base = convertBaseStringToNum(arr[1]);
            int sum = 0;

            for (int i = 0; i < res.length(); i++) {

                int numPow = convertBaseStringToNum(String.valueOf(res.charAt(i)));
                sum = (int) (sum + (numPow * (Math.pow(base, i))));
            }
            ans = sum;
        }
        return ans;
    }

    /**
     * function that gets a number in String and a base in int
     * goes over the number and checks if every char equals one of the chars that are valid
     * in addition it checks if every integer is smaller than base
     */
    public static boolean isValidNum(String num, int base) {
        boolean ans = false;
        int count = 0;
        String numbers = "0123456789ABCDEF";
        for (int i = 0; i < num.length(); i++) {
            int digit = convertBaseStringToNum(String.valueOf(num.charAt(i)));
            if (digit != -1 && digit < base) {
                if (numbers.contains(num.charAt(i) + "")) {
                    count++;
                }
            }
        }
        if (count == num.length() && !num.isEmpty()) {
            ans = true;
        }
        return ans;
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;

        if (a.isEmpty() || a.equals("b")) {
            ans = false;
        } else {

            if (!a.contains("b")) {
                a += "bA";
            }

            String[] arr = a.split("b");
            if (arr.length != 2) {
                ans = false;
            } else {
                int base = convertBaseStringToNum(arr[1]);
                boolean baseIsValid = checkIfValidBase(base);

                boolean numIsValid = isValidNum(arr[0], base);

                if (!numIsValid || !baseIsValid) {
                    ans = false;
                }
            }
        }
        return ans;
    }


    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     *
     * @param num  the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans;
        StringBuilder newNum = new StringBuilder();
        int testNum = num;
        int count = 0;
        if (num < 0 || !checkIfValidBase(base)) {
            ans = "";
        } else {
            if(testNum != 0) {
                for (int i = 0; i < testNum; i++) {
                    if ((int) (Math.pow(base, i)) <= testNum) {
                        count++;
                    }
                }
                for (int i = 0; i < count; i++) {
                    double pow = Math.pow(base, count - (i + 1));
                    int numTimesCount = (int) (testNum / pow);
                    testNum -= (int) (numTimesCount * pow);
                    newNum.append(convertBaseIntToString(numTimesCount));
                }
            }else{
                newNum.append(0);
            }
            if (base != 10) {
                String newBase = convertBaseIntToString(base);
                newNum.append('b').append(newBase);
            }
            ans = newNum.toString();
        }
        return ans;
    }

    /**
     * Checks if the two numbers have the same value.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true if the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        int valueN1 = number2Int(n1);
        int valueN2 = number2Int(n2);
        if (valueN1 != valueN2 || valueN1 == -1) {
            ans = false;
        }
        return ans;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     *
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     */
    public static int maxIndex(String[] arr) {
        int ans = -1;
        int max = 0;
        if (arr != null) {
            int[] valueArr = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                valueArr[i] = number2Int(arr[i]);
            }
            for (int i = 0; i < valueArr.length; i++) {
                if (max < valueArr[i]) {
                    max = valueArr[i];
                    ans = i;
                }
            }
        }
        return ans;
    }
}