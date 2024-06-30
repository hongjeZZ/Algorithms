class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        String[] arr = rsp.split("");
        
        for (String s : arr) {
            sb.append(rockPaperScissors(s));
        }
        return sb.toString();
    }
    
    public String rockPaperScissors(String s) {
        if (s.equals("2")) return "0";
        else if (s.equals("0")) return "5";
        else if (s.equals("5")) return "2";
        else return null;
    }
}