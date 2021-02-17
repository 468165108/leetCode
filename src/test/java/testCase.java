import org.junit.Test;

public class testCase {

    @Test
    public void case01() {
        int i = reverse(12345);
        System.out.println(i);
    }


    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tmp = x % 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && tmp > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && tmp < -8)) {
                return 0;
            }

            x = x / 10;
            result = result * 10 + tmp;
        }
        return result;
    }

    public int reverse03(int x) {
        int result = 0;
        while (x != 0) {
            int tmp = x % 10;
            x = x / 10;

            try {
                result = result * 10 + tmp;
            } catch (Exception e) {
                return 0;
            }
        }
        return result;
    }
}

