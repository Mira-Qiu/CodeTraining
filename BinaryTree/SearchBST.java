/**
 * 700. search in a Binary Search Tree
 * 在二叉树中找一个值，返回整个值的子树
 *  （1）根为空，返回空
 *  （2） 根为val，返回根
 *  （3） 根大于val，去左子树， 根小于val，去右子树
 * 
 */

 // Method 1: recursive
 class Solution{
     public TreeNode searchBST(TreeNode root, int val){
         if (root == null || root.val == val) return root;
         else 
         return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
     }
 }

 //Method 2: traverse
 class Solution {
     public TreeNode seachBST(TreeNode root, int val){
         while (root != null && root.val != val){
             root = root.val > val ? root.left : root.right;
         }
         return root;
     }
 }
