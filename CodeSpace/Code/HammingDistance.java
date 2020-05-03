package Code;

/**
 * @Author: CNwalking
 * @DateTime: 2020/5/3 2:31 下午
 * @Description: 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 */
public class HammingDistance {
    /**
     * 直接使用jdk中的方法即可取得    时空都是O(1)
     * 调用内置的 bitCount 函数。最坏情况下，该函数复杂度为 O(k)，其中 k 是整数的位数。
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        // Java中的位运算符中有一个叫做异或的运算符，符号为（^）,其主要是对两个操作数进行位的异或运算，相同取0，相反取1。
        return Integer.bitCount(x ^ y);
    }

    /**
     * 用右移位，每个位置都会被移动到最右边。移位后检查最右位的位是否为 1 即可
     * 可以使用取模运算（i % 2）或者 AND 操作（i & 1），这两个操作都会屏蔽最右位以外的其他位
     */
    public static int hammingDistance2(int x, int y) {
        int distance = 0;
        int xor = x ^ y;
        while (xor != 0) {
            if ((xor & 1) == 1) {
                distance += 1;
            }
            // 右移一位
            xor = xor >> 1;
        }
        return distance;
    }


    public static void main(String[] args) {
        System.out.println(1 ^ 4);
        System.out.println(hammingDistance2(1, 4));
        System.out.println(hammingDistance(1, 4));
    }
}
