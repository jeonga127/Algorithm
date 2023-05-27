import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Location4 implements Comparable<Location4> {
    int idx;
    int depth;
    Location4 parent;

    Location4(int idx, int depth, Location4 parent) {
        this.idx = idx;
        this.depth = depth;
        this.parent = parent;
    }

    @Override
    public int compareTo(Location4 o) {
        return Integer.compare(depth, o.depth);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];

        PriorityQueue<Location4> queue = new PriorityQueue<>();
        queue.add(new Location4(N, 0, null));

        while (!queue.isEmpty()) {
            Location4 now = queue.poll();
            visited[now.idx] = true;

            if (now.idx == K) {
                sb.append(now.depth).append("\n");

                Stack<Integer> track = new Stack<>();
                while (now != null) {
                    track.push(now.idx);
                    now = now.parent;
                }

                while (!track.isEmpty())
                    sb.append(track.pop() + " ");

                break;
            }

            if (now.idx + 1 < 100001 && !visited[now.idx + 1])
                queue.add(new Location4(now.idx + 1, now.depth + 1, now));
            if (now.idx - 1 >= 0 && !visited[now.idx - 1])
                queue.add(new Location4(now.idx - 1, now.depth + 1, now));
            if (now.idx * 2 < 100001 && !visited[now.idx * 2])
                queue.add(new Location4(now.idx * 2, now.depth + 1, now));
        }
        System.out.print(sb);
    }
}