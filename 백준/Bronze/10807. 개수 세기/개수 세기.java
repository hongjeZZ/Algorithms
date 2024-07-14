import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int v = Integer.parseInt(br.readLine());
        int count = 0;
        br.close();

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < size; i++) {
            if (v == arr[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}