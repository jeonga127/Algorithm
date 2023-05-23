import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> plus = new PriorityQueue<>();
        PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x > 0) plus.add(x);
            else if (x < 0) minus.add(x);
            else if (plus.isEmpty() && minus.isEmpty()) sb.append(0).append("\n");
            else {
                if (plus.isEmpty() || minus.isEmpty())
                    sb.append(plus.isEmpty() ? minus.poll() : plus.poll()).append("\n");
                else {
                    int candidatePlus = plus.poll();
                    int candidateMinus = minus.poll();

                    if (candidatePlus >= Math.abs(candidateMinus)) {
                        sb.append(candidateMinus).append("\n");
                        plus.add(candidatePlus);
                    } else {
                        sb.append(candidatePlus).append("\n");
                        minus.add(candidateMinus);
                    }
                }
            }
        }
        System.out.print(sb);
    }
}