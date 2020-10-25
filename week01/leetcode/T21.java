package week01.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T21 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next=listNode2;
        listNode3.next=listNode4;
        ListNode listNode = mergeTwoLists(listNode1, listNode3);

        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<Integer>();

        ListNode listNode = new ListNode();
        ListNode tmp = new ListNode();
        tmp = listNode;

        while (l1 != null) {
            list.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            list.add(l2.val);
            l2 = l2.next;
        }

        Collections.sort(list);

        for (Integer integer : list) {
            tmp.next = new ListNode(integer);
            tmp = tmp.next;
        }
        return listNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
