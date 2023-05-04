import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N : 도감에 수록된 포켓몬의 개수
        int M = Integer.parseInt(st.nextToken()); // M : 맞춰야 하는 문제의 개수

        Map<Integer,String> pocketmonName = new HashMap<Integer, String>();
        Map<String, Integer> poceketmonNum = new HashMap<String, Integer>();

        for(int i = 0; i < N; i++){
            String name = br.readLine();
            pocketmonName.put(i+1, name);
            poceketmonNum.put(name, i+1);
        }

        for(int i = 0; i < M; i++){
            String question = br.readLine();
            if(Pattern.matches("[A-Za-z]+", question))
                sb.append(poceketmonNum.get(question)).append("\n");
            else sb.append(pocketmonName.get(Integer.parseInt(question))).append("\n");
        }
        System.out.print(sb);
    }
}