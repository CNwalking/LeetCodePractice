package Code;

import java.util.ArrayList;

/**
 * @Author: CNwalking
 * @DateTime: 2020/5/5 9:26 下午
 * @Description: 树的节点
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    TreeNode(int x) { val = x; }

    @Override
    public String toString(){
        return Integer.toString(val);
    }

    private static int[] StrToIntArray(String str) {
        str = str.substring(1, str.length() - 1);
        String []strs = str.split(",");
        int []arr = new int[strs.length];
        for (int i = 0; i < arr.length; i++) {
            if (strs[i].equals("null")) {
                arr[i] = Integer.MAX_VALUE;
            } else {
                arr[i] = Integer.parseInt(strs[i]);
            }
        }

        return arr;
    }

    // String str = "[3,9,20,null,null,15,7]"
    public static TreeNode mkTree(String str) {

        int []arr = StrToIntArray(str);
        TreeNode []nodes = new TreeNode[arr.length + 1];
        for (int i = 1; i < nodes.length; i++) {
            if (arr[i - 1] != Integer.MAX_VALUE) {
                nodes[i] = new TreeNode(arr[i - 1]);
            } else {
                nodes[i] = null;
            }
        }
        TreeNode node = null;
        for (int i = 1; i < nodes.length / 2; i++) {
            node = nodes[i];
            if (node == null) continue;
            node.left = nodes[2 * i];
            node.right = nodes[2 * i + 1];
        }
        return nodes[1];
    }

    //中序遍历
    public static ArrayList<Integer> middleTraverse(TreeNode treeNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (treeNode == null) {
            arrayList.add(null);
        }else if (treeNode.left == null && treeNode.right == null) {
            arrayList.add(treeNode.val);
        } else {
            arrayList.add(treeNode.val);
            arrayList.addAll(middleTraverse(treeNode.left));
            arrayList.addAll(middleTraverse(treeNode.right));
        }
        return arrayList;
    }

    //前序遍历
    public static ArrayList<Integer> beforeTraverse(TreeNode treeNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (treeNode == null) {
            arrayList.add(null);
        }else if (treeNode.left == null && treeNode.right == null) {
            arrayList.add(treeNode.val);
        } else {
            arrayList.addAll(beforeTraverse(treeNode.left));
            arrayList.add(treeNode.val);
            arrayList.addAll(beforeTraverse(treeNode.right));
        }
        return arrayList;
    }

    //后序遍历
    public static ArrayList<Integer> afterTraverse(TreeNode treeNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (treeNode == null) {
            arrayList.add(null);
        }else if (treeNode.left == null && treeNode.right == null) {
            arrayList.add(treeNode.val);
        } else {
            arrayList.addAll(afterTraverse(treeNode.right));
            arrayList.add(treeNode.val);
            arrayList.addAll(afterTraverse(treeNode.left));
        }
        return arrayList;
    }

}
