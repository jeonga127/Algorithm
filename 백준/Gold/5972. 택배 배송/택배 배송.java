import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Barn {
        int num, cow;

        Barn(int num, int cow) {
            this.num = num;
            this.cow = cow;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 헛간 개수
        int M = Integer.parseInt(st.nextToken()); // 길의 개수

        List<Barn>[] graph = new ArrayList[N + 1];
        int[] answer = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
            answer[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A].add(new Barn(B, C));
            graph[B].add(new Barn(A, C));
        }

        PriorityQueue<Barn> queue = new PriorityQueue<>(Comparator.comparingInt(barn -> barn.cow));
        queue.add(new Barn(1, 0));
        visited[1] = true;

        while (!queue.isEmpty()) {
            Barn target = queue.poll();
            visited[target.num] = true;

            if (target.num == N)
                break;

            for(Barn next : graph[target.num]){
                if(!visited[next.num] && answer[next.num] > target.cow + next.cow){
                    answer[next.num] = target.cow + next.cow;
                    queue.add(new Barn(next.num, answer[next.num]));
                }
            }
        }

        System.out.print(answer[N]);
    }
}