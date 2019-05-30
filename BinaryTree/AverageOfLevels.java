public List<Double> averageOfLevels(TreeNode root){
         List<Double> res = new ArrayList<>();
         Deque<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         while (!queue.isEmpty()){
             long sum = 0, count = 0;
             Deque<TreeNode> tmpQueue = new LinkedList<>();
             while (!queue.isEmpty){
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
