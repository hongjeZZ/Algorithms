import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Matcher matcher;
        String input = br.readLine();

        Pattern zeroPattern = Pattern.compile("0+");
        Pattern onePattern = Pattern.compile("1+");

        matcher = zeroPattern.matcher(input);
        int zeroCount = 0;
        while (matcher.find()) {
            zeroCount++;
        }

        matcher = onePattern.matcher(input);
        int oneCount = 0;
        while (matcher.find()) {
            oneCount++;
        }

        System.out.print(Math.min(zeroCount, oneCount));
    }
}