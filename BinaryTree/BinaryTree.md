二叉树的性质

性质1：二叉树第i层上的结点数目最多为2^(i-1) (i>=1)

性质2：深度为k的二叉树至多有2^k-1个结点（k>=1）

性质3：包含n个结点的二叉树的高度至少为(log2n)+1

性质4：在任意一棵二叉树中，若终端结点的个数为n0，度为2的结点数为n2，则n0=n2+1

证明，因为二叉树中所有节点的度数均不大于2，不妨设n0表示度为0的节点个数，n1表示度为1的节点个数，n2表示度为2的结点个数。
三个加起来为总节点个数，于是得到： n = n0 + n1 + n2
由于度直接的关系，得到  n = n0 * 0 + n1 * 1 + n2 * 2 + 1 即  n = n1 + 2 * n2 + 1
最后可得 n0 = n2 + 1


Get node Number in a Binary Tree
```java
/**
 *  1. 求二叉树中的节点个数
 * 递归解法：
 * （1）如果二叉树为空，节点个数为0
 * （2）如果二叉树不为空，二叉树节点个数 = 左子数个数 + 右子数 + 1
 */

    int GetNodeNum(BinaryTreeNode root){
        if (root == null)
            return 0;
        return GetNodeNum(root.left) + GetNodeNum(root.right) + 1;
    }
```


Get depth in a Binary Tree:
```java
/**
     * 2. 求二叉树的深度
     * 递归解法：
     * （1）if (root == null) depth = 0
     * （2）depth = max (left_depth, right_depth) + 1
     */

     int GetDepth(BinaryTreeNode root){
         if (root == null){
             return 0;
         }
         int depthLeft = GetDepth(root.left);
         int depthRigth = GetDepth(root.right);
         return Math.max(depthLeft, depthRight) + 1;
     }
```
