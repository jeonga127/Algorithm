import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Town implements Comparable<Town>{
    int num;
    int people;

    Town(int num, int people){
        this.num = num;
        this.people = people;
    }

    @Override
    public int compareTo(Town o) {
        return Integer.compare(this.num, o.num);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Town> townInfo = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            townInfo.add(new Town(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        long total = townInfo.stream().mapToLong(x->x.people).sum();
        long sum = 0;

        Collections.sort(townInfo);
        for (Town town : townInfo) {
            sum += town.people;

            if (sum >= (total + 1) / 2) {
                System.out.print(town.num);
                break;
            }
        }
    }
}