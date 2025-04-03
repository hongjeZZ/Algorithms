import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // 모든 경우 cache miss
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        int answer = 0;

        LinkedHashMap<String, Integer> cacheMap = new LinkedHashMap<>(cacheSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > cacheSize; // 캐시가 초과되면 가장 오래된 항목 삭제
            }
        };

        for (String city : cities) {
            city = city.toLowerCase();
            
            // 캐시 히트
            if (cacheMap.containsKey(city)) {
                answer += 1; // 캐시 히트
            } else {
                answer += 5; // 캐시 미스
            }
            cacheMap.put(city, 1); // 캐시에 추가 (자동으로 LRU 방식으로 정렬됨)
        }

        return answer;
    }
}