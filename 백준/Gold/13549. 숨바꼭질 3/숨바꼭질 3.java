import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Location3 implements Comparable<Location3>{
    int idx;
    int depth;

    Location3(int idx, int depth) {
        this.idx = idx;
        this.depth = depth;
    }


    @Override
    public int compareTo(Location3 o) {
        return Integer.compare(depth, o.depth);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];

        PriorityQueue<Location3> queue = new PriorityQueue<>();
        queue.add(new Location3(N, 0));

        while (!queue.isEmpty()) {
            Location3 now = queue.poll();
            visited[now.idx] = true;

            if (now.idx == K) {
                System.out.print(now.depth);
                return;
            }

            if (now.idx * 2 < 100001 && !visited[now.idx * 2])
                queue.add(new Location3(now.idx * 2, now.depth));
            if (now.idx + 1 < 100001 && !visited[now.idx + 1])
                queue.add(new Location3(now.idx + 1, now.depth + 1));
            if (now.idx - 1 >= 0 && !visited[now.idx - 1])
                queue.add(new Location3(now.idx - 1, now.depth + 1));
        }
    }
}