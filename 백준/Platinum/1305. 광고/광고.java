import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String pattern = br.readLine();

        int prefixIndex = 0;
        int[] pi = new int[pattern.length()];
        for (int suffixIndex = 1; suffixIndex < pattern.length(); suffixIndex++) {
            while (prefixIndex > 0 && pattern.charAt(prefixIndex) != pattern.charAt(suffixIndex))
                prefixIndex = pi[prefixIndex - 1];

            if (pattern.charAt(prefixIndex) == pattern.charAt(suffixIndex))
                pi[suffixIndex] = ++prefixIndex;
        }

        System.out.print(L - pi[L - 1]);
    }
}