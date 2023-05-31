import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        while (--T >= 0) {
            String p = br.readLine(); // 수행할 함수
            int n = Integer.parseInt(br.readLine()); // 배열의 크기
            boolean isError = false;
            boolean isLeft = true;

            String text = br.readLine();
            String[] arrText = text.substring(1, text.length() - 1).split(",");
            Deque<String> queue = new ArrayDeque<>();


            for(int i = 0; i < arrText.length; i++) {
                if(!arrText[i].equals(""))
                    queue.add(arrText[i]);
            }

            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'D' && queue.isEmpty()) {
                    sb.append("error\n");
                    isError = true;
                    break;
                }

                if (p.charAt(i) == 'D'){
                    if(isLeft) queue.pollFirst();
                    else queue.pollLast();
                }

                if (p.charAt(i) == 'R')
                    isLeft = !isLeft;
            }

            if(!isError){
                sb.append("[");
                if(isLeft) {
                    while (!queue.isEmpty()) {
                        sb.append(queue.pollFirst());
                        if (queue.size() >= 1) sb.append(",");
                    }
                } else {
                    while (!queue.isEmpty()) {
                        sb.append(queue.pollLast());
                        if (queue.size() >= 1) sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb);
    }
}