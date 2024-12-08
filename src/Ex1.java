import java.util.Arrays;

/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {

    public static int convertBaseStringToNum(String b){
        int ans = 0;
        if(b.equals("A")){
            ans = 10;
        }else if(b.equals("B")){
            ans = 11;
        }else if (b.equals("C")){
            ans = 12;
        }else if (b.equals("D")){
            ans = 13;
        }else if (b.equals("E")){
            ans = 14;
        }else if (b.equals("F")){
            ans = 15;
        }else if (b.equals("G")){
            ans = 16;
        }else{
            ans = Integer.parseInt(b);
        }
        return ans;
    }

    public static boolean checkIfValidBase(int base){
        int[] basisim = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        boolean ans = false;
        for(int i = 0;  i < basisim.length; i++){
            if(base == basisim[i]){
                ans = true;
            }
        }
        return ans;
    }

    /**
     * Convert the given number (num) to a decimal representation (as int).
     * If the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        int ans = -1;
        if(isNumber(num)) {
            String[] arr = num.split("b");

            String valueNum = arr[0];
            StringBuilder res = new StringBuilder();
            res.append(valueNum);
            res.reverse();

            int base = convertBaseStringToNum(arr[1]);
            int sum = 0;

            for(int i = 0; i < res.length(); i++){
                int numPow = Integer.parseInt(String.valueOf(res.charAt(i)));
                sum = (int) (sum + (numPow*(Math.pow(base, i))));
            }
            ans = sum;
        }
        return ans;
    }

    public static boolean isValidNum (String num, int base){
        boolean ans = false;
        int count = 0;
        String numbers = "0123456789ABCDEF";
        for(int i = 0; i < num.length(); i++){
            for(int j = 0; j < numbers.length(); j++) {
                if (Integer.parseInt(String.valueOf(num.charAt(i))) < base) {
                    if (num.charAt(i) == numbers.charAt(j)) {
                        count++;
                    }
                }
            }
        }
        if(count == num.length()){
            ans = true;
        }
        return ans;
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;

        if(a.length() <= 0) {
            ans = false;
        }else {
            String[] arr = a.split("b");
            int base = convertBaseStringToNum(arr[1]);
            boolean baseIsValid = checkIfValidBase(base);

            boolean numIsValid = isValidNum(arr[0], base);

            if (!numIsValid || !baseIsValid) {
                ans = false;
            }
        }
        return ans;
    }




    //
    public static char reVal(int num)
    {
        if (num >= 0 && num <= 9)
            return(char)(num + '0');
        else
            return(char)(num - 10 + 'A');
    }

    //funtion that reverses a string
    static String reverse(String input)
    {
        char[] a = input.toCharArray();
        int l, r = a.length - 1;
        for(l = 0; l < r; l++, r--)
        {
            char temp = a[l];
            a[l] = a[r];
            a[r] = temp;
        }
        return String.valueOf(a);
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";
        int testNum = num;
        String newNum = "";
        String numbers = "0123456789ABCDEF";

//        boolean isCorrectBase = checkIfValidBase(base);
//        if(num > 0 && isCorrectBase ) {
//
//                String res = "";
//
//                // Repeatedly divide testNum
//                // by base and take remainder
//                while (testNum > 0)
//                {
//                    // Update res
//                    res += reVal(testNum % base);
//                    // Update inputNum
//                    testNum /= base;
//                }
//                // Reverse the result
//                res = reverse(res);
//                ans = res + "b" + base;
//        }
        return ans;
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true if the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        int valueN1 =number2Int(n1);
        int valueN2 =number2Int(n2);
        if(valueN1 != valueN2){
            ans = false;
        }
        return ans;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        int[] valueArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            valueArr[i] = number2Int(arr[i]);
        }
        for(int i = 0; i < valueArr.length; i++){
            if(ans < valueArr[i]){
                ans = valueArr[i];
            }
        }
        return ans;
    }
}