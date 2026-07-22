import java.util.*;

class TreeNode {

    int value;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int value) {
        this.value = value;
    }
}

public class SortedLeaderboardTraversal {

    static Scanner scanner = new Scanner(System.in);

    public static TreeNode buildTree() {

        int value = scanner.nextInt();

        if (value == -1) {
            return null;
        }

        TreeNode currentNode = new TreeNode(value);

        currentNode.leftChild = buildTree();
        currentNode.rightChild = buildTree();

        return currentNode;
    }

    public static void inorderTraversal(TreeNode currentNode,
                                        List<Integer> sortedScores) {

        if (currentNode == null) {
            return;
        }

        inorderTraversal(currentNode.leftChild, sortedScores);

        sortedScores.add(currentNode.value);

        inorderTraversal(currentNode.rightChild, sortedScores);
    }

    public static void main(String[] args) {

        System.out.println("Enter tree in preorder (-1 for null):");

        TreeNode root = buildTree();

        List<Integer> sortedScores = new ArrayList<>();

        inorderTraversal(root, sortedScores);

        System.out.println(sortedScores);
    }
}