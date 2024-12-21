import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String DEFAULT_MESSAGE = "I'm Sorry Hansoo";

        String input = br.readLine();
        char[] charArray = input.toCharArray();

        // 사전순으로 정렬
        Arrays.sort(charArray);
        List<Character> list = new ArrayList<>();

        if (charArray.length % 2 == 0) {
            // 이름이 짝수일 때

            for (Character c : charArray) {
                // 리스트가 비어있거나, 원소가 포함되지 않았다면 add
                if (list.isEmpty() || !list.contains(c)) {
                    list.add(c);
                } else {
                    // 아니라면 이전 원소 remove
                    list.remove(c);
                }
            }
            // 스택이 비어있지 않다면(팰린드롬을 만들지 못한다면), 디폴트 메시지 출력
            if (!list.isEmpty()) {
                System.out.println(DEFAULT_MESSAGE);
            } else {
                // 반쪽짜리 문자열 생성
                for (int i = 0; i < charArray.length; i = i + 2) {
                    sb.append(charArray[i]);
                }
                System.out.println(sb.toString() + sb.reverse());
            }
        } else {
            // 이름이 홀수일 때
            for (Character c : charArray) {
                // 리스트가 비어있거나, 원소가 포함되어 있지 않다면 push
                if (list.isEmpty() || !list.contains(c)) {
                    list.add(c);
                } else {
                    // 아니라면 해당 원소를 remove
                    list.remove(c);
                }
            }

            // 리스트의 크기가 1이 아니라면(팰린드롬을 만들지 못한다면), 디폴트 메시지 출력
            if (list.size() != 1) {
                System.out.println(DEFAULT_MESSAGE);
            } else {
                // 하나 남은 문자(고아문자)를 삭제
                List<Character> charList = new String(charArray)
                        .chars()
                        .mapToObj(c -> (char) c).collect(Collectors.toList());
                charList.remove(list.get(0));

                for (int i = 0; i < charList.size(); i = i + 2) {
                    sb.append(charList.get(i));
                }
                System.out.println(sb.toString() + list.get(0) + sb.reverse());
            }
        }
    }
}