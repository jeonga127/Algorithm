import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine()); // 카드의 개수

        for (int i = 0; i < N; i++)
            queue.add(Integer.parseInt(br.readLine()));

        int answer = 0;
        while(!queue.isEmpty()){
            if(queue.size() == 1)
                break;

            int tmp = queue.poll() + queue.poll();
            answer += tmp;
            queue.add(tmp);
        }
        System.out.print(answer);
    }
}