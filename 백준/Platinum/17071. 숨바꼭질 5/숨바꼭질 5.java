import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Location5 implements Comparable<Location5> {
    int idx;
    int depth;

    Location5(int idx, int depth) {
        this.idx = idx;
        this.depth = depth;
    }

    @Override
    public int compareTo(Location5 o) {
        return Integer.compare(depth, o.depth);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[500001][2];

        List<Integer> currentList = new ArrayList<>();
        for (int i = 0; i < 500000; i++) {
            int tmp = K + i * (i + 1) / 2;
            if (tmp > 500000) break;
            currentList.add(tmp);
        }

        PriorityQueue<Location5> queue = new PriorityQueue<>();
        queue.add(new Location5(N, 0));

        while (!queue.isEmpty()) {
            Location5 now = queue.poll();
            visited[now.idx][now.depth % 2] = true;

            if (now.depth >= currentList.size())
                break;

            int current = currentList.get(now.depth);

            if (visited[current][now.depth % 2]) {
                System.out.print(now.depth);
                return;
            }

            if (now.idx * 2 < 500001 && !visited[now.idx * 2][(now.depth + 1) % 2]) {
                queue.add(new Location5(now.idx * 2, now.depth + 1));
            }
            if (now.idx + 1 < 500001 && !visited[now.idx + 1][(now.depth + 1) % 2]) {
                queue.add(new Location5(now.idx + 1, now.depth + 1));
            }
            if (now.idx - 1 >= 0 && !visited[now.idx - 1][(now.depth + 1) % 2]) {
                queue.add(new Location5(now.idx - 1, now.depth + 1));
            }
        }
        System.out.print(-1);
    }
}