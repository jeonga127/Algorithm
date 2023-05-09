import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++)
            queue.add(i);

        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.print(queue.poll());
    }
}