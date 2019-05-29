/**
 * 623. add one row to tree
 * 一棵树，在一定的深度的某层加入一层 v
 * （1）如果要插入的是第一层，也就是插入到root 的位置，所有的节点下移一层：
 *          新建一个节点，把根值连在新节点的左侧，返回新节点 new TreeNode(v);
 * (2) 如果插入的不是第一层，要用递归或者stack保存 （节点，新值，本层深度，要插入的深度）
 *      如果本层深度 等于 要插入的深度 - 1， 那么 就插入，
 *          1。新建临时节点，插入左边，左边这个变量 指向 新节点（new TreeNode (v));
 *          2. 3点循环； 然后插入右边，三点循环。
 *          3. 返回根即可
 */
//Method 1: Recurisive

class Solution{
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    public TreeNode addOneRow(TreeNode root, int v, int d){
        if (d == 1){
            TreeNode n = new TreeNode(v);
            n.left = root;
            return n;
        }
        insert(root, v, 1, d);
        return root;
    }
    private void insert(TreeNode node, int v, int depth, int d){
        if (node == null) return;
        if (depth == d - 1){
            TreeNode n = node.left;
            node.left = new TreeNode(v);
            node.left.left = n;
            n = node.right; //n变量 循环利用，节省空间
            node.right = new TreeNode(v);
            node.right.right = n;
        } else {
            insert(node.left, v, depth + 1, d); //递归循环，找深度所在的位置
            insert(node.right, v, depth + 1, d);
        }
    }
}

//Method 2 : Iterative (stack)
// 方法与上面相同，将左右子树压入栈中，
//新建一个Node class 存放 节点和每个节点的深度；

class Solution{
    class Node{
        TreeNode node ;
        int depth;
        Node(TreeNode n, int d){
            node = n;
            depth = d;
        }
    }
    public TreeNode addOneRow(TreeNode root, int v, int d){
        if (d == 1){
            TreeNode t = new TreeNode(v);
            t.left = root;
            return t;
        }
        Deque<Node> stack = new LinkedList<>();
        stack.push(new Node(root, 1));
        while (!stack.isEmpty()){
            Node n = stack.pop();
            if (n.node == null) continue;
            if (n.depth == d - 1){
                TreeNode t = n.node.left;
                n.node.left = new TreeNode(v);
                n.node.left.left = t;
                t = n.node.right;
                n.node.right = new TreeNode(v);
                n.node.right.right = t;
            } else {
                stack.push(new Node(n.node.left, n.depth + 1));
                stack.push(new Node(n.node.right, n.depth + 1));
            }
        }
        return root;
    }
}
