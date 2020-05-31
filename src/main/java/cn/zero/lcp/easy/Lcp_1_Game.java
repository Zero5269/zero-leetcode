package cn.zero.lcp.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * LCP 01. 猜数字
 * 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小A 猜对了几次？
 * <p>
 *  
 * <p>
 * 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：guess = [1,2,3], answer = [1,2,3]
 * 输出：3
 * 解释：小A 每次都猜对了。
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入：guess = [2,2,3], answer = [3,2,1]
 * 输出：1
 * 解释：小A 只猜对了第二次。
 *  
 * <p>
 * 限制：
 * <p>
 * guess的长度 = 3
 * answer的长度 = 3
 * guess的元素取值为 {1, 2, 3} 之一。
 * answer的元素取值为 {1, 2, 3} 之一。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/guess-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Lcp_1_Game {
    public int game(int[] guess, int[] answer) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            int guess1 = guess[i];
            int answer1 = answer[i];
            if (guess1 == answer1) {
                sum = sum + 1;
            }
        }
        return sum;
    }

    @Test
    public void test() {
        int[] guess = {1, 2, 3};
        int[] answer = {1, 2, 3};
        int game = game(guess, answer);
        Assert.assertEquals(game, 3);
        System.out.println(game);
    }

    @Test
    public void test1() {
        int[] guess = {2, 2, 3};
        int[] answer = {3, 2, 1};
        int game = game(guess, answer);
        Assert.assertEquals(game, 1);
        System.out.println(game);
    }

}