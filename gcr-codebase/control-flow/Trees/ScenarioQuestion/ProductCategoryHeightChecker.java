import java.util.*;

class TreeNode {

    int value;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int value) {
        this.value = value;
    }
}

public class ProductCategoryHeightChecker {

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

    static int findHeight(TreeNode currentNode) {

        if (currentNode == null)
            return -1;

        int leftHeight = findHeight(currentNode.leftChild);

        int rightHeight = findHeight(currentNode.rightChild);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {

        TreeNode root = buildTree();

        System.out.print("Enter threshold: ");

        int threshold = scanner.nextInt();

        int height = findHeight(root);

        System.out.println("Height = " + height);

        System.out.println(height > threshold);
    }
}