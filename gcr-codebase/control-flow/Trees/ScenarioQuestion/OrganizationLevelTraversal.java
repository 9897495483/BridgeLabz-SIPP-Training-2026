import java.util.*;

class TreeNode {

    int value;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int value) {
        this.value = value;
    }
}

public class OrganizationLevelTraversal {

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

    static List<List<Integer>> levelOrderTraversal(TreeNode root) {

        List<List<Integer>> levels = new ArrayList<>();

        if (root == null)
            return levels;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int currentLevelSize = queue.size();

            List<Integer> currentLevel = new ArrayList<>();

            for (int index = 0; index < currentLevelSize; index++) {

                TreeNode currentNode = queue.poll();

                currentLevel.add(currentNode.value);

                if (currentNode.leftChild != null)
                    queue.offer(currentNode.leftChild);

                if (currentNode.rightChild != null)
                    queue.offer(currentNode.rightChild);
            }

            levels.add(currentLevel);
        }

        return levels;
    }

    public static void main(String[] args) {

        TreeNode root = buildTree();

        System.out.println(levelOrderTraversal(root));
    }
}