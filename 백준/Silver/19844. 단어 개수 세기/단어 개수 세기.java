import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("[\\s-]");
        int answer = input.length;

        for(String i : input){
            if(Pattern.matches("^(c|j|n|m|t|s|l|d|qu)(')(a|e|i|o|u|h).*", i))
                answer ++;
        }
        System.out.print(answer);
    }
}
