import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> cards = new HashMap<>();
        int max = 0;
        long answer = 0;


        for (int i = 0; i < N; i++) {
            long card = Long.parseLong(br.readLine());
            Integer count = cards.getOrDefault(card, 0);
            cards.put(card, count + 1);

            if (max < count + 1) {
                max = count + 1;
                answer = card;
            } else if (max == count + 1) {
                answer = Math.min(answer, card);
            }
        }
        System.out.println(answer);
    }
}