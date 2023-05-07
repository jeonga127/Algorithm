import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> map = new HashMap<>();
        String input = br.readLine().toUpperCase();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);
            map.put(target, map.getOrDefault(target, 0) + 1);
            max = Math.max(max, map.get(target));
        }

        char answer = ' ';
        for (char c : map.keySet()) {
            if (map.get(c).equals(max))
                answer = answer == ' ' ? c : '?';
        }
        System.out.print(answer);
    }
}