import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Vertex4 implements Comparable<Vertex4> {
    int number;
    long cost;

    Vertex4(int number, long cost) {
        this.number = number;
        this.cost = cost;
    }

    @Override
    public int compareTo(Vertex4 o) {
        return Long.compare(this.cost, o.cost);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수

        List<Vertex4>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        int[] parent = new int[n];
        long[] answer = new long[n];
        Arrays.fill(answer, Long.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start - 1].add(new Vertex4(end - 1, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        answer[start - 1] = 0;
        parent[start - 1] = -1;

        PriorityQueue<Vertex4> queue = new PriorityQueue<>();
        Stack<Vertex4> stack = new Stack<>();
        queue.add(new Vertex4(start - 1, 0));

        while (!queue.isEmpty()) {
            Vertex4 target = queue.poll();
            stack.push(target);

            if (target.number == end - 1)
                break;

            for (Vertex4 v : graph[target.number]) {
                if (answer[v.number] > target.cost + v.cost) {
                    parent[v.number] = target.number;
                    answer[v.number] = target.cost + v.cost;
                    queue.add(new Vertex4(v.number, answer[v.number]));
                }
            }
        }

        sb.append(answer[end - 1]).append("\n");
        Stack<Integer> track = new Stack<>();
        track.push(end);

        while (parent[end - 1] != -1) {
            track.push(parent[end - 1] + 1);
            end = parent[end - 1] + 1;
        }

        sb.append(track.size()).append("\n");
        while (!track.isEmpty())
            sb.append(track.pop() + " ");
        System.out.print(sb);
    }
}