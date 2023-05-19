import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int idx = 0;

        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            if (target > idx) {
               for(int j = idx + 1; j <= target; j++){
                   stack.push(j);
                   sb.append("+\n");
               }
               idx = target;
            } else if(stack.peek() != target){
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-\n");
        }

        System.out.print(sb);
    }
}