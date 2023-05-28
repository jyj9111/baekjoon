class Solution {
    public int[] shiftArr(int[] arr, boolean isRightShift) {
        int[] result = new int[arr.length];
        if(isRightShift) {
            result[0] = arr[arr.length - 1];
            for (int i = 0; i < arr.length - 1; i++) {
                result[i + 1] = arr[i];
            }
        } else {
            result[arr.length - 1] = arr[0];
            for (int i = arr.length - 1; i > 0; i--) {
                result[i - 1] = arr[i];
            }
        }
        return result;
    }
    
    public int[] solution(int[] numbers, String direction) {
        int[] answer = {};
        
        switch (direction) {
            case "right":
                answer = shiftArr(numbers, true);
                break;
            case "left":
                answer = shiftArr(numbers, false);
                break;
        }
        
        return answer;
    }
}