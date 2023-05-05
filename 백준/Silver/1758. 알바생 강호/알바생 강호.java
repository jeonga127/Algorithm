import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> guest = new ArrayList<>();
        for(int i = 0; i < N; i++)
            guest.add(Integer.parseInt(br.readLine()));
        Collections.sort(guest,Collections.reverseOrder()); // 손님들을 팁 크기를 기준으로 내림차순 정렬

        long answer = 0;
        for(int i = 0; i < N; i++)
            answer += guest.get(i)-i > 0 ? guest.get(i)-i : 0;
        System.out.print(answer);
    }
}