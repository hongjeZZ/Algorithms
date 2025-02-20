import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String extension = line.split("[.]")[1];
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (String key : list) {
            sb.append(key).append(" ").append(map.get(key)).append("\n");
        }
        System.out.println(sb);
    }
}