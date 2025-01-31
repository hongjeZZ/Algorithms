import java.io.*;
import java.util.*;

public class Main {

    static class Member {
        int weight;
        int height;

        public Member(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Member[] members = new Member[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            members[i] = new Member(weight, height);
        }

        for (int i = 0; i < N; i++) {
            int score = 1;
            Member member = members[i];

            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                Member compare = members[j];

                if (compare.weight > member.weight && compare.height > member.height) {
                    score++;
                }
            }
            sb.append(score).append(" ");
        }

        System.out.println(sb);
    }
}