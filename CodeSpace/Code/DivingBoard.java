package Code;

/**
 * @Author: CNwalking
 * @DateTime: 2020/7/8 3:49 下午
 * @Description:
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 */
public class DivingBoard {

    /**
     * 其实就相当于一个数学问题，i块长的，(k-i)块端的, 总长度 = longer*i + shorter*(k-i)
     * 把i在k里面for一下就好了。然后化简一下问题 总长度 = shorter * k + i * (longer - shorter)
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    public static int[] divingBoard(int shorter, int longer, int k) {
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        if (k == 0) {
            return new int[]{};
        }
        int[] result = new int[k+1];
        for (int i = 0; i <= k; i++) {
            result[i] = shorter * k + i * (longer - shorter);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = divingBoard(1, 2, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
