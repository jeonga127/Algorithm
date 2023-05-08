import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < N; i++)
            queue.add(i + 1);

        int idx = 1;
        while (!queue.isEmpty()) {
            if (idx == K) {
                answer.add(queue.poll());
                idx = 1;
            } else {
                queue.add(queue.poll());
                idx++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (i == 0) sb.append("<");
            sb.append(answer.get(i));
            if (i == N - 1) sb.append(">");
            else sb.append(", ");
        }
        System.out.print(sb);
    }
}