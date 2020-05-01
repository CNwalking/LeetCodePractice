package Code;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: CNwalking
 * @DateTime: 2020/5/1 6:50 下午
 * @Description:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class findSumPosition {

    /**
     * 直接想到的就是两个for 时间O(n②) 空间O(1)
     */
    public static int[] twoSumSimple(int[] nums, int target) {
        if (nums.length < 2) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * 塞到map里面操作 时间O(n) 空间O(n)->要维护一个n个元素的HashMap
     */
    public static int[] twoSumMap(int[] nums, int target) {
        // {值,位置}
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int wantedNum = target - nums[i];
            // 有这个值，且不是本身
            if (numsMap.containsKey(wantedNum) && !numsMap.get(wantedNum).equals(i)) {
                return new int[]{i,numsMap.get(wantedNum)};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] i = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSumSimple(i,target)));
        System.out.println(Arrays.toString(twoSumMap(i,target)));
    }
}
