import java.util.Scanner;

class TreeNode {

    int value;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int value) {
        this.value = value;
    }
}

public class LowestCommonAncestorBST {

    static TreeNode insert(TreeNode root, int value) {

        if (root == null)
            return new TreeNode(value);

        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);
        else if (value > root.value)
            root.rightChild = insert(root.rightChild, value);

        return root;
    }

    static TreeNode lowestCommonAncestor(TreeNode root, int firstValue, int secondValue) {

        TreeNode currentNode = root;

        while (currentNode != null) {

            if (firstValue < currentNode.value && secondValue < currentNode.value)
                currentNode = currentNode.leftChild;

            else if (firstValue > currentNode.value && secondValue > currentNode.value)
                currentNode = currentNode.rightChild;

            else
                return currentNode;
        }

        return null;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeNode root = null;

        int nodeCount = scanner.nextInt();

        for (int i = 0; i < nodeCount; i++)
            root = insert(root, scanner.nextInt());

        int firstValue = scanner.nextInt();
        int secondValue = scanner.nextInt();

        TreeNode answer = lowestCommonAncestor(root, firstValue, secondValue);

        System.out.println(answer.value);
    }
}