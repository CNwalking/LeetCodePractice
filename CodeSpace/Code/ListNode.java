package Code;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: CNwalking
 * @DateTime: 2020/4/30 1:57 下午
 * @Description:
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) { val = x; }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    /**
     * 新建一个链表
     * @param nums
     * @return
     */
    public static ListNode createNode(int[] nums) {
        if (nums.length == 0) return null;
        ListNode listNode = new ListNode(nums[0]);
        ListNode head = listNode;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            listNode.next = node;
            listNode = node;
        }
        return head;
    }

    /**
     * 遍历链表成一个ArrayList
     * @param head
     * @return
     */
    public static ArrayList<Integer> traverse(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }
        return arrayList;
    }

    /**
     * 正序输出链表
     */
    public void orderOutput() {
        ListNode node = this;
        StringBuilder s = new StringBuilder();
        s.append("OrderOutput: ");
        while (node != null) {
            s.append(node.val).append("->");
            node = node.next;
        }
        s.append("null");
        System.out.println(s.toString());
    }

    /**
     * 逆序输出链表(不改变链表结构)
     */
    public void reverseOrderOutput() {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode node = this;
        StringBuilder s = new StringBuilder();
        s.append("reverseOrderOutput: ");
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        while (!stack.empty()) {
            s.append(stack.pop().val).append("->");
        }
        s.append("null");
        System.out.println(s.toString());
    }


}
