class Solution {
    public int[] solution(int[] num_list) {
        int length = num_list.length;
        int last = 0;
        int[] answer = new int[num_list.length + 1];

        if (num_list[length - 1] > num_list[length - 2]) last = num_list[length - 1] - num_list[length - 2];
        else last = num_list[length - 1] * 2;

        for (int i = 0; i < length; i++) {
            answer[i] = num_list[i];
        }
        answer[length] = last;
        return answer;
    }
}