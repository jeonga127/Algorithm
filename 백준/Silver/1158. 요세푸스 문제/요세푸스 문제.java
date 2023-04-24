import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        List<Integer> answer = new ArrayList<>();
        int idx = 0;

        for(int i = 0; i < N; i++)
            queue.offer(i+1);

        while(!queue.isEmpty()){
            idx ++;
            int tmp = queue.poll();
            if(idx == K){
                answer.add(tmp);
                idx = 0;
            }
            else queue.offer(tmp);
        }

        System.out.print("<");
        for(int i = 0; i < N; i++) {
            System.out.print(answer.get(i));
            if(i == N-1) System.out.print(">");
            else System.out.print(", ");
        }
    }
}
