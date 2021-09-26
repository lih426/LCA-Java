
// test
import java.util.*;

public class BinaryTree {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static TreeNode lowestCommonAncestorForBinarySearchTree(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null)
            return null;
        ;
        if (root.data > a.data && root.data > b.data) {
            return lowestCommonAncestorForBinarySearchTree(root.left, a, b);
        } else if (root.data < a.data && root.data < b.data) {
            return lowestCommonAncestorForBinarySearchTree(root.right, a, b);
        }
        // if you reach at this place, then it is LCA for given two nodes because a and
        // b are on either side of root.
        return root;

    }

    public static TreeNode LCAItr(TreeNode root, TreeNode a, TreeNode b) {
        while (root != null) {
            if (root.data > a.data && root.data > b.data) {
                root = root.left;
            } else if (root.data < a.data && root.data < b.data) {
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTree bi = new BinaryTree();
        // Creating a binary tree
        TreeNode rootNode = createBinaryTree();
        System.out.println("Lowest common ancestor for node 5 and 30 using Recursion:");
        TreeNode node5 = new TreeNode(5);
        TreeNode node30 = new TreeNode(30);
        System.out.println(lowestCommonAncestorForBinarySearchTree(rootNode, node5, node30).data);

        System.out.println("Lowest common ancestor for node 5 and 30 using Iteration:");
        System.out.println(LCAItr(rootNode, node5, node30).data);

    }

    public static TreeNode createBinaryTree() {

        TreeNode rootNode = new TreeNode(40);
        TreeNode node20 = new TreeNode(20);
        TreeNode node10 = new TreeNode(10);
        TreeNode node30 = new TreeNode(30);
        TreeNode node60 = new TreeNode(60);
        TreeNode node50 = new TreeNode(50);
        TreeNode node70 = new TreeNode(70);
        TreeNode node5 = new TreeNode(5);
        TreeNode node45 = new TreeNode(45);
        TreeNode node55 = new TreeNode(55);

        rootNode.left = node20;
        rootNode.right = node60;

        node20.left = node10;
        node20.right = node30;

        node60.left = node50;
        node60.right = node70;

        node10.left = node5;
        node50.right = node55;
        return rootNode;
    }
}