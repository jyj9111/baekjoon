import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        LinkedList<Integer> list = new LinkedList<>();

        // 리스트에 1부터 n까지의 수를 추가한다.
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int index = k - 1; // 인덱스는 0부터 시작하므로 k-1로 초기화한다.

        System.out.print("<");

        while (list.size() > 1) {
            // 제거할 사람의 인덱스를 계산한다.
            index %= list.size();
            System.out.print(list.remove(index) + ", ");
            index += k - 1;
        }

        System.out.print(list.getFirst() + ">");
    }
}
