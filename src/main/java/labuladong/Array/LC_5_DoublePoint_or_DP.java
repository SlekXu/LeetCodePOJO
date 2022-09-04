package labuladong.Array;

import org.junit.Test;

/**
 * @Author Slek
 * @Date 2022/9/1 12:58
 * @Description 最长回文字符串
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 */
public class LC_5_DoublePoint_or_DP {

    /**
     * 双指针，从回文字串的中间，向两边发散，直到找到两个值不等的
     */
    public String longestPalindrome_DoublePointer(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        //TODO
        return null;
    }

    @Test
    public void test() {
        String s = "babad";
        System.out.println(longestPalindrome_DoublePointer(s));
    }
}
