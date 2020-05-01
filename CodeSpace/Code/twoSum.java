package Code;

import static Code.ListNodeUtils.*;

/**
 * @Author: CNwalking
 * @DateTime: 2020/4/30 1:52 下午
 * @Description:  两个数都不以 0 开头的逆序方式存储的链表,返回一个新的链表来表示它们的和
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class twoSum {

    /**
     * 首先想到的是直接用淳朴方法做
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 先new一个结果ListNode的头结点(实际没什么蛋用,但是可以有个起始)
        ListNode head = new ListNode(0);
        // 注意此处一定要copy一份，否则会改变原结构
        ListNode p = l1, q = l2, result = head;
        // 考虑两数相加>10情况,要进1,所以先维护一个变量
        int isOver = 0;
        // 该位的和为 x+y+isOver
        while (p != null || q != null) {
            // 没值补0
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + isOver;
            isOver = sum / 10;
            // 这一位的结果
            result.next = new ListNode(sum % 10);
            // 3条链表都往后移
            result = result.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        // 最后有进位,就最后再塞一个
        if (isOver == 1) {
            result.next = new ListNode(isOver);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.createNode(new int[]{1, 2, 3});
        ListNode l2 = ListNode.createNode(new int[]{4, 5, 6});
        ListNode l3 = ListNode.createNode(new int[]{1, 2, 3, 4, 5, 6});
        ListNode l4 = ListNode.createNode(new int[]{1, 2, 3, 4});

        ListNode result = addTwoNumbers(l1, l2);
        l1.orderOutput();
//        reverseOrderOutput(l3);
//        reverseOrderOutputRecursively(l4);
        l3.orderOutput();
        l4.reverseOrderOutput();
        result.orderOutput();

    }
}
