import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location {
    int idx;
    int depth;

    Location(int idx, int depth) {
        this.idx = idx;
        this.depth = depth;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        int K = Integer.parseInt(st.nextToken()); // 동생의 위치
        boolean[] visited = new boolean[100001];

        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(N, 0));

        while (!queue.isEmpty()) {
            Location now = queue.poll();
            visited[now.idx] = true;

            if (now.idx == K) {
                System.out.print(now.depth);
                return;
            }

            if (now.idx + 1 < 100001 && !visited[now.idx + 1])
                queue.add(new Location(now.idx + 1, now.depth + 1));
            if (now.idx - 1 >= 0 && !visited[now.idx - 1])
                queue.add(new Location(now.idx - 1, now.depth + 1));
            if (now.idx * 2 < 100001 && !visited[now.idx * 2])
                queue.add(new Location(now.idx * 2, now.depth + 1));
        }
    }
}