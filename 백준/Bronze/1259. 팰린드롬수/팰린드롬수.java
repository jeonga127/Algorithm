import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringBuilder target = new StringBuilder(br.readLine());

            if(target.toString().equals("0"))
                break;

            if(target.toString().contentEquals(target.reverse()))
                sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.print(sb);
    }
}