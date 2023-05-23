import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0 && queue.isEmpty()) sb.append(0).append("\n");
            else if (x == 0) sb.append(queue.poll()).append("\n");
            else queue.offer(x);
        }
        System.out.print(sb);
    }
}