import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            if (!map.containsKey(number)) {
                map.put(number, value);
            } else {
                int preValue = map.get(number);

                if (preValue != value) {
                    map.replace(number, value);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}