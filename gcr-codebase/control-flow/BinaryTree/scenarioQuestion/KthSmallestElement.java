import java.util.*;

class TreeNode {

    int value;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int value) {
        this.value = value;
    }
}

public class KthSmallestElement {

    static TreeNode insert(TreeNode root, int value) {

        if (root == null)
            return new TreeNode(value);

        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);
        else if (value > root.value)
            root.rightChild = insert(root.rightChild, value);

        return root;
    }

    static int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode currentNode = root;

        int count = 0;

        while (currentNode != null || !stack.isEmpty()) {

            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.leftChild;
            }

            currentNode = stack.pop();

            count++;

            if (count == k)
                return currentNode.value;

            currentNode = currentNode.rightChild;
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeNode root = null;

        int nodeCount = scanner.nextInt();

        for (int i = 0; i < nodeCount; i++)
            root = insert(root, scanner.nextInt());

        int k = scanner.nextInt();

        System.out.println(kthSmallest(root, k));
    }
}