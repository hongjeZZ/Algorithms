import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new TreeSet<>((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return Integer.compare(o1.length(), o2.length());
            } else {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (String val : set) {
            sb.append(val).append("\n");
        }
        System.out.println(sb);
    }
}