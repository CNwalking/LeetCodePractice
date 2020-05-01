package Code;

/**
 * @Author: CNwalking
 * @DateTime: 2020/5/1 12:35 下午
 * @Description:
 */
public class ListNodeUtils {

    /**
     * 逆序链表(改变原先结构) 思路：
     * (1). 若链表为空或只有一个元素，则直接返回；
     * (2). 设置两个前后相邻的指针pre,tmp. 将pre所指向的节点作为cur指向节点的后继；
     * (3). 重复2直到q为空
     */
    public static ListNode reverseOrderOutput(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        ListNode tmp = null;
        // 假设是 -> a -> b -> c -> d ->
        while (cur != null) {
            tmp = cur.next;
            // 方向反一反 -> a <- b -> c -> d ->
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }



    /**
     * 逆序链表(改变原先结构) 思路：
     *
     * 递归更快!思路是this的下一个结点指向this,即this.next.next = this
     *
     */
    public static ListNode reverseOrderOutputRecursively(ListNode node) {
        // 就一个的话就是它自己,不操作
        if (node == null || node.next == null) {
            return node;
        }
        ListNode cur = reverseOrderOutputRecursively(node.next);
        node.next.next = node;
        node.next = null;
        return cur;
    }
}
