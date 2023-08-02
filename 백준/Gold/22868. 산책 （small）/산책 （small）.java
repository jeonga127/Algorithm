import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] passBy;
    static int N;

    public static class Node {
        int num;
        int depth;

        Node(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    }

    public static int dijkstra(int start, int end, boolean isEnd) {
        boolean[] visited = new boolean[N + 1];
        if (isEnd) {
            int tmp = passBy[start];
            while (tmp > 0) {
                visited[tmp] = true;
                tmp = passBy[tmp];
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node target = queue.poll();

            for (int next : graph[target.num]) {
                if (!visited[next]) {
                    visited[next] = true;
                    passBy[next] = target.num;
                    queue.add(new Node(next, target.depth + 1));
                }

                if (next == end)
                    return target.depth + 1;
            }
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //정점의 개수
        int M = Integer.parseInt(st.nextToken()); //도로의 개수

        passBy = new int[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
            graph[B].add(A);
        }

        for (int i = 1; i < N + 1; i++)
            Collections.sort(graph[i]);

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.print(dijkstra(start, end, false) + dijkstra(end, start, true));
    }
}