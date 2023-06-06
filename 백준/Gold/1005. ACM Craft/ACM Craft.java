import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        while (--T >= 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 건물의 개수
            int K = Integer.parseInt(st.nextToken()); // 규칙의 개수

            int[] times = new int[N + 1];
            int[] indegree = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++)
                times[i] = Integer.parseInt(st.nextToken()); // 각 건물 소요시간

            List<Integer>[] graph = new LinkedList[N + 1];
            for (int i = 1; i < N + 1; i++)
                graph[i] = new LinkedList<>();

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from].add(to);
                indegree[to]++;
            }

            int W = Integer.parseInt(br.readLine()); // 목표 건물
            int answer[] = new int[N + 1];

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i < N + 1; i++) {
                if (indegree[i] == 0)
                    queue.add(i);
            }

            while (!queue.isEmpty()) {
                int target = queue.poll();
                answer[target] += times[target];

                for (int i : graph[target]) {
                    answer[i] = Math.max(answer[i], answer[target]);
                    indegree[i]--;

                    if (indegree[i] == 0)
                        queue.add(i);
                }
            }
            sb.append(answer[W]).append("\n");
        }
        System.out.print(sb);
    }
}