    /**
     *  Preorder
     * (1) 如果为空，空操作
     * （2）如果不为空，访问根节点，前序遍历左子树，前序遍历右子树
     * 
     */

     void preorderTraverse(BinaryTree root){
         if (root == null) return;
         vist(root);
         preorderTraverse(root->m_left);
         preorderTraverse(root->m_right);
     }

     /**
      *  Inorder
      * (1)
      * (2) 如果不为空，中序遍历左子数，访问根节点，中序遍历左子数，中序遍历右子数
      */

      void inorderTraverse(BinaryTree root){
          if (root == null) return;
          inorderTraverse(root->m_left);
          visit(root);
          inorderTraverse(root->m_right);
      }
      /**
       * PostOrder
       * （1）
       * （2） 后续遍历左子数，后续遍历右子数，访问根节点
       * 
       */

       void postOrderTraverse(BinaryTree root){
           if(root == nul) return;
           postOrderTraverse(root->m_left);
           postOrderTraverse(root->m_right);
           visit(root);
       }
