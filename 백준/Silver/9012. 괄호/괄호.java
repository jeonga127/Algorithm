import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tryNum = br.readLine();

        for(int i = 0; i < Integer.parseInt(tryNum); i++){
            Stack<Character> stack = new Stack<Character>();
            String pattern = br.readLine();
            for(int j = 0; j < pattern.length(); j++){
                if(pattern.charAt(j) == ')'){
                    if(stack.isEmpty()){
                        stack.push(')');
                        break;
                    } else stack.pop();
                }
                else stack.push('(');
            }
            if(stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
