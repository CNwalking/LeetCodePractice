package Code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author: CNwalking
 * @DateTime: 2020/5/2 9:20 下午
 * @Description: 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 *
 */
public class FindMedian {

    ArrayList<Integer> list;

    public FindMedian() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        Collections.sort(list);
        if (list.size() % 2 == 1) {
            return list.get(list.size() / 2);
        } else {
            return (double) (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2;
        }
    }

    public static void main(String[] args) {
        int a = 1, b = 2, c = 3, d = 4;
        FindMedian obj = new FindMedian();
        obj.addNum(a);
        obj.addNum(b);
        obj.addNum(c);
        obj.addNum(d);
        System.out.println(obj.findMedian());
    }
}
