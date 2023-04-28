import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 듣도 못한 사람의 수
        int M = Integer.parseInt(input[1]); // 보도 못한 사람의 수

        Set<String> firstHear = new HashSet<>();
        Set<String> firstSee = new HashSet<>();

        for(int i = 0; i < N; i++)
            firstHear.add(br.readLine());

        for(int i = 0; i < M; i++)
            firstSee.add(br.readLine());

        firstHear.retainAll(firstSee);
        List<String> answer = new ArrayList<>(firstHear);
        Collections.sort(answer);

        sb.append(answer.size()).append("\n");
        for(int i = 0; i < answer.size(); i++)
            sb.append(answer.get(i)).append("\n");
        System.out.print(sb);
    }
}
