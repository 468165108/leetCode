import org.junit.Test;

public class testCaselongestCommonPrefix {

    @Test
    public void case01() {
        String[] strs = {"qqa", "qq1", "qA1"};
        String comprefix = longestCommonPrefix(strs);
        System.out.println(comprefix);
    }


    public String longestCommonPrefix(String[] strs) {

        if(strs.length==0){
            return "";
        }

        String prefixOne = strs[0];
        for (String str : strs) {
            if (!str.startsWith(prefixOne)) {
                while (!str.startsWith(prefixOne)) {
                    if (prefixOne.length() == 0) return "";
                    prefixOne = prefixOne.substring(0, prefixOne.length() - 1);
                }
            }
        }
        return prefixOne;
    }



    public String longestCommonPrefix02(String[] strs) {
        String prefixOne = String.valueOf(strs[0].charAt(0));

        for (String str : strs) {
            if (str.startsWith(prefixOne)) {
                while (!str.startsWith(prefixOne)) {
                    if (prefixOne.length() == 0) return "";
                    prefixOne = prefixOne.substring(0, prefixOne.length() - 1);
                }
            }
        }
        return prefixOne;
    }



}

