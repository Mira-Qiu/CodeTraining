import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import javax.swing.tree.TreeNode;

/**
 * 863. All nodes distance K in Binary Tree
 * given a binary tree( root), a target node, an integer distance k.
 *  return a list of the values of all nodes that have a distance k from the target node
 * 
 *  Approach 1: annotate parent
 *  如果知道没一个node 的 parent。就知道 所有节点距离 1 。then, breadth first search for target node
 * 
 *   Algorithm: (1) dfs search where we annotate every node with nodes' parents
 *              (2) bfs find all nodes a distance k from the target
 */

 class Solution{
     Map<TreeNode,TreeNode> parent;
     public List<Integer> distanceK(TreeNode root, TreeNode target, int k){
         parent = new HashMap<>();
         dfs(root,null);

         Queue<TreeNode> queue = new LinkedList<>();
         queue.add(null);
         queue.add(target);

         Set<TreeNode> seen = new HashSet<>();
         seen.add(target);
         seen.add(null);

         int dist = 0;
         while (!queue.isEmpty()){
             TreeNode node = queue.poll();
             if (node == null){
                 if (dist == k){
                     List<Integer> ans = new ArrayList<>();
                     for (TreeNode n : queue){
                         ans.add(n.val);
                     }
                     return ans;
                 }
                 queue.offer(null);
                 dist++;
             } else {
                 if (!seen.contains(node.left)){
                     seen.add(node.left);
                     queue.offer(node.left);
                 }
                 if (!seen.contains(node.right)){
                     seen.add(node.right);
                     queue.offer(node.right);
                 }
                 TreeNode par = parent.get(node);
                 if (!seen.contains(par)){
                     seen.add(par);
                     queue.offer(par);
                 }
             }
         }
         return new ArrayList<Integer>();
     }
     public void dfs(TreeNode node, TreeNode par){
         if (node != null){
             parent.put(node, par);
             dfs(node.left,node);
             dfs(node.right,node);
         }
     }
 }
