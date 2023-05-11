import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            int target = Integer.parseInt(br.readLine());
            if(target == 0) stack.pop();
            else stack.add(target);
        }

        System.out.print(stack.stream().mapToInt(i->i).sum());
    }
}