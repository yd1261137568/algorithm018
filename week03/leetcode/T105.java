package week03.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目:105. 从前序与中序遍历序列构造二叉树
 * 地址:https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 说明:根据一棵树的前序遍历与中序遍历构造二叉树。
 */
public class T105 {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        lrd(treeNode);

    }

    private static Map<Integer, Integer> map = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        //构造中序遍历map
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return createTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * 递归 生成左右子树的根节点
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param preorder
     * @param inorder
     * @param left_satr
     * @param left_end
     * @param right_star
     * @param right_end
     * @return
     */
    private static TreeNode createTree(int[] preorder, int[] inorder, int left_satr, int left_end, int right_star, int right_end) {

        //递归结束条件
        if (left_satr > left_end || right_star > right_end) {
            return null;
        }


        int pivot = preorder[left_satr];
        //根节点
        TreeNode root = new TreeNode(pivot);

        int pivotIndex = right_star;

        //采用Hash表优化根节点下标获取
        pivotIndex = map.get(pivot);
//        while (inorder[pivotIndex] != pivot) {
//            pivotIndex++;
//        }
        root.left = createTree(preorder, inorder, left_satr + 1, pivotIndex - right_star + left_satr, right_star, pivotIndex - 1);
        root.right = createTree(preorder, inorder, pivotIndex - right_star + left_satr + 1, left_end, pivotIndex + 1, right_end);
        return root;
    }


    //后续遍历
    public static void lrd(TreeNode treeNode) {
        if (treeNode.left != null) {
            lrd(treeNode.left);
        }
        if (treeNode.right != null) {
            lrd(treeNode.right);
        }
        System.out.println(treeNode.val);

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
