import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node {
    Node leftNode;
    Node rightNode;
    int value;

    Node(int value) {
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }
}

class BinarySearchTree {
    Node root;

    void insert(int value) {
        root = insertNode(root, value);
    }

    Node insertNode(Node parent, int value) {
        if (parent == null)
            return new Node(value);

        if (value < parent.value)
            parent.leftNode = insertNode(parent.leftNode, value);

        if (value > parent.value)
            parent.rightNode = insertNode(parent.rightNode, value);

        return parent;
    }

    StringBuilder postOrder(Node root, StringBuilder sb){
        if(root != null){
            postOrder(root.leftNode, sb);
            postOrder(root.rightNode, sb);
            sb.append(root.value).append("\n");
        }
        return sb;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinarySearchTree bst = new BinarySearchTree();
        String tmp;

        while ((tmp = br.readLine()) != null && !tmp.isEmpty())
            bst.insert(Integer.parseInt(tmp));
        System.out.print(bst.postOrder(bst.root, new StringBuilder()));
    }
}