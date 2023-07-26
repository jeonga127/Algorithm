import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 웹페이지 종류의 수
        int Q = Integer.parseInt(st.nextToken()); // 작업의 수
        int C = Integer.parseInt(st.nextToken()); // 최대 캐시 용량

        Map<Integer, Integer> cashSize = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++)
            cashSize.put(i, Integer.parseInt(st.nextToken()));

        Deque<Integer> forward = new ArrayDeque<>();
        Deque<Integer> backward = new ArrayDeque<>();
        int nowPage = -1;
        int usedCash = 0;

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "B": //뒤로
                    if(!backward.isEmpty()) {
                        forward.addFirst(nowPage);
                        nowPage = backward.pollLast();
                    }
                    break;
                case "F": //앞으로
                    if(!forward.isEmpty()){
                        backward.addLast(nowPage);
                        nowPage = forward.pollFirst();
                    }
                    break;
                case "A": //접속
                    while(!forward.isEmpty())
                        usedCash -= cashSize.get(forward.poll());

                    if(nowPage != -1) backward.addLast(nowPage);
                    nowPage = Integer.parseInt(st.nextToken());
                    usedCash +=  cashSize.get(nowPage);

                    while(usedCash > C)
                        usedCash -= cashSize.get(backward.pollFirst());
                    break;
                case "C": //압축
                    int before = -1;
                    int size = backward.size();

                    for(int j = 0; j < size; j++){
                        int target = backward.pollFirst();

                        if(before == target)
                            usedCash -= cashSize.get(target);
                        else backward.addLast(target);

                        before = target;
                    }
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(nowPage).append("\n");

        if(backward.isEmpty()) sb.append(-1);
        while(!backward.isEmpty())
            sb.append(backward.pollLast()).append(" ");
        sb.append("\n");

        if(forward.isEmpty()) sb.append(-1);
        while(!forward.isEmpty())
            sb.append(forward.pollFirst()).append(" ");

        System.out.print(sb);
    }
}