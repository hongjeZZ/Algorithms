import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Block> houseList;
    static List<Block> chickenList;
    static int N, M;
    static int minDistance = Integer.MAX_VALUE;

    public static class Block {
        int x;
        int y;

        public Block(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        houseList = new ArrayList<>();
        chickenList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    houseList.add(new Block(i, j));
                } else if (value == 2) {
                    chickenList.add(new Block(i, j));
                }
            }
        }

        // 치킨집 선택 조합 탐색
        combination(new ArrayList<>(), 0, 0);

        System.out.println(minDistance);
    }

    // 조합 계산
    private static void combination(List<Block> selected, int start, int depth) {
        if (depth == M) {
            // 선택된 치킨집으로 최소 거리 계산
            minDistance = Math.min(minDistance, calculateDistance(selected));
            return;
        }

        for (int i = start; i < chickenList.size(); i++) {
            selected.add(chickenList.get(i));
            combination(selected, i + 1, depth + 1);
            selected.remove(selected.size() - 1);
        }
    }

    // 최소 치킨 거리 계산
    private static int calculateDistance(List<Block> selected) {
        int totalDistance = 0;

        for (Block house : houseList) {
            int distance = Integer.MAX_VALUE;
            for (Block chicken : selected) {
                distance = Math.min(distance, Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y));
            }
            totalDistance += distance;
        }
        return totalDistance;
    }
}