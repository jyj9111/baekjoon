class Solution {
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }

    private int answer = 0;

    public void dfs(int[] numbers, int next, int target, int sum) {
        if(next == numbers.length) {
            if(sum == target) this.answer++;
            return;
        }

        dfs(numbers, next + 1, target, sum + numbers[next]);
        dfs(numbers, next + 1, target, sum - numbers[next]);
    }
}