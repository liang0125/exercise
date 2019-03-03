package com.github.liang.exercise;

import java.util.HashMap;

/**
 * Author:lorrie
 * Create:2019/3/2
 */
class TreeNodes {
    int val = 0;
    TreeNodes left = null;
    TreeNodes right = null;

    public TreeNodes(int val) {
        this.val = val;

    }
}

/*
题目描述
操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class TestBinaryTree {
//    public void Mirror(TreeNodes root) {
//
//        if(root==null){
//            return;
//        }
//        if (root.left==null&&root.right==null){
//            return;
//        }
//        //交换左右子树
//        TreeNodes tmp=root.left;
//        root.left=root.right;
//        root.right=tmp;
//
//        Mirror(root.left);
//        Mirror(root.right);
//    }


    /*
    题目描述
    输入两棵二叉树A，B，判断B是不是A的子结构。
    （ps：我们约定空树不是任意一个树的子结构）
     */

    public boolean HasSubtree(TreeNodes root1, TreeNodes root2) {
        boolean flag = false;
        if (root1 != null && root2 != null) {

            if (root1.val == root2.val) {
                flag = HasSubtrees(root1, root2);
            }
            if (!flag) {

                flag = HasSubtree(root1.left, root2);
            }
            if (!flag) {

                flag = HasSubtree(root1.right, root2);
            }

        }
        return flag;
    }

    public boolean HasSubtrees(TreeNodes root1, TreeNodes root2) {
        if (root1 == null && root2 != null) {
            return false;
        }
        if ( root2 == null) {
            return true;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return HasSubtrees(root1.left, root2.left) && HasSubtrees(root1.right, root2.right);
    }
}
