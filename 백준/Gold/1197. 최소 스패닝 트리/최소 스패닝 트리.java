import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Vertex implements Comparable<Vertex> {
    int start;
    int end;
    int weight;

    Vertex(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Vertex o) {
        return Integer.compare(this.weight, o.weight);
    }
}

public class Main {
    static int[] parent;

    public static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX < parentY) parent[parentY] = parentX;
        if (parentY < parentX) parent[parentX] = parentY;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점 개수
        int E = Integer.parseInt(st.nextToken()); // 간선 개수
        parent = new int[V + 1];

        for (int i = 1; i < V + 1; i++)
            parent[i] = i;

        PriorityQueue<Vertex> queue = new PriorityQueue<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 시작 정점
            int B = Integer.parseInt(st.nextToken()); // 종료 정점
            int C = Integer.parseInt(st.nextToken()); // 가중치

            queue.add(new Vertex(A, B, C));
        }

        int answer = 0;
        while (!queue.isEmpty() && V >= 0) {
            Vertex target = queue.poll();

            if (find(target.start) == find(target.end))
                continue;

            union(target.start, target.end);
            answer += target.weight;
            V--;
        }
        System.out.print(answer);
    }
}