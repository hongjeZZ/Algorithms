import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int res = 0;

        String input = br.readLine();
        String[] split = input.split("-");

        for (int i = 0; i < split.length; i++) {
            int sum = 0;

            String[] nums = split[i].split("\\+");

            for (String num : nums) {
                sum += Integer.parseInt(num);
            }

            if (i == 0) {
                res += sum;
            } else {
                res -= sum;
            }
        }

        System.out.println(res);
    }
}