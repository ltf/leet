package h564;

import org.junit.Test;

import static org.junit.Assert.*;

/**

 给定一个整数 n ，你需要找到与它最近的回文数（不包括自身）。

 “最近的”定义为两个整数差的绝对值最小。

 示例 1:

 输入: "123"
 输出: "121"
 注意:

 n 是由字符串表示的正整数，其长度不超过18。
 如果有多个结果，返回最小的那个。
 */
public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void nearestPalindromic() {
        assertEquals("121", solution.nearestPalindromic("123"));
    }

    @Test
    public void nearestPalindromi1c() {
        assertEquals("0", solution.nearestPalindromic("1"));
    }

    @Test
    public void nearestPalindromi2c() {
        assertEquals("9", solution.nearestPalindromic("10"));
    }
}