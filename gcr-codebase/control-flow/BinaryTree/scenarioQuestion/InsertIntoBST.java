import java.util.Scanner;

class TreeNode {
    int value;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int value) {
        this.value = value;
    }
}

public class InsertIntoBST {

    static TreeNode insert(TreeNode root, int value) {

        if (root == null)
            return new TreeNode(value);

        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);
        else if (value > root.value)
            root.rightChild = insert(root.rightChild, value);

        return root;
    }

    static void inorder(TreeNode root) {

        if (root == null)
            return;

        inorder(root.leftChild);
        System.out.print(root.value + " ");
        inorder(root.rightChild);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeNode root = null;

        System.out.print("Enter initial number of nodes: ");
        int nodeCount = scanner.nextInt();

        System.out.println("Enter values:");

        for (int i = 0; i < nodeCount; i++)
            root = insert(root, scanner.nextInt());

        System.out.print("Enter new value: ");
        int newValue = scanner.nextInt();

        root = insert(root, newValue);

        System.out.println("BST after insertion:");

        inorder(root);
    }
}