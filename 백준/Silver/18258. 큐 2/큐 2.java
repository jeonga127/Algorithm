import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String num = bf.readLine();
        Deque<Integer> queue = new LinkedList<>();

        for(int i = 0; i < Integer.parseInt(num); i++){
            String command = bf.readLine();

            switch (command.substring(0,3)){
                case "pus" :
                    queue.offer(Integer.parseInt(command.substring(5)));
                    break;
                case "pop" :
                    int queuePoll = queue.isEmpty()? -1 : queue.poll();
                    sb.append(queuePoll).append("\n");
                    break;
                case "siz" :
                    sb.append(queue.size()).append("\n");
                    break;
                case "emp" :
                    int queueEmpty = queue.isEmpty()? 1 : 0;
                    sb.append(queueEmpty).append("\n");
                    break;
                case "fro" :
                    int queueFront = queue.isEmpty()? -1 : queue.peek();
                    sb.append(queueFront).append("\n");
                    break;
                case "bac" :
                    int queueBack = queue.isEmpty() ? -1: queue.peekLast();
                    sb.append(queueBack).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}