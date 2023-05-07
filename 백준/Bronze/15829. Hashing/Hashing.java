import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("");
        int[] arr = new int[L];

        for (int i = 0; i < L; i++)
            arr[i] = input[i].charAt(0) - 'a' + 1;

        long H = 0;
        for (int i = 0; i < L; i++) {
            H += arr[i] * Math.pow(31, i);
        }
        System.out.print(H % 1234567891);
    }
}