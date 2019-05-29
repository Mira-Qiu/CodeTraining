import java.util.ArrayList;

/**
 *  897. Increasing order search Tree
 *  将bst 变成一侧偏向的由小到大排序的树
 * （1）将树inoder变成顺序树，存入list中，然后新建一个TreeNode起始点，一个可以移动的变量节点，顺序插入 Note: new TreeNode(i);
 * (2) 第二种方法，打破原来的顺序
 */

 //Method 1: New list to save TreeNode

 class Solution{
     public TreeNode increasingBST(TreeNode root){
         List<Integer> list = new ArrayList<>();
         inorder(root, list);
         TreeNode ans = new TreeNode(0);
         TreeNode cur = ans;
         for(int i : list){
             cur.right = new TreeNode(i);
             cur = cur.right;
         }
         return ans.right;
     }

     private void inorder(TreeNode node, List<Integer> list){
         if (node == null) return;
         inorder(node.left, list);
         list.add(node.val);
         inorder(node.right, list);
     }
 }

 // Method 2: reusing the linking
 // during the traversal, construct the answer on the fly, reusing the nodes of the given tree

 class Solution{
     TreeNode cur;
     public TreeNode increasingBST(TreeNode root){
         TreeNode ans = new TreeNode(0);
         TreeNode cur = ans;
         inorder(root);
         return ans.right;
     }
     private void inorder(TreeNode node){
         if (node == null) return;
         inorder(node.left);
         node.left = null;
         cur.right = node;
         cur = node;
         inorder(node.right);
     }
 }
