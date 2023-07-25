import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static class Number {
        int num, idx;

        Number(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Number> queue = new LinkedList<>();

        for (int idx = 0; idx < N; idx++) {
            int num = Integer.parseInt(st.nextToken());

            while(!queue.isEmpty() && queue.peekLast().num > num)
                queue.pollLast();

            while(!queue.isEmpty() && queue.peekFirst().idx < idx - L + 1)
                queue.pollFirst();

            queue.add(new Number(num, idx));
            sb.append(queue.peekFirst().num).append(" ");
        }

        System.out.print(sb);
    }
}