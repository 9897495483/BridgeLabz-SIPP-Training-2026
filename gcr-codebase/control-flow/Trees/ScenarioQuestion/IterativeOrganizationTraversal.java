import java.util.*;

class TreeNode {

    int value;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int value) {
        this.value = value;
    }
}

public class IterativeOrganizationTraversal {

    static Scanner scanner = new Scanner(System.in);

    static TreeNode buildTree() {

        int value = scanner.nextInt();

        if (value == -1)
            return null;

        TreeNode node = new TreeNode(value);

        node.leftChild = buildTree();
        node.rightChild = buildTree();

        return node;
    }

    static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> traversal = new ArrayList<>();

        if (root == null)
            return traversal;

        Stack<TreeNode> nodeStack = new Stack<>();

        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {

            TreeNode currentNode = nodeStack.pop();

            traversal.add(currentNode.value);

            if (currentNode.rightChild != null)
                nodeStack.push(currentNode.rightChild);

            if (currentNode.leftChild != null)
                nodeStack.push(currentNode.leftChild);
        }

        return traversal;
    }

    public static void main(String[] args) {

        TreeNode root = buildTree();

        System.out.println(preorderTraversal(root));
    }
}