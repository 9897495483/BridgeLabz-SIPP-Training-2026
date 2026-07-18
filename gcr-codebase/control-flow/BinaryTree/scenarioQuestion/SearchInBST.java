import java.util.Scanner;

class TreeNode {
    int value;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int value) {
        this.value = value;
    }
}

public class SearchInBST {

    static TreeNode insert(TreeNode root, int value) {
        if (root == null)
            return new TreeNode(value);

        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);
        else if (value > root.value)
            root.rightChild = insert(root.rightChild, value);

        return root;
    }

    static boolean search(TreeNode root, int target) {
        TreeNode currentNode = root;

        while (currentNode != null) {
            if (currentNode.value == target)
                return true;

            if (target < currentNode.value)
                currentNode = currentNode.leftChild;
            else
                currentNode = currentNode.rightChild;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeNode root = null;

        System.out.print("Enter number of nodes: ");
        int numberOfNodes = scanner.nextInt();

        System.out.println("Enter node values:");

        for (int i = 0; i < numberOfNodes; i++) {
            root = insert(root, scanner.nextInt());
        }

        System.out.print("Enter value to search: ");
        int targetValue = scanner.nextInt();

        if (search(root, targetValue))
            System.out.println("Value Found");
        else
            System.out.println("Value Not Found");
    }
}