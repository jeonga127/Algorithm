import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String word;
    static int[] wordToInt;
    static boolean[] activeIdx;

    public static void find(int startIdx, int endIdx) {
        if (startIdx >= endIdx) return;

        StringBuilder tmpSb = new StringBuilder();

        int min = Arrays.stream(wordToInt, startIdx, endIdx).min().orElse(-1);
        int minIdx = IntStream.range(startIdx, endIdx).filter(i -> wordToInt[i] == min).findFirst().orElse(-1);
        activeIdx[minIdx] = true;

        IntStream.range(0, activeIdx.length).filter(i -> activeIdx[i]).forEach(i -> tmpSb.append(word.charAt(i)));
        sb.append(tmpSb).append("\n");

        find(minIdx + 1, endIdx);
        find(startIdx, minIdx);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        wordToInt = word.chars().map(x -> (int) x - 'A').toArray();
        activeIdx = new boolean[word.length()];

        find(0, wordToInt.length);
        System.out.print(sb);
    }
}