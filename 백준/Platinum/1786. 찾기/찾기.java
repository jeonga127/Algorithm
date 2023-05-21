import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String text = br.readLine();
        String pattern = br.readLine();

        int[] pi = getPi(pattern);
        int idx = 0;
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            while (idx > 0 && text.charAt(i) != pattern.charAt(idx))
                idx = pi[idx - 1];

            if (text.charAt(i) == pattern.charAt(idx)) {
                if (idx == pattern.length() - 1) {
                    sb.append(i - idx + 1).append(" ");
                    idx = pi[idx];
                    count++;
                } else idx++;
            }
        }

        System.out.println(count);
        System.out.print(sb);
    }

    private static int[] getPi(String pattern) {
        int[] pi = new int[pattern.length()];
        int prefixIndex = 0;

        for (int suffixIndex = 1; suffixIndex < pattern.length(); suffixIndex++) {
            while (prefixIndex > 0 && pattern.charAt(suffixIndex) != pattern.charAt(prefixIndex))
                prefixIndex = pi[prefixIndex - 1];

            if (pattern.charAt(suffixIndex) == pattern.charAt(prefixIndex))
                pi[suffixIndex] = ++prefixIndex;
        }

        return pi;
    }
}