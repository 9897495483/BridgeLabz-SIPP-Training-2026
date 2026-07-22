import java.util.*;

class TreeNode {

    int value;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int value) {
        this.value = value;
    }
}

public class FolderDeletionTraversal {

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

    static void deleteFolderTree(TreeNode currentNode) {

        if (currentNode == null)
            return;

        deleteFolderTree(currentNode.leftChild);

        deleteFolderTree(currentNode.rightChild);

        System.out.print(currentNode.value + " ");
    }

    public static void main(String[] args) {

        TreeNode root = buildTree();

        deleteFolderTree(root);
    }
}