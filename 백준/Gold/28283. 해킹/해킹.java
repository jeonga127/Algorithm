import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

class Computer {
    long money;
    int time;

    Computer(long money, int time) {
        this.money = money;
        this.time = time;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int computerNum = Integer.parseInt(st.nextToken());
        int networkNum = Integer.parseInt(st.nextToken());
        int hackNum = Integer.parseInt(st.nextToken());
        int securityNum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Computer[] computers = new Computer[computerNum + 1];
        computers[0] = new Computer(-1, -1);
        for (int i = 1; i < computerNum + 1; i++)
            computers[i] = new Computer(Long.parseLong(st.nextToken()), Integer.MAX_VALUE);

        List<Integer>[] graph = new ArrayList[computerNum + 1];
        for (int i = 1; i < computerNum + 1; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < networkNum; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph[S].add(E);
            graph[E].add(S);
        }

        Queue<Integer> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < securityNum; i++) {
            int node = Integer.parseInt(st.nextToken());

            computers[node].time = 0;
            queue.add(node);
        }

        while (!queue.isEmpty()) {
            int target = queue.poll();
            computers[target].money *= computers[target].time;

            for (int next : graph[target]) {
                if (computers[next].time == Integer.MAX_VALUE) {
                    computers[next].time = computers[target].time + 1;
                    queue.add(next);
                }
            }
        }

        for(int i = 1; i < computerNum + 1; i++) {
            if(computers[i].time == Integer.MAX_VALUE && computers[i].money > 0){
                System.out.print(-1);
                return;
            }
        }

        Arrays.sort(computers, Comparator.comparingLong(computer -> -computer.money));
        System.out.print(IntStream.range(0, hackNum).mapToLong(idx->computers[idx].money).sum());
    }
}