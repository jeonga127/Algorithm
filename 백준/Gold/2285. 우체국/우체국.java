import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Town2 implements Comparable<Town2> {
    int num;
    int people;

    Town2(int num, int people) {
        this.num = num;
        this.people = people;
    }

    @Override
    public int compareTo(Town2 o) {
        return Integer.compare(this.num, o.num);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Town2> townInfo = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            townInfo.add(new Town2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        long total = townInfo.stream().mapToLong(x -> x.people).sum();
        long sum = 0;

        Collections.sort(townInfo);
        for(Town2 town : townInfo){
            sum += town.people;

            if(sum >= (total+1)/2){
                System.out.print(town.num);
                break;
            }
        }
    }
}