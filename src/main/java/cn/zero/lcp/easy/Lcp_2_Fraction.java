package cn.zero.lcp.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * LCP 02. 分式化简
 * 有一个同学在学习分式。他需要将一个连分数化成最简分数，你能帮助他吗？
 * <p>
 * <p>
 * <p>
 * 连分数是形如上图的分式。在本题中，所有系数都是大于等于0的整数。
 * <p>
 *  
 * <p>
 * 输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：cont = [3, 2, 0, 2]
 * 输出：[13, 4]
 * 解释：原连分数等价于3 + (1 / (2 + (1 / (0 + 1 / 2))))。注意[26, 8], [-13, -4]都不是正确答案。
 * 示例 2：
 * <p>
 * 输入：cont = [0, 0, 3]
 * 输出：[3, 1]
 * 解释：如果答案是整数，令分母为1即可。
 * 限制：
 * <p>
 * cont[i] >= 0
 * 1 <= cont的长度 <= 10
 * cont最后一个元素不等于0
 * 答案的n, m的取值都能被32位int整型存下（即不超过2 ^ 31 - 1）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/deep-dark-fraction
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Lcp_2_Fraction {

    int[] cont = null;

    public int[] fraction(int[] cont) {
        this.cont = cont;
        return getNum(0);
    }

    private int[] getNum(int index) {
        int[] ints = new int[2];
        if (index == cont.length - 1) {
            if (cont.length == 1) {
                ints[0] = cont[cont.length - 1];
                ints[1] = 1;
            } else {
                ints[0] = 1;
                ints[1] = cont[cont.length - 1];
            }
            return ints;
        }
        int cont = this.cont[index];
        index = index + 1;
        int[] ints1 = getNum(index);
        int n = ints1[0];
        int m = ints1[1];
        if (index > 1) {
            ints[0] = m;
            ints[1] = m * cont + n;
        } else {
            ints[0] = m * cont + n;
            ints[1] = m;
        }
        return ints;
    }

    @Test
    public void test() {
        int[] cont = {3, 2, 0, 2};
        int[] fraction = fraction(cont);
        System.out.println(Arrays.toString(fraction));
        Assert.assertArrayEquals(fraction, new int[]{13, 4});
    }

    @Test
    public void test1() {
        int[] cont = {0, 0, 3};
        int[] fraction = fraction(cont);
        System.out.println(Arrays.toString(fraction));
        Assert.assertArrayEquals(fraction, new int[]{3, 1});
    }

    @Test
    public void test2() {
        int[] cont = {2147483647};
        int[] fraction = fraction(cont);
        System.out.println(Arrays.toString(fraction));
        Assert.assertArrayEquals(fraction, new int[]{2147483647, 1});
    }

}