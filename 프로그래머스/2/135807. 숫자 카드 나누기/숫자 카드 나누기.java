import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = getGCD(arrayA);
        int gcdB = getGCD(arrayB);

        int resultA = isValid(gcdA, arrayB) ? gcdA : 0;
        int resultB = isValid(gcdB, arrayA) ? gcdB : 0;

        return Math.max(resultA, resultB);
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    private int getGCD(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }

    private boolean isValid(int gcdValue, int[] otherArray) {
        for (int num : otherArray) {
            if (num % gcdValue == 0) {
                return false;
            }
        }
        return true;
    }
}