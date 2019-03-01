package com.github.liang.exercise;

/**
 * Author:lorrie
 * Create:2019/3/1
 */
/*
题目描述：（剑指offer第四题）
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */


//二叉树结点
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}


public class ConstructBinaryTree {
    public static void main(String[] args) {
        int[]pre={1,2,4,7,3,5,6,8};
        int[]in={4,7,2,1,5,3,8,6};
        TreeNode treeNode=reConstructBinaryTree(pre,in);
        System.out.println(treeNode);
    }
    //方式一：
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        //长度为零说明是空树
        if(pre.length==0){
            return null;
        }

        TreeNode root=new TreeNode(pre[0]);//确定根节点
        int len=pre.length;
        //长度是1说明只有根节点
        if(len==1){
            root.left=null;
            root.right=null;
            return root;
        }
        //找到根节点在中序遍历中的位置
        int data=root.val;
        int i;
        for( i=0;i<len;i++){
            if(data==in[i]){
                break;
            }
        }

        //创建左子树
        if (i>0) {
            int[] leftTree_in = new int[i];
            int[] leftTree_pre = new int[i];
            for (int j = 0; j < i; j++) {
                leftTree_in[j] = in[j];
                leftTree_pre[j] = pre[j + 1];
            }


            root.left = reConstructBinaryTree(leftTree_pre, leftTree_in);
        }
        else {
            root.left=null;
        }
        if(len-i-1>0) {
            //创建右子树
            int[] rightTree_in = new int[len - i - 1];
            int[] rightTree_pre = new int[len - i - 1];
            for (int j = i + 1; j < len; j++) {
                rightTree_in[j - i - 1] = in[j];
                rightTree_pre[j - i - 1] = pre[j];
            }
            root.right = reConstructBinaryTree(rightTree_pre, rightTree_in);
        }
        else {
            root.right=null;
        }
        return root;

    }

    //方法二
//        public  static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
//            TreeNode root=re_ConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
//            return root;
//        }
//        //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
//        public  static TreeNode re_ConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
//
//            if(startPre>endPre||startIn>endIn)
//                return null;
//            TreeNode root=new TreeNode(pre[startPre]);
//
//            for(int i=startIn;i<=endIn;i++)
//                if(in[i]==pre[startPre]){
//                    root.left=re_ConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
//                    root.right=re_ConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
//                    break;
//                }
//
//            return root;
//        }
//            public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
//                TreeNode root=re_ConstructBinaryTree(pre,0, pre.length-1,in,0,in.length-1);
//                return root;
//            }
//
//            public static TreeNode re_ConstructBinaryTree(int[] pre, int start_pre, int end_pre, int[] in, int start_in, int end_in) {
//
//                if(start_pre>end_pre||start_in>end_in){
//                    return null;
//                }
//                TreeNode root=new TreeNode(pre[start_pre]);
//                for(int i=start_in;i<=end_in;i++){
//                    if (pre[start_pre]==in[i]){
//                        root.left=re_ConstructBinaryTree(pre,start_pre+1,start_pre+i-start_in,in,start_in,i-1);
//                        root.right=re_ConstructBinaryTree(pre,i-start_in+start_pre+1,end_pre,in,i+1,end_in);
//                        break;
//                    }
//                }
//
//
//                return root;
//            }


}
