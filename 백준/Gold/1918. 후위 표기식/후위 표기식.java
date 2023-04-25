import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> operator = new Stack<Character>();
        String formula = bf.readLine();

        for (int i = 0; i < formula.length(); i++) {
            char target = formula.charAt(i);
            switch (target) {
                case '+': case '-':
                    while(!operator.isEmpty() && operator.peek() != '('){
                        sb.append(operator.pop());
                    }
                    operator.push(target);
                    break;
                case '*': case '/':
                    while(!operator.isEmpty() && (operator.peek() == '*' || operator.peek() == '/')){
                        sb.append(operator.pop());
                    }
                    operator.push(target);
                    break;
                case '(':
                    operator.push(target);
                    break;
                case ')':
                    while (operator.peek() != '(')
                        sb.append(operator.pop());
                    operator.pop();
                    break;
                default: // target이 문자(피연산자)인 경우
                    sb.append(target);
                    break;

            }
        }

        while (!operator.isEmpty()) // 미처 출력되지 않은 연산자 출력
            sb.append(operator.pop());
        System.out.print(sb);
    }
}
