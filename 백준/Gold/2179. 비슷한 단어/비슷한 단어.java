import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            if (!list.contains(line)) {
                list.add(line);
            }
        }

        int max = 0;
        String A = "";
        String B = "";

        for (int i = 0; i < list.size(); i++) {
            String line = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                String compare = list.get(j);
                int length = Math.min(line.length(), compare.length());
                int size = 0;

                for (int k = 0; k < length; k++) {
                    if (line.charAt(k) != compare.charAt(k)) {
                        break;
                    }
                    size++;
                }

                if (size > max) {
                    max = size;
                    A = line;
                    B = compare;
                }
            }
        }

        System.out.println(A);
        System.out.println(B);
    }
}