class Solution {
    public int solution(int n) {
        
        for(int i = 1; i * i <= n; i++) {
            if(n / i == i && n % i == 0) return 1;
        }
        return 2;
    }
}