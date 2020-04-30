package Code;

import java.util.ArrayList;

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
     * 逆序链表(改变原先结构) 思路：
     * (1). 若链表为空或只有一个元素，则直接返回；
     * (2). 设置两个前后相邻的指针p,q. 将p所指向的节点作为q指向节点的后继；
     * (3). 重复2直到q为空
     * (4). 调整链表头和链表尾
     */
    public void reverseOrderOutput() {
        // 就一个的话就是它自己,不操作
        if (this.next == null) {
            return;
        } else {
            // 先拿到它后面两个节点
            ListNode p = this.getNext();
            ListNode q = this.getNext().getNext();
            // 假设是 -> a -> b -> c -> d ->
            // 先把 b -> c 断开 变成  -> a -> b    c -> d ->
            p.setNext(null);
            ListNode temp = null;
            while (q != null) {
                temp = q.getNext();
                // 方向反一反 -> a -> b <- c -> d ->
                q.setNext(p);
                // 下面两步是往后推进这个过程
                p = q;
                q = temp;
                // -> a -> b <- c <- d -> ...... 最后变成 -> a (<->) b <- ...
            }
            // 此时已经到达最后一位
            this.setNext(p);
            q = null;
        }

    }
}
