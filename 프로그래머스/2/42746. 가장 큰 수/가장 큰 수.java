import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (o1, o2) -> {
            int a1 = Integer.parseInt(o1 + o2);
            int a2 = Integer.parseInt(o2 + o1);

            return Integer.compare(a2, a1);
        });

        StringBuilder sb = new StringBuilder();

        for (String s : arr) {
            sb.append(s);
        }

        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}