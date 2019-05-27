import java.util.ArrayList;

/**
 *  144. Bnary Tree Preorder Traversal
 * 把一个二叉树放入前序排列放入列中
 * 首先看结果要求用什么格式结构， new一个结构
 * (1)root为空。返回空结构（结果）
 * （2）root不为空，去将中值放如列中，然后递归左子树，再递归右子树。
 *      Note，这里返回结果为列，所以结果不需要用子树保存
 */

 // Method 1: Recursive
 
 class Solution{
     List<Integer> ans = new ArrayList<>();
     public List<Integer> preorderTraversal(TreeNode root){
        if (root == null) return ans;
        ans.add(root.val);
        if (root.left != null) 
            preorderTraversal(root.left);
        if (root.right != null)
            preorderTraversal(root.right);
        return ans;
     }
 }

 // Method 2: Iterative
class Solution{
 public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) return ans;
    Deque<TreeNode> stack = new LinkedList<>();
    //stack.push(root);
    while (!stack.isEmpty() || root != null){
        if (root != null){
            ans.add(root.val);
            stack.push(root.right);  //这里没有检查左右是否为空，也可以。。
            root = root.left;
        } else {
            root = stack.pop();
        }
    }
    return ans;
}
}
