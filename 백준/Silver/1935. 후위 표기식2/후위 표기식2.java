import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int symbolNum = Integer.parseInt(bf.readLine());
        String formula = bf.readLine();
        Stack<Double> stack = new Stack<Double>();

        double[] symbolValue = new double[symbolNum];
        for(int i = 0; i <symbolNum; i++)
            symbolValue[i] = Double.parseDouble(bf.readLine());

        for(int i = 0; i < formula.length(); i++){
            switch(formula.charAt(i)){
                case '+':
                    stack.push(stack.pop() + stack.pop());
                    break;
                case '-' :
                    double tmp1 = stack.pop();
                    stack.push(stack.pop() - tmp1);
                    break;
                case '*' :
                    stack.push(stack.pop() * stack.pop());
                    break;
                case '/' :
                    double tmp2 = stack.pop();
                    stack.push(stack.pop() / tmp2);
                    break;
                default :
                    stack.push(symbolValue[(int)(formula.charAt(i)-'A')]);
                    break;
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
