import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int target = 666;
        int idx = 0;

        while(true){
            if(Integer.toString(target).contains("666")){
                idx++;
                if(idx == N){
                    System.out.print(target);
                    break;
                }
            }
            target++;
        }
    }
}