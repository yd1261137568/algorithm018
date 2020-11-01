package week02.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T429 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();

        if(root==null){
            return lists;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        int size = 0;
        while (!queue.isEmpty()){
            List<Integer> integers = new ArrayList<>();
            size = queue.size();

            while (size>0){
                Node poll = queue.poll();

                integers.add(poll.val);
                queue.addAll(poll.children);
                size--;
            }
            lists.add(integers);
        }

        return lists;
    }


    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
