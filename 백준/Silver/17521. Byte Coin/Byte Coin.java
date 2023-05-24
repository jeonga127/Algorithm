import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long money = Long.parseLong(st.nextToken());

        int[] coin = new int[n];
        long coinNum = 0;

        for (int i = 0; i < n; i++)
            coin[i] = Integer.parseInt(br.readLine());

        for (int i = 0; i < n - 1; i++) {
            if (coinNum == 0 && coin[i] < coin[i + 1]) {
                coinNum = money / coin[i];
                money -= coinNum * coin[i];
            }

            if(coin[i] > coin[i+1]){
                money +=  coinNum * coin[i];
                coinNum = 0;
            }
        }

        money += coinNum * coin[n-1];
        System.out.print(money);
    }
}