import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Vertex implements Comparable<Vertex> {
    int number;
    int cost;

    Vertex(int number, int cost) {
        this.number = number;
        this.cost = cost;
    }

    @Override
    public int compareTo(Vertex other) {
        return Integer.compare(this.cost, other.cost);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<List<Vertex>> graph = new ArrayList<>();

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        int[] answer = new int[V];
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (i != start - 1) answer[i] = Integer.MAX_VALUE;
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u - 1).add(new Vertex(v - 1, w));
        }

        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.add(new Vertex(start - 1, 0));

        while (!queue.isEmpty()) {
            Vertex target = queue.poll();
            visited[target.number] = true;

            for (Vertex v : graph.get(target.number)) {
                if (!visited[v.number] && answer[v.number] > answer[target.number] + v.cost) { // target을 거쳐서 v로 갈 때 더 cost가 적다면 갱신
                    answer[v.number] = answer[target.number] + v.cost;
                    queue.add(new Vertex(v.number, answer[v.number]));
                }
            }
        }

        for (int i = 0; i < V; i++)
            System.out.println(answer[i] == Integer.MAX_VALUE ? "INF" : answer[i]);
    }
}