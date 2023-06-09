import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class NodeChild2 {
    int leftChild;
    int rightChild;

    NodeChild2(int leftChild, int rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}

public class Main {
    static NodeChild2[] graph;
    static int endPoint;
    static int count = -1;

    static void inorder(int root){
        int leftChild = graph[root].leftChild;
        if (leftChild != -1)
            inorder(leftChild);

        endPoint = root;

        int rightChild = graph[root].rightChild;
        if (rightChild != -1)
            inorder(rightChild);
    }

    static boolean similarInorder(int root) {
        count++;

        int leftChild = graph[root].leftChild;
        if (leftChild != -1) {
            if(similarInorder(leftChild))
                count++;
            else return false;
        }

        int rightChild = graph[root].rightChild;
        if (rightChild != -1) {
            if (similarInorder(rightChild))
                count++;
            else return false;
        }

        return root != endPoint;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new NodeChild2[N + 1];

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int leftChild = Integer.parseInt(st.nextToken());
            int rightChild = Integer.parseInt(st.nextToken());

            graph[parent] = new NodeChild2(leftChild, rightChild);
        }

        inorder(1);
        similarInorder(1);
        System.out.print(count);
    }
}