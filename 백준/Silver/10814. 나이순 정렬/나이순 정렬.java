import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Person {
    String name;
    int age;
    int idx;

    public Person(int age, String name, int idx) {
        this.age = age;
        this.name = name;
        this.idx = idx;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Person> answer = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            answer.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken(), i));
        }

        Collections.sort(answer, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.age > o2.age) return 1;
                else if (o1.age < o2.age) return -1;
                else if (o1.idx > o2.idx) return 1;
                else if (o1.idx < o2.idx) return -1;
                else return 0;
            }
        });

        answer.forEach(person -> System.out.println(person.age + " " + person.name));
    }
}