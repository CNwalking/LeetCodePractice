package Code;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CNwalking
 * @DateTime: 2020/5/4 12:51 下午
 * @Description: 输入: [2,3,1,1,4]  输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
public class JumpGame {
    /**
     * 正向查找 时间复杂度：O(n) 空间O(1)
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            // 如果长度为小于1，直接到达
            return 0;
        }
        // 步数
        int steps = 1;
        // 起跳点
        int start = 0;
        // 起跳终点
        int maxPosition = nums[0];
        while (maxPosition < len - 1) {
            int curMax = 0;
            for (int i = start + 1; i <= maxPosition; i++) {
                if (i + nums[i] > curMax) {
                    // 当前点可以到达的最远距离更长
                    curMax = i + nums[i];
                    start = i;
                }
            }
            // 从当前起点可以到达的终点位置
            maxPosition = start + nums[start];
            //步数加一
            steps++;
        }
        return steps;
    }

    /**
     * 官方解法 反向查找，从目标点开始推  时间复杂度：O(n^2) 空间O(1)
     * @param nums
     * @return
     */
    public static int jump2(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(jump(nums));
        System.out.println(jump2(nums));
    }
}
