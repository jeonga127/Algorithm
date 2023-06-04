import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Town implements Comparable<Town> {
    int num;
    int time;

    Town(int num, int time) {
        this.num = num;
        this.time = time;
    }

    @Override
    public int compareTo(Town o) {
        return Integer.compare(this.time, o.time);
    }
}

public class Main {
    static int N, M, X;

    public static int[] dijkstra(List<Town>[] graph) {
        int[] answer = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        Arrays.fill(answer, Integer.MAX_VALUE);
        PriorityQueue<Town> queue = new PriorityQueue<>();
        queue.add(new Town(X, 0));

        while (!queue.isEmpty()) {
            Town target = queue.poll();
            visited[target.num] = true;

            for (Town town : graph[target.num]) {
                if (!visited[town.num] && answer[town.num] > target.time + town.time) {
                    answer[town.num] = target.time + town.time;
                    queue.add(new Town(town.num, answer[town.num]));
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 학생 수, 마을 수
        M = Integer.parseInt(st.nextToken()); // 도로 수
        X = Integer.parseInt(st.nextToken()); // 파티 장소

        List<Town>[] graph = new ArrayList[N + 1];
        List<Town>[] reverse = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 도로 시작점
            int end = Integer.parseInt(st.nextToken()); // 도로 도착점
            int time = Integer.parseInt(st.nextToken()); // 소요 시간

            graph[start].add(new Town(end, time));
            reverse[end].add(new Town(start, time));
        }

        int[] distToX = dijkstra(graph);
        int[] distFromX = dijkstra(reverse);
        
        int maxTime = Integer.MIN_VALUE;
        for (int i = 1; i < N + 1; i++) {
            if (i == X) continue;
            maxTime = Math.max(maxTime, distToX[i] + distFromX[i]);
        }

        System.out.print(maxTime);
    }
}