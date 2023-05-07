import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean isConstructor(int num, int target) {
        int result = num;
        for (int i = (int) Math.log10(num); i >= 0; i--) {
            int tmp = num / (int) Math.pow(10, i);
            result += tmp;
            num -= tmp * Math.pow(10, i);
        }
        return result == target;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int start = N - 9 * ((int) Math.log(N) + 1);

        for(int i = start; i < N; i++){
            if(isConstructor(i, N)){
                System.out.print(i);
                return;
            }
        }
        System.out.print(0);
    }
}