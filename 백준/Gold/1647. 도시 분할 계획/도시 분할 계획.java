import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Road implements Comparable<Road> {
    int start;
    int end;
    int cost;

    Road(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Road o) {
        return Integer.compare(this.cost, o.cost);
    }
}

public class Main {
    static int[] parent;

    static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX < parentY) parent[parentY] = parentX;
        if (parentY < parentX) parent[parentX] = parentY;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //집의 개수
        int M = Integer.parseInt(st.nextToken()); //길의 개수

        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++)
            parent[i] = i;

        PriorityQueue<Road> queue = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            queue.add(new Road(A, B, C));
        }

        long answer = 0;
        int maxCost = Integer.MIN_VALUE;

        while (!queue.isEmpty() && N >= 0) {
            Road target = queue.poll();

            if (find(target.start) == find(target.end))
                continue;

            union(target.start, target.end);
            maxCost = Math.max(maxCost, target.cost);
            answer += target.cost;
            N--;
        }

        System.out.print(answer - maxCost);
    }
}