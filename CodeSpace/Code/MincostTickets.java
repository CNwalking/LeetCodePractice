package Code;

/**
 * @Author: CNwalking
 * @DateTime: 2020/5/6 10:29 下午
 * @Description: 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。
 * 在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 * 火车票有三种不同的销售方式：
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
 * 输出：11
 * 在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
 * 在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
 * 在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
 */
public class MincostTickets {

    public static int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        //最后一天
        int last = days[len-1];
        //dp[i]表示第i天最便宜的花费
        int[] dp = new int[last+1];
        int pos = 0;
        for (int i=1;i<=last;i++){
            if (i==days[pos]){
                // 要判断倒退一天,七天,一个月前是否越界
                int day1 = i-1;
                int day2 = i - 7 > 0 ? i - 7 : 0;
                int day3 = i - 30 > 0 ? i - 30 : 0;
                // dp方程
                dp[i] = Math.min(dp[day1]+costs[0],Math.min(dp[day2]+costs[1],dp[day3]+costs[2]));
                pos++;
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[last];
    }

    public static void main(String[] args) {
        int[] days = new int[]{1,4,6,7,8,20};
        int[] costs = new int[]{2,7,15};
        System.out.println(mincostTickets(days, costs));
    }
}
