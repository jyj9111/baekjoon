class Solution {
    public int solution(int num, int k) {
        
        String strNum = String.valueOf(num);
        String strK = String.valueOf(k);
        
        if(strNum.contains(strK)) 
            return strNum.indexOf(strK) + 1;
        
        return -1;
    }
}