import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class testIsValid {

    @Test
    public void case01() {
        ArrayList list = new ArrayList<String>();
   //    list.add("{[]([])}");
        list.add("{[(]([)])}(}){))))((}}}{}}}{}}}{{}}}{{}{[[]]]][[]]][[[[][[[[]}}}{}");
        /*    list.add("(}{)");*/
        /*        list.add("(){}}{");*/
        for (int i = 0; i < list.size(); i++) {
            boolean b = isValid3((String) list.get(i));
            System.out.println("b:" + b);
        }
    }




    public  final static Map<String, String> map= new HashMap<String, String>();
      static {
        map.put(")", "(");
        map.put("}", "{");
        map.put("]", "[");
    }

    public boolean isValid(String s) {

        Stack<String> stack = new Stack<String>();
        for (String ch : s.split("")) {
            if (!stack.isEmpty()) {
                if(null==map.get(ch)){
                    stack.push(ch);
                    continue;
                }
                String top = stack.peek();
                if(map.containsKey(top)){
                    return Boolean.FALSE;
                }
                if (map.get(ch).equals(top)) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(ch);
        }

        if(stack.isEmpty()){
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }

    }


    public boolean isValid3(String s) {
//        //1.特判
//        if(s.isEmpty()) return true;
        //2.创建辅助栈
        Stack<Character> stack = new Stack<Character>();
        //3.遍历
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else if(stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        //4.返回
        return stack.isEmpty();
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];

/*        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {

                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }*/

            //1 轮流比较大小合并两个数组
            //

        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }

            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }


}


