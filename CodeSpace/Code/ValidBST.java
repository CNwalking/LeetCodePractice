package Code;

/**
 * @Author: CNwalking
 * @DateTime: 2020/5/5 10:30 下午
 * @Description: 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 输入:
 *         2
 *        / \
 *       1   3
 * 输出: true
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4
 */
public class ValidBST {

    /**
     * 首先要有一个方法判断某个节点对不对,需要拿到它附近的那几个点
     */
    public static boolean isTrueNode(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;
        // 其实是就是值比大小
        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;
        // 一层一层下去
        if (! isTrueNode(node.right, val, upper)) return false;
        if (! isTrueNode(node.left, lower, val)) return false;
        return true;
    }

    public static boolean isValidBST(TreeNode root) {
        return isTrueNode(root, null, null);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.mkTree("[5,1,4,null,null,3,6]");
        TreeNode root2 = TreeNode.mkTree("[2,1,3]");
        System.out.println(isValidBST(root));
        System.out.println(isValidBST(root2));
    }

}
