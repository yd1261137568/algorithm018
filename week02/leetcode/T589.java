package week02.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 */

public class T589 {
    public static void main(String[] args) {

    }

    public static List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        list.add(root.val);
        for (Node child : root.children) {
           list.addAll(preorder(child));
        }
        return list;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
