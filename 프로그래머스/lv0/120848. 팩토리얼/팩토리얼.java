class Solution {
    public int factorial(int num) {
        int result = 1;
        for (int i = 2; i <= num ; i++) {
            result *= i;
        }
        return result;
    }
    
    public int solution(int n) {
        int num = 1;

        while(true) {
            int temp = factorial(num);
            if(temp > n) {
                num--;
                break;
            }
            if(temp == n) {
                break;
            }
            num++;
        }
        return num;
    }
}