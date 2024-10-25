import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int minusIdx = input.indexOf('-');

        int sum = 0;
        
        // 마이너스 부호가 없다면 모든 수를 더함
        if (minusIdx == -1) {
            String[] numbers = input.split("\\+");
            for (String numStr : numbers) {
                sum += Integer.parseInt(numStr);
            }
            System.out.println(sum);
            return;
        }

        // 마이너스 부호가 있다면 부호 앞 문자를 모두 더하고, 부호 뒤 문자를 모두 뺌
        String[] plusNumbers = input.substring(0, minusIdx).split("\\+");
        for (String plusNumber : plusNumbers) {
            sum += Integer.parseInt(plusNumber);
        }

        String[] minusNumbers = input.substring(minusIdx).replaceAll("[^0-9]", " ").trim().split("\\s+");
        for (String minusNumber : minusNumbers) {
            sum -= Integer.parseInt(minusNumber);
        }
        
        System.out.println(sum);
    }
}