class Solution {
    public int solution(int n) {
        int answer = n;
        int count = 0;
        while(n >= 1) {
            int factors = 0;    
            for(int i = 2; i < n; i++) {
                if(n % i == 0) factors++;
            }
            if(factors == 0) count++;
            n--;
        }
        return answer - count;
    }
}