import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        if(!Arrays.asList(words).contains(target)) return answer;

        boolean[] visited = new boolean[words.length];

        int[] distance = new int[words.length];

        Queue<Integer> toVisit = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            if(similar(begin, words[i])) {
                toVisit.offer(i);
                visited[i] = true;
                distance[i] = 1;
            }
        }


        while(!toVisit.isEmpty()) {
            int nextIdx = toVisit.poll();

            String nextWord = words[nextIdx];


            if(nextWord.equals(target)) {
                answer = distance[nextIdx];
                break;
            }

            for (int i = 0; i < words.length; i++) {
                if(similar(nextWord, words[i]) && !visited[i]) {
                    toVisit.offer(i);
                    visited[i] = true;
                    distance[i] = distance[nextIdx] + 1;
                }
            }
        }

        return answer;
    }

    private boolean similar(String word, String target) {
        int k = 0;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == target.charAt(i)) k++;
        }

        return k == word.length() - 1;
    }
}