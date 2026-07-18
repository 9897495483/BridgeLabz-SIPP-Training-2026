import java.util.Scanner;

class TreeNode {

    int value;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int value) {
        this.value = value;
    }
}

public class ValidateBST {

    static TreeNode insert(TreeNode root, int value) {

        if (root == null)
            return new TreeNode(value);

        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);
        else if (value > root.value)
            root.rightChild = insert(root.rightChild, value);

        return root;
    }

    static boolean validate(TreeNode root, long minimumValue, long maximumValue) {

        if (root == null)
            return true;

        if (root.value <= minimumValue || root.value >= maximumValue)
            return false;

        return validate(root.leftChild, minimumValue, root.value)
                && validate(root.rightChild, root.value, maximumValue);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeNode root = null;

        System.out.print("Enter number of nodes: ");

        int nodeCount = scanner.nextInt();

        for (int i = 0; i < nodeCount; i++)
            root = insert(root, scanner.nextInt());

        System.out.println(validate(root, Long.MIN_VALUE, Long.MAX_VALUE));
    }
}