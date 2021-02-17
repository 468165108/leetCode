import org.junit.Test;

public class testCaseromanToInt {

    @Test
    public void case01() {
        String s = "MCMXCIV";
        int roman = romanToInt(s);
        System.out.println(roman);

 /*       for (int i = 1; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }*/

        //System.out.println(i);
    }


    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getVal(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int nowNum = getVal(s.charAt(i));
            if (nowNum > preNum) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = nowNum;
        }
        //最后一位不在循环内
        sum += preNum;
        return sum;
    }



    private int getVal(char ch) {
        switch (ch) {

            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

}

