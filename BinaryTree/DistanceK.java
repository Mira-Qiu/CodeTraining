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


//Method 2: Percolate distance

import javax.swing.tree.TreeNode;

class Demo {
    List<Integer> ans;
    TreeNode target;
    int K;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K){
        ans = new LinkedList<>();
        dfs(root);
        return ans;
    }

    //dfs return the distance from the node to the target
    private int dfs(TreeNode node){
        if (node == null){
            return -1;
        } else if (node == target){
            subtree_add(node, 0);
            return 1;
        } else {
            int L = dfs(node.left), R = dfs(node.right);
            if (L != -1){
                if (L == K)
                    ans.add(node.val);
                subtree_add(node.right, L + 1);
                return L + 1;
            } else if ( R != -1){
                if (R == K)
                    ans.add(node.val);
                subtree_add(node.right, R + 1);
                return R + 1;
            } else {
                return =1;
            }
            
        }
    }
    // subtree_add : add the nodes int the subtree rooted at the node distance K - distance from the given node
    private void subtree_add(TreeNode node, int dist){
        if (node == null) return;
        if (dist == K){
            ans.add(node.val);
        } else {
            subtree_add(node.left, dist + 1);
            subtree_add(node.right, dist+ 1);
        }
    }
}
