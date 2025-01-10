class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int hp = health;
        int time = 1;

        int coolTime = bandage[0];
        int plus = bandage[1];
        int addPlus = bandage[2];

        // 몬스터 공격 횟수만큼 반복
        for (int i = 0; i < attacks.length; i++) {
            int attackTime = attacks[i][0];
            int damage = attacks[i][1];

            // 공격 이전까지 hp 계산
            int healTime = attackTime - time;
            int cnt = healTime / coolTime;
            hp = Math.min(health, hp + healTime * plus + addPlus * cnt);

            // 공격
            hp -= damage;

            // 시간 변경
            time = attackTime + 1;

            if (hp <= 0) {
                return -1;
            }
        }

        return hp;
    }
}