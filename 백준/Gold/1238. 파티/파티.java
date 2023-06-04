import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Town implements Comparable<Town> {
    int num;
    int time;

    Town(int num, int time) {
        this.num = num;
        this.time = time;
    }

    @Override
    public int compareTo(Town o) {
        return Integer.compare(this.time, o.time);
    }
}

public class Main {
    static List<Town>[] graph;
    static int[] answer;
    static int UNDEFINED = Integer.MAX_VALUE;

    public static int dijkstra(int start, int end) {
        Arrays.fill(answer, UNDEFINED);

        PriorityQueue<Town> queue = new PriorityQueue<>();
        queue.add(new Town(start, 0));

        while (!queue.isEmpty()) {
            Town target = queue.poll();
            
            if (target.num == end)
                break;

            for (Town town : graph[target.num]) {
                if (answer[town.num] > target.time + town.time) {
                    answer[town.num] = target.time + town.time;
                    queue.add(new Town(town.num, answer[town.num]));
                }
            }
        }
        return answer[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생 수, 마을 수
        int M = Integer.parseInt(st.nextToken()); // 도로 수
        int X = Integer.parseInt(st.nextToken()); // 파티 장소

        answer = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 도로 시작점
            int end = Integer.parseInt(st.nextToken()); // 도로 도착점
            int time = Integer.parseInt(st.nextToken()); // 소요 시간

            graph[start].add(new Town(end, time));
        }

        int maxTime = Integer.MIN_VALUE;
        for (int i = 1; i < N + 1; i++) {
            if (i == X) continue;
            maxTime = Math.max(maxTime, dijkstra(i, X) + dijkstra(X, i));
        }

        System.out.print(maxTime);
    }
}