package Code;

/**
 * @Author: CNwalking
 * @DateTime: 2020/6/15 3:34 下午
 * @Description: 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 :
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "空的String[]别传呀";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = findLongest(prefix, strs[i]);
        }
        return prefix;
    }

    public static String longestCommonPrefixVertical(String[] strs) {
        if (strs.length == 0) {
            return "空的String[]别传呀";
        }
        String prefix = strs[0];
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                // 到这个j的头了或这个j的char和这个c不一样就停止
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return prefix;
    }

    /**
     * 横向查找，一个一个String找
     * @param a
     * @param b
     * @return
     */
    private static String findLongest(String a, String b) {
        int length = Math.min(a.length(), b.length());
        int index = 0;
        while (index < length && a.charAt(index) == b.charAt(index)) {
            index++;
        }
        return a.substring(0, index);
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefixVertical(strs));

    }
}
