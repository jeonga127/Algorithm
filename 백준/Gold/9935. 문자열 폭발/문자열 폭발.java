import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();
        Stack<Character> temp = new Stack<>();

        for (int i = 0; i < target.length(); i++) {
            stack.push(target.charAt(i));

            if (stack.size() >= bomb.length() && target.charAt(i) == bomb.charAt(bomb.length() - 1)) {
                boolean isSame = true;

                for (int j = bomb.length() - 1; j >= 0; j--) {
                    temp.push(stack.pop());

                    if (temp.peek() != bomb.charAt(j)) {
                        isSame = false;
                        break;
                    }
                }

                if (!isSame) {
                    while (!temp.isEmpty())
                        stack.push(temp.pop());
                } else temp.clear();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());

        System.out.print(sb.length() == 0 ? "FRULA" : sb.reverse());
    }
}