import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Vertex3 implements Comparable<Vertex3> {
    int number;
    long cost;

    Vertex3(int number, long cost) {
        this.number = number;
        this.cost = cost;
    }

    @Override
    public int compareTo(Vertex3 o) {
        return Long.compare(this.cost, o.cost);
    }
}

public class Main {
    static List<Vertex3>[] graph;
    static long[] answer;

    public static long dijkstra(int start, int end) {
        Arrays.fill(answer, Long.MAX_VALUE);

        PriorityQueue<Vertex3> queue = new PriorityQueue<>();
        queue.add(new Vertex3(start, 0));

        while (!queue.isEmpty()) {
            Vertex3 target = queue.poll();

            if (target.number == end)
                break;

            for (Vertex3 v : graph[target.number]) {
                if (answer[v.number] > v.cost + target.cost) {
                    answer[v.number] = v.cost + target.cost;
                    queue.add(new Vertex3(v.number, answer[v.number]));
                }
            }
        }
        return answer[end];
    }

    public static long calDijkstra(int v1, int v2) {
        long test1 = dijkstra(0, v1);
        long test2 = dijkstra(v2, answer.length - 1);
        return (test1 == Long.MAX_VALUE || test2 == Long.MAX_VALUE) ? Long.MAX_VALUE : test1 + test2;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수

        answer = new long[N];
        graph = new ArrayList[N];

        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start - 1].add(new Vertex3(end - 1, cost));
            graph[end - 1].add(new Vertex3(start - 1, cost));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long result;

        if (v1 == 1 && v2 == N) { // 경로는 1 -> N
            result = dijkstra(0, N - 1);
        } else if (v1 == 1) { // v1이 시작점일 때 경로는 1 -> v2 -> N
            result = calDijkstra(v2 - 1, v2 - 1);
        } else if (v2 == N) { // v2가 도착점일 때 경로는 1 -> v1 -> N
            result = calDijkstra(v1 - 1, v1 - 1);
        } else { // 경로는 0 -> v1 -> v2 -> N or 0 -> v2 -> v1 -> N
            result = Math.min(calDijkstra(v1 - 1, v2 - 1), calDijkstra(v2 - 1, v1 - 1));
            System.out.print(result == Long.MAX_VALUE ? -1 : result + dijkstra(v1 - 1, v2 - 1));
            return;
        }

        System.out.print(result == Long.MAX_VALUE ? -1 : result);
    }
}