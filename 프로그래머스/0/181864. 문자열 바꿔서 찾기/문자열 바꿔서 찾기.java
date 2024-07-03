class Solution {
    public int solution(String myString, String pat) {
        String tempString = myString.replaceAll("A", "#");
        tempString = tempString.replaceAll("B", "A");
        String result = tempString.replaceAll("#", "B");

        return result.contains(pat) ? 1 : 0;
    }
}