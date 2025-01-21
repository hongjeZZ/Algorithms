import java.util.Arrays;

class Solution {

    static class Fail implements Comparable<Fail> {
        int level;
        double per;

        public Fail(int level, double per) {
            this.level = level;
            this.per = per;
        }

        @Override
        public int compareTo(Fail o) {
            if (per == o.per) {
                return Integer.compare(level, o.level);
            } else {
                return Double.compare(o.per, per);
            }
        }
    }
    
    public int[] solution(int N, int[] stages) {
        Fail[] fail = new Fail[N];

        for (int i = 0; i < N; i++) {
            int tryCnt = 0;
            int clearCnt = 0;

            for (int j = 0; j < stages.length; j++) {
                int userStage = stages[j];

                if (userStage >= i + 1) tryCnt++;
                if (userStage > i + 1) clearCnt++;
            }
            if (tryCnt == 0) {
                fail[i] = new Fail(i + 1, 0);
                continue;
            }

            int failCnt = tryCnt - clearCnt;
            fail[i] = new Fail(i + 1, (double) failCnt / tryCnt);
        }

        Arrays.sort(fail);

        return Arrays.stream(fail).mapToInt(f -> f.level).toArray();
    }
}