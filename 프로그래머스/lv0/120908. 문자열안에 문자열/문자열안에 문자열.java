class Solution {
    public int solution(String str1, String str2) {
        String repStr = str1.replace(str2, "*");
        return repStr.contains("*") ? 1 : 2;
    }
}