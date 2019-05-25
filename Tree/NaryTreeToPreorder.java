import java.util.ArrayList;
import java.util.List;

/**
 *  589. N-ary Tree Preorder Traversal
 *  不等量的树，带有不知地多少子树，需要变成 前序排列输出
 *   如果使用迭代与stack 就要将整个序列反向装入stack中，然后pop出 装入结果list里
 * （1）如果根为空，返回 list
 * （2）如果不为空，将root放入栈中， 用 stack 反向实现
 */


 class Node {
     public int val;
     public List<Node> children;
     public Node(){}
     public Node(int val, List<Node> children){
         this.val = val;
         this.children = children;
     }
 }

 // Method 1:  Recursive
class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorder(Node root){
        if (root == null) return ans;
        ans.add(root.val);
        for (Node n : root.children){
            preorder(n);
        }
        return ans;
    }
}

// Method 2: Iterative
class Solution{
    public List<Integer> preorder(Node root){
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            ans.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--){
                stack.push(root.children.get(i));
            }
        }
        return ans;
    }
}
