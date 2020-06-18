package cn.zero.leetcode.all.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 3. 无重复字符的最长子串-滑动窗口
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载TODO请注明出处。
 */

public class All_3_LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int length = chars.length;
        int max = 0;
        if (length <= 1) {
            return length;
        }
        for (int i = 0; i < length - 1; i++) {
            char aChar = chars[i];
            set.add(aChar);
            int len = 1;
            for (int j = i + 1; j < length; j++) {
                if (!set.contains(chars[j])) {
                    len = len + 1;
                    set.add(chars[j]);
                } else {
                    break;
                }
            }
            set.clear();
            max = max > len ? max : len;
        }
        return max;
    }

    @Test
    public void test() {
        String sub = "abcabcbb";
        int str = lengthOfLongestSubstring(sub);
        Assert.assertEquals(str, 3);
        System.out.println(str);
    }

    @Test
    public void test1() {
        String sub = "bbbbb";
        int str = lengthOfLongestSubstring(sub);
        Assert.assertEquals(str, 1);
        System.out.println(str);
    }

    @Test
    public void test2() {
        String sub = "pwwkew";
        int str = lengthOfLongestSubstring(sub);
        Assert.assertEquals(str, 3);
        System.out.println(str);
    }

    @Test
    public void test3() {
        String sub = "aab";
        int str = lengthOfLongestSubstring(sub);
        Assert.assertEquals(str, 2);
        System.out.println(str);
    }

    @Test
    public void test4() {
        String sub = " ";
        int str = lengthOfLongestSubstring(sub);
        Assert.assertEquals(str, 1);
        System.out.println(str);
    }


}