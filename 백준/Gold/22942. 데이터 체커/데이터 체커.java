import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer,Character> map = new TreeMap<>();
        Stack<Character> stack = new Stack<>();
        int N = Integer.parseInt(bf.readLine());

        // X-R : 원의 시작 좌표 & X+R : 원의 종료 좌표
        for (int i = 0; i < N; i++) {
            String[] tmpInfo = bf.readLine().split(" ");
            int X = Integer.parseInt(tmpInfo[0]);
            int R = Integer.parseInt(tmpInfo[1]);

            if(map.containsKey(X-R) || map.containsKey(X+R)){
                System.out.println("NO");
                return;
            }
            map.put(X-R, (char)('A'+ i));
            map.put(X+R, (char)('A'+ i));
        }

        for(Integer i: map.keySet()){
            if(!stack.isEmpty() && stack.peek().equals(map.get(i))){
                stack.pop();
            } else stack.push(map.get(i));
        }
        
        if(stack.isEmpty())
            System.out.println("YES");
        else System.out.println("NO");
    }
}
