/**
  * 938.Range of BST
  *  （1） 根为空，直接返回
  *  （2） 根不为空，比较 root & L & R
  *     1.node 大于等于L，小于等于 R，就把根加入结果中
  *     2. node 大于 L，就把node 放入公式中走一遍，
  *     3. node 小于R， 把node 放入公式中。
  *     【 如果 root.val 落在范围之外，例如，node.val < L，只有右侧节点，可以在范围之内。】
  */

  // Method 1: recursive

  class solution{
      int ans;
      public int rangeSumBST(TreeNode root, int L, int R){
        ans = 0;
        bst(root, L, R);
        return ans;
      }
      private void bst(TreeNode node, int L, int R){
          if (node != null){
              if (node.val >= L && node.val <= R){
                  ans += node.val;
              }
              if (node.val > L){
                  bst(node.left, L, R);
              }
              if (node.val < R){
                  bst(node.right, L, R);
              }
          }
      }
  }

  // Method 2: iterative

  class solution{
      public int rangeSumBST(TreeNode root, int L, int R){
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int ans = 0;
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node != null){
                if (node.val >= L && node.val <= R){
                    ans += node.val;
                }
                if (node.val > L){
                    stack.push(node.left);
                }
                if (node.val < R){
                    stack.push(node.right);
                }
            }
        }
        return ans;
      }
  }
