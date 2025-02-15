import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0];

        for (int i = 1; i < arr.length; i++) {
            lcm = getLCM(lcm, arr[i]);
        }

        return lcm;
    }

    private int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int getLCM(int a, int b) {
        return (a * b) / getGCD(a, b);
    }
}