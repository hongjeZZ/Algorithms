import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] strings = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        int answer = 0;

        for (String str : strings) {
            while (input.contains(str)) {
                input = input.replaceFirst(str, " ");
                answer++;
            }
        }
        
        input = input.replaceAll(" ", "");
        System.out.println(answer + input.length());
    }
}