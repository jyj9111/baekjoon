import java.io.*;
import java.util.Deque;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new LinkedList<>();


        // 입력
        String[] command = br.readLine().split(" ");
        int num = Integer.parseInt(command[0]);
        int pullNum = Integer.parseInt(command[1]);

        String[] nums = br.readLine().split(" ");
        int[] numsInt = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsInt[i] =Integer.parseInt(nums[i]);
        }

        //처리
        // 덱에 1 ~ num까지 차례로 숫자 삽입
        for (int i = 1; i <= num; i++) {
            deque.addLast(i);
        }

        //뽑아야 할 수 만큼 반복

        int result = 0;

        while (pullNum > 0) {

            Deque<Integer> forwardDeque = null;
            Deque<Integer> reverseDeque =  null;
            int forwardCount = 0;
            int reverseCount = 0;

            // 2번 연산 - 순방향
            forwardDeque = new LinkedList<>(deque);
            for (int i = 0; i < num; i++) {
                int temp = forwardDeque.removeFirst();
                if(numsInt[numsInt.length - pullNum] == temp) {
                    break;
                }
                forwardDeque.addLast(temp);
                forwardCount++;
            }

            // 3번 연산 - 역방향
            reverseDeque = new LinkedList<>(deque);
            for (int i = 0; i < num; i++) {

                int temp = reverseDeque.removeLast();
                if(numsInt[numsInt.length - pullNum] == temp) {
                    reverseCount++;
                    break;
                }
                reverseDeque.addFirst(temp);
                reverseCount++;
            }

            //비교
            if (forwardCount <= reverseCount) {
                result += forwardCount;
                deque = new LinkedList<>(forwardDeque);
                pullNum--;
                num--;
            } else {
                result += reverseCount;
                deque = new LinkedList<>(reverseDeque);
                pullNum--;
                num--;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }
}