package leetcode.depthfirstsearch;


import leetcode.binarytree.TreeNode;

import java.util.Stack;

/**
 *
 */
public class Info {
    public static void main(String[] args) {

    }

    //Preorder Traversal
    public void traversePreOrder(TreeNode node) {
        if (node != null) {
            //visit(node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    //Preorder Traversal without recursion
    public void traversePreOrderWithoutRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>(); // A stack follows a LIFO (Last In First Out) order
        TreeNode current = root;
        stack.push(root);
        while(!stack.isEmpty()) {
            current = stack.pop();
            //visit(current.value);

            if(current.right != null) {
                stack.push(current.right);
            }
            if(current.left != null) {
                stack.push(current.left);
            }
        }
    }

    // Inorder Traversal
    public void traverseInOrder(TreeNode node) {
        if (node != null) {
            traverseInOrder(node.left);
            //visit(node.value);
            traverseInOrder(node.right);
        }
    }


    // Inorder Traversal without recursion
    public void traverseInOrderWithoutRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            TreeNode top = stack.pop();
            //visit(top.value);
            current = top.right;
        }
    }

    // Postorder Traversal
    public void traversePostOrder(TreeNode node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            //visit(node.value);
        }
    }

    // Postorder Traversal without recursion
    public void traversePostOrderWithoutRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = root;
        TreeNode current = root;
        stack.push(root);

        while (!stack.isEmpty()) {
            current = stack.peek();
            boolean hasChild = (current.left != null || current.right != null);
            boolean isPrevLastChild = (prev == current.right ||
                    (prev == current.left && current.right == null));

            if (!hasChild || isPrevLastChild) {
                current = stack.pop();
                //visit(current.value);
                prev = current;
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }
    }

}
