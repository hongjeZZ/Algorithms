import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 낮은 숫자가 우선 순위인 Integer 우선순위 큐
        PriorityQueue<Integer> cards = new PriorityQueue<>();

        // 카드 추가
        for (int i = 0; i < N; i++) {
            cards.add(Integer.parseInt(br.readLine()));
        }

        int res = 0;

        // 카드가 하나 남을 때까지 반복
        while (cards.size() > 1) {
            // 가장 작은 카드 뽑기
            int newCard = cards.poll() + cards.poll();
            res += newCard;

            // 새로운 카드를 카드 뭉치에 추가
            cards.add(newCard);
        }

        System.out.println(res);
    }
}