import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int t = 0; t < T; t++) {
            PriorityQueue<Integer> descending = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순
            PriorityQueue<Integer> ascending = new PriorityQueue<>(); // 오름차순
            PriorityQueue<Integer> descendNumbers = new PriorityQueue<>(Collections.reverseOrder()); // descending 에서 삭제해야할 숫자
            PriorityQueue<Integer> ascendNumbers = new PriorityQueue<>(); // ascending 에서 삭제해야할 숙자

            int K = Integer.parseInt(br.readLine()); // Q에 적용할 연산의 개수

            for (int k = 0; k < K; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                switch (st.nextToken()) {
                    case "D":
                        if (st.nextToken().equals("1")) {
                            if (!descending.isEmpty())
                                ascendNumbers.add(descending.poll());
                        } else {
                            if (!ascending.isEmpty())
                                descendNumbers.add((ascending.poll()));
                        }
                        while (!descending.isEmpty() && descending.peek().equals(descendNumbers.peek())) {
                            descending.poll();
                            descendNumbers.poll();
                        }
                        while (!ascending.isEmpty() && ascending.peek().equals(ascendNumbers.peek())) {
                            ascending.poll();
                            ascendNumbers.poll();
                        }
                        break;
                    case "I":
                        int target = Integer.parseInt(st.nextToken());
                        descending.add(target);
                        ascending.add(target);
                        break;
                }
            }

            if (descending.isEmpty())
                sb.append("EMPTY\n");
            else sb.append(descending.poll() + " " + ascending.poll() + "\n");
        }
        System.out.print(sb);
    }
}