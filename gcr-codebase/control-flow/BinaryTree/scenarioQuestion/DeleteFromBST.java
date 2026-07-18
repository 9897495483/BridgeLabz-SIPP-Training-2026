import java.util.Scanner;

class TreeNode {

    int value;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int value) {
        this.value = value;
    }
}

public class DeleteFromBST {

    static TreeNode insert(TreeNode root, int value) {

        if (root == null)
            return new TreeNode(value);

        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);
        else if (value > root.value)
            root.rightChild = insert(root.rightChild, value);

        return root;
    }

    static TreeNode delete(TreeNode root, int value) {

        if (root == null)
            return null;

        if (value < root.value)
            root.leftChild = delete(root.leftChild, value);

        else if (value > root.value)
            root.rightChild = delete(root.rightChild, value);

        else {

            if (root.leftChild == null)
                return root.rightChild;

            if (root.rightChild == null)
                return root.leftChild;

            TreeNode successor = root.rightChild;

            while (successor.leftChild != null)
                successor = successor.leftChild;

            root.value = successor.value;

            root.rightChild = delete(root.rightChild, successor.value);
        }

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

        System.out.print("Enter number of nodes: ");
        int nodeCount = scanner.nextInt();

        System.out.println("Enter values:");

        for (int i = 0; i < nodeCount; i++)
            root = insert(root, scanner.nextInt());

        System.out.print("Enter value to delete: ");
        int value = scanner.nextInt();

        root = delete(root, value);

        inorder(root);
    }
}