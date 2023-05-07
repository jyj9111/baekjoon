import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] stack = new int[10_001];
        boolean isEmpty = true;
        int pos = 0;
        int num = Integer.parseInt(br.readLine());

        while (num > 0) {
            String[] str = br.readLine().split(" ");
            switch(str[0]) {
                case "push":
                    stack[pos] = Integer.parseInt(str[1]);
                    isEmpty = false;
                    pos++;
                    break;

                case "pop":
                    if(isEmpty) {
                        bw.write("-1\n");
                        bw.flush();
                        break;
                    } else {
                        bw.write(Integer.toString(stack[pos - 1]) + "\n");
                        bw.flush();
                        pos--;
                        if(pos == 0)
                            isEmpty = true;
                        break;
                    }

                case "size":
                    if(pos < 0) pos = 0;
                    bw.write(Integer.toString(pos) + "\n");
                    bw.flush();
                    break;

                case "empty":
                    if(isEmpty) {
                        bw.write("1\n");;
                        bw.flush();
                        break;
                    } else {
                        bw.write("0\n");;
                        bw.flush();
                        break;
                    }

                case "top":
                    if(isEmpty) {
                        bw.write("-1\n");
                        bw.flush();
                        break;
                    } else {
                        bw.write(Integer.toString(stack[pos - 1]) + "\n");
                        bw.flush();
                        break;
                    }
            }
            num--;
        }
    }
}