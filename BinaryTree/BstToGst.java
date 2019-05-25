/**
 *  1038. Binary search tree to Greater sum tree (Deque)
 *        将数值从右向左依次做相加（sum），即，sum后，把所有数字依次从大到小排列
 * （1）因为中序排列可以将数字的大小从小到大依次排列。这题用相反的想法。中序排列，从右子树开始，到左子树结束
 * （2）进入树，如果右边有值，就去右边，压入栈中，回到中间相加，最后去左边
 */

 // Method 1: recursive

class Solution{
    int sum = 0;
    public TreeNode bstToGst(TreeNode root){
        if (root.right != null){
            root.right = bstToGst(root.right);
        }
        root.val += sum;
        sum = root.val;
        if (root.left != null){
            root.left = bstToGst(root.left);
        }
        return root;
    }
}

//Method 2 : Iterative

class Solution {
    public TreeNode bstToGst(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        int sum = 0;
        TreeNode node = root;
        while (!stack.isEmpty() || node != null){
            while (node.right != null){
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            node.val += sum;
            sum = node.val;
            node = node.left;
        }
        return root;
    }
}
