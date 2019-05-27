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
       // Deque<TreeNode> stack = new ArrayDeque<>(); 与下相同结果
        Deque<TreeNode> stack = new LinkedList<>();
        int sum = 0;
        TreeNode node = root; //要新建一个节点，因为结果要返回root
        while (!stack.isEmpty() || node != null){ // 这里要假如node 不为空的条件，否则 不会进入栈中，因为栈一直为空
            while (node != null){  //第一个条件，如果本节点有值即可，右节点可以为空，因为null值也要进入序列中（占位); 并且，node 会走到右子树去检查是否有值
                stack.push(node);  // 压入栈的第一个节点为，父节点，压入栈的最后一个节点为最右的子节点
                node = node.right;
            }
            node = stack.pop(); //pop出来的第一个值为最后的右节点，pop出的最后一个值为父节点。
            node.val += sum;
            sum = node.val;
            node = node.left; //去左子树
        }
        return root;
    }
}
