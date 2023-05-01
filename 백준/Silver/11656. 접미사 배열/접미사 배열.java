import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();
        Set<String> suffixes = new HashSet<>();

        for(int i = 0; i < S.length(); i++){
            suffixes.add(S.substring(i));
        }

        List<String> answers = new ArrayList<>(suffixes);
        Collections.sort(answers);

        for(String s : answers)
            sb.append(s).append("\n");
        System.out.println(sb);
    }
}
