import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        String str;

        while (!(str = br.readLine()).equals(".")) {
            stack.clear();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else if (str.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else if (str.charAt(i) == '[' || str.charAt(i) == '(' || str.charAt(i) == ')' || str.charAt(i) == ']')
                    stack.push(str.charAt(i));
            }
            sb.append(stack.isEmpty() ? "yes\n" : "no\n");
        }
        System.out.print(sb);
    }
}