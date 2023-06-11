import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 수열의 크기
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> answer = new Stack<>();
        int idx = N-1;
        while (idx >= 0) {
            int target = arr[idx];

            if(stack.isEmpty() || stack.peek() > target){
                answer.push(stack.isEmpty()? -1 : stack.peek());
                idx -= 1;
            } else {
                stack.pop();
                continue;
            }
            stack.push(target);
        }

        while(!answer.isEmpty())
            sb.append(answer.pop() + " ");
        System.out.print(sb);
    }
}