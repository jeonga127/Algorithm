import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        String[] target = String.valueOf(A * B * C).split("");

        int[] input = new int[10];
        for (int i = 0; i < target.length; i++)
            input[Integer.parseInt(target[i])] += 1;
        for (int i = 0; i < 10; i++)
            System.out.println(input[i]);
    }
}