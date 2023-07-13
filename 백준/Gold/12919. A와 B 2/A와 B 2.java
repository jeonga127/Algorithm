import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean success = false;

    public static void bruteForce(StringBuilder current, String target) {
        if (current.length() == target.length() && (current.toString()).equals(target)) {
            success = true;
            return;
        }

        if (current.length() <= target.length())
            return;

        StringBuilder copy = new StringBuilder(current);

        if (current.charAt(current.length() - 1) == 'A') {
            current.deleteCharAt(current.length() - 1);
            bruteForce(current, target);
        }

        if(current.charAt(0) == 'B'){
            copy.deleteCharAt(0).reverse();
            bruteForce(copy, target);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String goal = br.readLine();

        StringBuilder goalToSB = new StringBuilder(goal);
        bruteForce(goalToSB, target);

        System.out.print(success ? 1 : 0);
    }
}