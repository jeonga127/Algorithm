import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        Deque<Integer> forward = new ArrayDeque<>();
        Deque<Integer> backward = new ArrayDeque<>();
        int nowPage = -1;

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "B": //뒤로
                    if(!backward.isEmpty()){
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
                    forward.clear();
                    if(nowPage != -1)
                        backward.addLast(nowPage);
                    nowPage = Integer.parseInt(st.nextToken());
                    break;
                case "C": //압축
                    int before = -1;
                    int size = backward.size();

                    for(int j = 0; j < size; j++){
                        int target = backward.pollFirst();

                        if(before != target)
                            backward.addLast(target);

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