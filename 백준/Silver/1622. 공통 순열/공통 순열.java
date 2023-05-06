import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(sc.hasNextLine()) {
            String tmpA = sc.nextLine();
            String tmpB = sc.nextLine();

            List<String> listA = new ArrayList<>(Arrays.asList(tmpA.split("")));
            List<String> listB = new ArrayList<>(Arrays.asList(tmpB.split("")));
            List<String> answer = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();

            listA.forEach(s -> map.put(s, map.getOrDefault(s, 0) + 1));
            listB.stream().filter(s -> map.containsKey(s) && map.get(s) > 0)
                    .forEach(s -> {
                        answer.add(s);
                        map.put(s, map.get(s) - 1);
                    });
            Collections.sort(answer);
            answer.forEach(sb::append);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}