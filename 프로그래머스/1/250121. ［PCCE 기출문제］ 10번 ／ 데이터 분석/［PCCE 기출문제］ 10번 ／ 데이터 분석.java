import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        Map<String, Integer> keyIndexMap = new HashMap<>();
        keyIndexMap.put("code", 0);
        keyIndexMap.put("date", 1);
        keyIndexMap.put("maximum", 2);
        keyIndexMap.put("remain", 3);

        int extIndex = keyIndexMap.get(ext);
        int sortIndex = keyIndexMap.get(sort_by);

        List<int[]> filteredList = new ArrayList<>();
        for (int[] row : data) {
            if (row[extIndex] < val_ext) {
                filteredList.add(row);
            }
        }

        filteredList.sort(Comparator.comparingInt(row -> row[sortIndex]));

        int[][] answer = new int[filteredList.size()][];
        for (int i = 0; i < filteredList.size(); i++) {
            answer[i] = filteredList.get(i);
        }

        return answer;
    }
}