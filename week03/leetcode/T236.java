package week03.leetcode;

/**
 * 题目:236.二叉树的最近公共祖先
 * 地址:https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 说明:给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class T236 {
    public static void main(String[] args) {
    }

    /**
     * 递归后序遍历  解法类似求二叉树的最大深度Max(left,right)+1
     * 时间复杂度:O(n)
     * 空间复杂度:O(n) ??
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1.判断p、q是否是根节点 如果是根节点直接返回
        if(p==root || q==root){
            return root;
        }

        TreeNode leftNode = null;
        TreeNode rightNode = null;

        //2.遍历左右子树
        if(root.left!=null){
            leftNode = lowestCommonAncestor(root.left, p, q);
        }

        if(root.right!=null){
            rightNode = lowestCommonAncestor(root.right, p, q);
        }

        //3.判断返回情况
        if(leftNode==null){
            return rightNode;
        }else if(rightNode==null){
            return leftNode;
        }else{
            return root;
        }


    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
