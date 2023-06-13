import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 문제의 수
        int M = Integer.parseInt(st.nextToken()); // 정보의 수
        int[] indegree = new int[N + 1];

        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            indegree[B] += 1;
            graph[A].add(B);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 1; i<N+1; i++){
            if(indegree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()){
            int target = queue.poll();
            sb.append(target).append(" ");

            for(int g : graph[target]){
                indegree[g] -= 1;

                if(indegree[g] == 0)
                    queue.add(g);
            }
        }

        System.out.print(sb);
    }
}