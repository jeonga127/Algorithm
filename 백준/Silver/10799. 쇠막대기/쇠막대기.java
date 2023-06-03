import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();

        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == '(')
                stack.push('(');

            if (command.charAt(i) == ')') {
                stack.pop();

                if(command.charAt(i-1) == '(')
                    answer += stack.size();
                else answer += 1;
            }
        }
        System.out.print(answer);
    }
}