import java.util.*;

class TreeNode {

    int value;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int value) {
        this.value = value;
    }
}

public class OrganizationDiameterCalculator {

    static Scanner scanner = new Scanner(System.in);

    static int maximumDiameter = 0;

    static TreeNode buildTree() {

        int value = scanner.nextInt();

        if (value == -1)
            return null;

        TreeNode node = new TreeNode(value);

        node.leftChild = buildTree();
        node.rightChild = buildTree();

        return node;
    }

    static int calculateHeight(TreeNode currentNode) {

        if (currentNode == null)
            return -1;

        int leftHeight = calculateHeight(currentNode.leftChild);

        int rightHeight = calculateHeight(currentNode.rightChild);

        maximumDiameter = Math.max(maximumDiameter,
                leftHeight + rightHeight + 2);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {

        TreeNode root = buildTree();

        calculateHeight(root);

        System.out.println(maximumDiameter);
    }
}