package week02.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class T144 {
    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }

        list.add(root.val);
        if(root.left!=null){
            list.addAll(preorderTraversal(root.left));
        }
        if(root.right!=null){
            list.addAll(preorderTraversal(root.right));
        }

        return list;


    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
