/**
 *  701. Insert into a Binary Search Tree
 * 插入一个数进入 BST
 * （1）如果根为空， 返回个新节点
 * （2）如果不为空，比较根值与变量，如果大于根，去右边，如果小于根，去左边，在第一个空的位置加入 新节点
 */

 // Method 1: recursive

 class Solution {
     public TreeNode insertIntoBST(TreeNode root, int val){
         if (root == null) return new TreeNode(val);
         if (root.val > val){
             root.left = insertIntoBST(root.left, val); // go to left subtree
         } else {
             root.right = insetIntoBST(root.right, val);
         }
         return root;
     }
 }

 // Method 2:
 class Solution {
     public TreeNode insertIntoBST(TreeNode root, int val){
         if (root == null) return new TreeNode(val);
        TreeNode node = root;
        while (true){    //需要loop，让node一直走下去。
            if (node.val > val){
                 if (node.left != null){ //先看位置是否为空，如果空，加入node，如果不空，挪动node位置，否则会加入 null进入数组
                     node = node.left;
                 } else {
                     node.left = new TreeNode(val); // add a new node to the tree.
                     break;
                 }
             } else {
                 if (node.right != null){
                     node = node.right;
                 } else {
                     node.right = new TreeNode(val);
                     break;
                 }
             }
        }
         return root;
     }
 }
