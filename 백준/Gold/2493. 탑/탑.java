import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Tower {
    int idx;
    int value;

    Tower(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] towers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Tower> stack = new Stack<>();

        for (int i = 0; i < N; i++)
            towers[i] = Integer.parseInt(st.nextToken());

        int idx = 0;
        while (idx < N) {
            int target = towers[idx];

            if (stack.isEmpty() || stack.peek().value > target) {
                sb.append(stack.isEmpty() ? 0 : stack.peek().idx).append(" ");
                idx += 1;
            } else {
                stack.pop();
                continue;
            }

            stack.push(new Tower(idx, target));
        }

        System.out.print(sb);
    }
}