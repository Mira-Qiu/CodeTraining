import java.util.List;

/**
 * 637. Average of Levels in Binary Tree
 * 存储树中每一行的平均数
 * （1）两个数据结构，一个存每一行的sum，一个存每一行的node个数
 * （2）辅助方程，存储每一行的sum，个数，node点位置，层数。
 *      note： 如果在同一行（level < res.size()) 获取本行总sum和，加入新数字，否则，建立新的数字加入list中。
 *  Time complexity : O(n), the tree is traverse once only.
 *  Space Complexity: O(h),  h is the height of the given binary tree. The depth of the recursive tree
 *  could only go upto h only.
 */

 //Method recursive
 class Solution{
     public List<Double> averageOfLevels(TreeNode root){
         List<Double> res = new ArrayList<>();
         List<Integer> count = new ArrayList<>();
         average(res, count, root, 0);
         for (int i = 0; i < res.size(); i++)
            res.set(i, res.get(i)/count.get(i));
         return res;
     }
     private void average(List<Double> res, List<Integer> count, TreeNode node, int level){
         if (node == null) return;
         if (level < res.size()){
             res.set(level, res.get(level) + node.val);
             count.set(level, count.get(level) + 1);
         } else {
             res.add(1.0 * node.val);
             count.add(1);
         }
         average(res, count, node.left, level + 1);
         average(res, count, node.right, level + 1);
     }
 }

 // Method: Iterative 2 x Queue to struct 2 loop and count+sum to result
 // (1)大queue不为空，小queue内单独每一次sum和count计算，并在小queue内加入子树，小queue出来，将数据交给大queue，将结果交给res
 //  Time complexity: O(n)
 //  Space Complexity: O(m), the size of queue or temp queue. atmost the maximum number of the nodes at any level(某层nodes最多的数)
 class Solution{
     public List<Double> averageOfLevels(TreeNode root){
         List<Double> res = new ArrayList<>();
         Deque<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         while (!queue.isEmpty()){
             long sum = 0, count = 0;
             Deque<TreeNode> tmpQueue = new LinkedList<>();
             while (!queue.isEmpty()){
                 TreeNode n = queue.remove();
                 sum += n.val;
                 count++;
                 if (n.left != null) tmpQueue.add(n.left);
                 if (n.right != null) tmpQueue.add(n.right);
             }
             res.add(1.0 * sum/ count);
             queue = tmpQueue;
         }
         return res;
     }
 }

