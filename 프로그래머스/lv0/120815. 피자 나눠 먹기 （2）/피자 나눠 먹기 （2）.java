class Solution {
    public int getGDC(int num1, int num2) {
        if(num1 % num2 == 0)
            return num2;
        return getGDC(num2 ,num1 % num2);
    }
    
    public int solution(int n) {
        int answer = 0;
        int lmc = 6 * n / getGDC(n, 6);
        return lmc / 6;
    }
}