class Solution {
    static int[] arr;
    static int count = 0;

    public int solution(int[] numbers, int target) {
        arr = new int[numbers.length];

        backTracking(numbers, target,0);

        return count;
    }
    private void backTracking(int[] numbers, int target, int num) {
        if(num == arr.length) {
            calculate(numbers, target, arr);
            return;
        }

        for (int i = 0; i < 2; i++) {
            arr[num] = i;
            backTracking(numbers, target, num + 1);
        }

    }

    private void calculate(int[] numbers, int target, int[] arr) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(arr[i] == 0) sum += numbers[i];
            else sum -= numbers[i];
        }
        if(sum == target) count++;
    }
}