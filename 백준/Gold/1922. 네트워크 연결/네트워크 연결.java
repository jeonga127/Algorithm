import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Computer implements Comparable<Computer> {
    int from;
    int to;
    int cost;

    Computer(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Computer o) {
        return Integer.compare(this.cost, o.cost);
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
        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int M = Integer.parseInt(br.readLine()); // 선의 수
        parent = new int[N + 1];

        for (int i = 1; i < N + 1; i++)
            parent[i] = i;

        PriorityQueue<Computer> queue = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int computerA = Integer.parseInt(st.nextToken());
            int computerB = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (computerA == computerB)
                continue;

            queue.add(new Computer(computerA, computerB, cost));
        }

        int answer = 0;
        while (!queue.isEmpty() && N >= 0) {
            Computer target = queue.poll();

            if (find(target.from) != find(target.to)) {
                union(target.from, target.to);
                answer += target.cost;
                N--;
            }
        }

        System.out.print(answer);
    }
}