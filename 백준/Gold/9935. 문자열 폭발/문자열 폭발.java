import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String bomb = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            sb.append(target.charAt(i));

            if (sb.length() >= bomb.length() && target.charAt(i) == bomb.charAt(bomb.length() - 1)) {
                boolean isSame = true;

                for(int j = 0; j < bomb.length(); j++){
                    if(sb.charAt(sb.length() - bomb.length() + j) != bomb.charAt(j)){
                        isSame = false;
                        break;
                    }
                }

                if (isSame)
                    sb.delete(sb.length() - bomb.length(), sb.length());
            }
        }

        System.out.print(sb.length() == 0 ? "FRULA" : sb);
    }
}