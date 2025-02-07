import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int index = 0;

            while (N > 0) {
                if ((N & 1) == 1) {
                    sb.append(index).append(" ");
                }
                N >>= 1;
                index++;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
