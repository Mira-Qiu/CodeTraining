import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
 *  107. Binary tree level order traversal II
 *   把树 按每层存入 list 中
 *  （1）需要循环每一层，记录每一层的深度，把同层子树放一起。
 * （2）queue 记录遇到的同层的点，queue中存在的node个数就是同一层的个数（根左，根右）
 */

 //method 1: BFS , queue(for same level node) List<>(for answer), List<>(sub list)
 // Note： queue 的必要性：检查过的node的左右子可以出去，用queue控制同一层有几个node。queue.peek()只是去看有没有左右子，如果有就加入到queue中。这样同一层的node只会同时在顺序的子中。
 //for loop控制 同一层到底有几个node，就是一个loop里加入到queue中的node个数

 class solution{
     public List<List<Integer>> levelOrderBottom(TreeNode root){
         List<List<Integer>> ans = new LinkedList<>();
         Queue<TreeNode> queue = new LinkedList<>();
         if (root == null) return ans;
         queue.offer(root);
         while (!queue.isEmpty()){
             int level = queue.size();
             List<Integer> list = new LinkedList<>();
             for (int i = 0; i < level;i++){
                 if(queue.peek().left != null)
                    queue.add(queue.peek().left);
                if (queue.peek().right != null)
                    queue.add(queue.peek().right);
                list.add(queue.poll().val);
             }
             ans.add(0,list);
         }
         return ans;
     }
 }

 //method 2: DFS search and put node, and record the level number

 class Solution{
     public List<List<Integer>> levelOrderBottom(TreeNode root){
         List<List<Integer>> wraplist = new LinkedList<>();
         addlist(wraplist, root, 0);
         return wraplist;
     }
     private void addlist(List<List<Integer>> list, TreeNode node, int level){
         if (node == null) return;
         if (level >= list.size()){
             list.add(0,new LinkedList<>());
         }
         addlist(list, node.left, level+ 1);
         addlist(list, node.right, level + 1);
         list.get(list.size() - level - 1).add(node.val);
     }
 }
