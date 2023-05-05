import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] rope = new int[N];

        for(int i = 0; i < N; i++)
            rope[i] = Integer.parseInt(br.readLine());
        Arrays.sort(rope);

        // 가장 값이 큰 rope는 무조건 사용한다고 가정하고 최대 중량을 계산
        int max = rope[N-1];
        for(int i = 2; i <= N; i++)
            max = Math.max(max, rope[N-i] * i);
        System.out.print(max);
    }
}
