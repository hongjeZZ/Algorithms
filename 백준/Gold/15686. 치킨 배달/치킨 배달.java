import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int minValue = Integer.MAX_VALUE;

    static ArrayList<Pos> chickens = new ArrayList<>();
    static ArrayList<Pos> houses = new ArrayList<>();

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 지도 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1) {
                    houses.add(new Pos(i, j));
                } else if (input == 2) {
                    chickens.add(new Pos(i, j));
                }
            }
        }
        combination(new ArrayList<>(), 0, 0);
        System.out.println(minValue);
    }

    public static void combination(List<Pos> selected, int start, int depth) {
        // 조합을 완성했다면, 최소 치킨 거리 저장
        if (depth == M) {
            minValue = Math.min(minValue, getChickenWay(selected));
            return;
        }

        // Back-Tracking 으로 조합을 구현한다.
        for (int i = start; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            combination(selected, i + 1, depth + 1);
            selected.remove(selected.size() - 1);
        }
    }

    // 집을 순회하며 치킨 거리의 최소합을 찾는다.
    public static int getChickenWay(List<Pos> selected) {
        int answer = 0;

        for (Pos house : houses) {
            int min = Integer.MAX_VALUE;

            for (Pos pos : selected) {
                min = Math.min(min, Math.abs(pos.x - house.x) + Math.abs(pos.y - house.y));
            }
            answer += min;
        }
        return answer;
    }
}