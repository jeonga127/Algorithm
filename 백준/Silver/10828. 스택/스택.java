import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String num = bf.readLine();
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < Integer.parseInt(num); i++){
            String[] command = bf.readLine().split(" ");

            switch (command[0]){
                case "push" :
                    stack.push(Integer.parseInt(command[1]));
                    break;
                case "pop" :
                    int stackPop = stack.isEmpty() ? -1 : stack.pop();
                    System.out.println(stackPop);
                    break;
                case "size" :
                    System.out.println(stack.size());
                    break;
                case "empty" :
                    int stackIsEmpty = stack.isEmpty() ? 1 : 0;
                    System.out.println(stackIsEmpty);
                    break;
                case "top" :
                    int stackTop = stack.isEmpty() ? -1 : stack.peek();
                    System.out.println(stackTop);
                    break;
            }
        }
    }
}