class Solution {
    
    int n;
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        this.n = n;
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            answer[i] = decode(arr1[i], arr2[i]);
        }
        
        return answer;
    }
    
    public String decode(int a, int b) {
        StringBuilder sb = new StringBuilder();
        
        String str1 = String.format("%" + n + "s", Integer.toBinaryString(a)).replace(' ', '0');
        String str2 = String.format("%" + n + "s", Integer.toBinaryString(b)).replace(' ', '0');

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == '1' || str2.charAt(i) == '1') {
                sb.append("#");
            } else {
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
}