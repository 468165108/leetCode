import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class testFindMediaNum {

    @Test
    public void case01() {
        int[] nums1 = {1};
        int[] nums2 = {2, 3};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println("result:"+result);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //获取两个数字的长度
        int num1Len = nums1.length;
        int num2Len = nums2.length;
        //初始化排序后的结束数组，定义长度
        int[] sortNum = new int[num1Len + num2Len];
        //定义count计数器  每放入结果数组一次计数+1
        int count = 0;

        //数组1的游标
        int cursorNum1 = 0;
        //数组2的游标
        int cursorNum2 = 0;

        //只要计数器小于两个数组长度之和，继续便利
        while (count < (num1Len + num2Len)) {
            //2 如果数组2遍历完了，则遍历剩余的数组1
            if (cursorNum2 == (num2Len)) {
                while (cursorNum1 < (num1Len)) {
                    sortNum[count++] = nums1[cursorNum1++];
                }
                //中断遍历，不然继续走下去会溢出
                break;
            }

            //3   如果数组1遍历完了，则遍历剩余的数组2
            if (cursorNum1 == (num1Len)) {
                while (cursorNum2 < (num2Len)) {
                    sortNum[count++] = nums2[cursorNum2++];
                }
                break;
            }

            //数组1和数组2比较大小，较小的值进入结果数组
            if (nums1[cursorNum1] < nums2[cursorNum2]) {
                sortNum[count++] = nums1[cursorNum1++];
            } else {
                sortNum[count++] = nums2[cursorNum2++];
            }
        }

        if (count %2 == 0) {
            return (sortNum[count / 2 - 1] + sortNum[count / 2]) / 2.0;
        } else {
            return sortNum[count / 2 ];
        }


    }


}


