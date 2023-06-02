import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (--T >= 0) {
            String command = br.readLine();
            List<Character> list = new LinkedList<>();
            int cursor = 0;

            for (int i = 0; i < command.length(); i++) {
                switch (command.charAt(i)) {
                    case '<':
                        cursor = cursor > 0 ? cursor - 1 : 0;
                        break;
                    case '>':
                        cursor = cursor < list.size() ? cursor + 1 : list.size();
                        break;
                    case '-':
                        if(cursor > 0)
                            list.remove(--cursor);
                        break;
                    default:
                        list.add(cursor++, command.charAt(i));
                        break;
                }
            }
            String result = list.stream().map(String::valueOf).collect(Collectors.joining());
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}