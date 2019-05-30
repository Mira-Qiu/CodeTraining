/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        levelmaker(res, root, 0);
        return res;
    }
    private void levelmaker(List<List<Integer>> res, Node node, int level){
        if (node == null) return;
        List<Integer> list = new ArrayList<>();
        if (level < res.size()){
            list = res.get(level);
            list.add(node.val);
        } else {
            list.add(node.val);
            res.add(list);
        }
        for (Node n : node.children){
            levelmaker(res, n , level + 1);
        }
    }
}
