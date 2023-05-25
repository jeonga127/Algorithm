import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Vertex2 implements Comparable<Vertex2> {
    int number;
    long cost;

    Vertex2(int number, long cost) {
        this.number = number;
        this.cost = cost;
    }


    @Override
    public int compareTo(Vertex2 o) {
        return Long.compare(this.cost, o.cost);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시(정점)의 개수
        int M = Integer.parseInt(br.readLine()); // 버스(간선)의 개수

        List<Vertex2>[] graph = new ArrayList[N];
        long[] answer = new long[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int arrive = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start - 1].add(new Vertex2(arrive - 1, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int arrive = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            if (i != start - 1)
                answer[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Vertex2> queue = new PriorityQueue<>();
        queue.add(new Vertex2(start - 1, 0));

        while (!queue.isEmpty()) {
            Vertex2 target = queue.poll();
            visited[target.number] = true;

            if (target.number == arrive - 1)
                break;

            for (Vertex2 v : graph[target.number]) {
                if (!visited[v.number] && answer[v.number] > target.cost + v.cost) {
                    answer[v.number] = target.cost + v.cost;
                    queue.add(new Vertex2(v.number, answer[v.number]));
                }
            }
        }

        System.out.print(answer[arrive - 1]);
    }
}