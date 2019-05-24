       /**
        *  LevelTraverse 
        *  ( DFS + Queue )
        *  queue 初始化，将根节点压入队列。当队列不为空，然后：弹出一个节点，访问，
        *   若左子节点或右子节点不为空，将其压进队列
        */

        void LevelTraverse(BinaryTree root){
            if (root == null) return;
            Queue<BinaryTree> q = new Queue();
            q.push(root);
            while (!q.empty()){
                BinaryTree node = q.pop();
                visit(node);
                if (node->m_left != null){
                    q.push(node->m_left);
                }
                if (node->m_right != null){
                    q.push(node->m_right);
                }
            }
        }
