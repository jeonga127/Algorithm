import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class NodeChild {
    char leftChild;
    char rightChild;

    NodeChild(char leftChild, char rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}

public class Main {
    static Map<Character, NodeChild> graph;
    static String preorderResult = "";
    static String inorderResult = "";
    static String postorderResult = "";

    static void preorder(char root) {
        preorderResult += root;

        char leftChild = graph.get(root).leftChild;
        if(leftChild != '.')
            preorder(leftChild);

        char rightChild = graph.get(root).rightChild;
        if(rightChild != '.')
            preorder(rightChild);
    }

    static void inorder(char root) {
        char leftChild = graph.get(root).leftChild;
        if(leftChild != '.')
            inorder(leftChild);

        inorderResult += root;

        char rightChild = graph.get(root).rightChild;
        if(rightChild != '.')
            inorder(rightChild);
    }

    static void postorder(char root) {
        char leftChild = graph.get(root).leftChild;
        if(leftChild != '.')
            postorder(leftChild);

        char rightChild = graph.get(root).rightChild;
        if(rightChild != '.')
            postorder(rightChild);

        postorderResult += root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드의 개수
        graph = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);

            graph.put(parent, new NodeChild(leftChild, rightChild));
        }

        preorder('A');
        inorder('A');
        postorder('A');

        System.out.println(preorderResult);
        System.out.println(inorderResult);
        System.out.print(postorderResult);
    }
}