import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = 1;

        while (true) {
            String[] inputs = br.readLine().split(" ");
            int L = Integer.parseInt(inputs[0]);
            int P = Integer.parseInt(inputs[1]);
            int V = Integer.parseInt(inputs[2]);

            if (L == 0 && P == 0 && V == 0) {
                break;
            }

            System.out.println("Case " + caseNum++ + ": " + (V / P * L + Math.min(V % P, L)));
        }
    }
}