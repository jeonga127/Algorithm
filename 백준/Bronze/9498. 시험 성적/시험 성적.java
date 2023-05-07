import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int score = Integer.parseInt(br.readLine());

        if(score >= 90 && score <= 100) sb.append("A");
        else if(score >= 80 && score <= 89) sb.append("B");
        else if(score >= 70 && score <= 79) sb.append("C");
        else if(score >= 60 && score <= 69) sb.append("D");
        else sb.append("F");
        System.out.print(sb);
    }
}