import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;

        int testcase = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < testcase; i++){
            String tmp = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            for(int j = 0; j < tmp.length(); j++){
                char ref = tmp.charAt(j);
                if(!stack.empty() && stack.peek() == ref)
                    stack.pop();
                else stack.push(ref);
            }
            if(stack.empty())
                cnt++;
        }

        System.out.println(cnt);
    }
}
