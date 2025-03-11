// 트럭은 1초에 1씩 전진한다.
// 트럭은 1초에 1대씩 다리에 올라갈 수 있다.
// 트럭은 순서대로 다리에 올라가야 한다.

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> bridge = new LinkedList<>();
        int currentWeight = 0;
        int time = 0;
        int idx = 0;
        
         while (idx < truck_weights.length || !bridge.isEmpty()) {
            time++;

            // 다리에서 나갈 트럭 확인
            if (!bridge.isEmpty() && bridge.peek()[1] == time) {
                currentWeight -= bridge.poll()[0];
            }
            
            // 트럭 추가
            if (idx < truck_weights.length) {
                if (truck_weights[idx] + currentWeight <= weight && bridge.size() < bridge_length) {
                    bridge.add(new int[]{truck_weights[idx], time + bridge_length});
                    currentWeight += truck_weights[idx];
                    idx++;
                }
            }
        }
        
        return time;
    }
}