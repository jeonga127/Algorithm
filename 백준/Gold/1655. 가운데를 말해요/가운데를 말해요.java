import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 정수의 개수

        PriorityQueue<Integer> front = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> end = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());

            if(front.size() != end.size())
                end.add(target);
            else front.add(target);

            if(!front.isEmpty() && !end.isEmpty() && front.peek() > end.peek()){
                int frontPeek = front.poll();
                int endPeek = end.poll();

                front.add(endPeek);
                end.add(frontPeek);
            }

            if(front.size() == end.size())
                sb.append(Math.min(front.peek(), end.peek())).append("\n");
            else sb.append(front.peek()).append("\n");
        }
        System.out.print(sb);
    }
}