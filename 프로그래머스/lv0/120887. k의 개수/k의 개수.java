class Solution {
    public int solution(int i, int j, int k) {
        int count = 0;
        
        String temp = "";
        for (int l = i; l <= j ; l++) {
            temp += Integer.toString(l);
        }
        
        String[] split = temp.split("");
        for (int l = 0; l < split.length; l++) {
            if(split[l].equals(Integer.toString(k))) count++;
        }
        return count;
    }
}