import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Character> list = new LinkedList<Character>();

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        ListIterator iter = list.listIterator();
        while (iter.hasNext()) {
            iter.next();
        }

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String mode = br.readLine();
            if(mode.charAt(0) == 'P') {
                iter.add(mode.charAt(2));
            } else if (mode.charAt(0) == 'L') {
                if(iter.hasPrevious())
                    iter.previous();
            } else if (mode.charAt(0) == 'D') {
                if(iter.hasNext())
                    iter.next();
            } else if (mode.charAt(0) == 'B') {
                if(iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            } else {
                break;
            }
        }
        for(Character chr : list) {
            bw.write(chr);
        }
        bw.flush();
        bw.close();
    }
}