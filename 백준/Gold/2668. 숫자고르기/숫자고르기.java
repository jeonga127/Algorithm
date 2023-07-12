import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        for (int i = 1; i < N + 1; i++)
            arr[i] = Integer.parseInt(br.readLine());

        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            boolean[] visited = new boolean[N + 1];

            if (!visited[i]) {
                visited[i] = true;
                int next = arr[i];

                while (!visited[next]) {
                    visited[next] = true;
                    next = arr[next];
                }

                if (next == i)
                    answer.add(i);
            }
        }

        Collections.sort(answer);
        sb.append(answer.size()).append("\n");
        answer.stream().forEach(i -> sb.append(i).append("\n"));
        System.out.print(sb);
    }
}