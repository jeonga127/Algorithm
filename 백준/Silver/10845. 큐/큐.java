import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push" :
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    sb.append(queue.isEmpty()? -1 : (queue.pop())).append("\n");
                    break;
                case "size" :
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty" :
                    sb.append(queue.isEmpty()? 1: 0).append("\n");
                    break;
                case "front" :
                    sb.append(queue.isEmpty()? -1 : queue.peek()).append("\n");
                    break;
                case "back" :
                    sb.append(queue.isEmpty()? -1 : queue.peekLast()).append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}