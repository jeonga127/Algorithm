import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location2 {
    int idx;
    int depth;

    Location2(int idx, int depth) {
        this.idx = idx;
        this.depth = depth;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];

        Queue<Location2> queue = new LinkedList<>();
        queue.add(new Location2(N, 0));
        int min = Integer.MAX_VALUE;
        int count = 0;

        while (!queue.isEmpty()) {
            Location2 now = queue.poll();
            visited[now.idx] = true;

            if (now.depth > min)
                break;

            if (now.idx == K) {
                min = now.depth;
                count++;
            }

            if (now.idx + 1 < 100001 && !visited[now.idx + 1])
                queue.add(new Location2(now.idx + 1, now.depth + 1));
            if (now.idx - 1 >= 0 && !visited[now.idx - 1])
                queue.add(new Location2(now.idx - 1, now.depth + 1));
            if (now.idx * 2 < 100001 && !visited[now.idx * 2])
                queue.add(new Location2(now.idx * 2, now.depth + 1));
        }

        System.out.println(min);
        System.out.print(count);
    }
}