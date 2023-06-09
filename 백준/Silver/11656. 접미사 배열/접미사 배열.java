import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();
        List<String> suffixes = new ArrayList<>();

        for(int i = 0; i < S.length(); i++){
            suffixes.add(S.substring(i));
        }

        Collections.sort(suffixes);

        for(String s : suffixes)
            sb.append(s).append("\n");
        System.out.println(sb);
    }
}
