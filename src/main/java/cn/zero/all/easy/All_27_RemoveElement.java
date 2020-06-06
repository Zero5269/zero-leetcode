
package cn.zero.all.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [3,2,2,3], val = 3,
 * <p>
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * <p>
 * 注意这五个元素可为任意顺序。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 *  
 * <p>
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class All_27_RemoveElement {

    public int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int temp = 0;

        if (nums[nums.length - 1] == val) {
            nums[nums.length - 1] = 1;
        } else {
            temp = nums[nums.length - 1];
            nums[nums.length - 1] = 0;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == val && nums[nums.length - 1] == 0) {
                nums[i] = temp;
                nums[nums.length - 1] = 1;
                break;
            }
        }
        if (nums[nums.length - 1] == 0) {
            nums[nums.length - 1] = temp;
            return nums.length;
        }
        temp = nums.length - 2;
        for (int i = 0; i < temp; i++) {
            if (nums[i] == val) {
                for (int j = temp; j > i; j--) {
                    if (nums[j] != val) {
                        temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        temp = j-1;
                        break;
                    }
                    temp = j-1;
                }
            }
        }

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == val) {
                nums[nums.length - 1] = nums[nums.length - 1] + 1;
            }
        }
        return nums.length - nums[nums.length - 1];
    }

    @Test
    public void test() {
        int[] nums = new int[]{3, 2, 2, 3};
        int target = 3;
        int i = removeElement(nums, target);
        Assert.assertEquals(i, 2);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test1() {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int target = 2;
        int i = removeElement(nums, target);
        Assert.assertEquals(i, 5);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test2() {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int target = 9;
        int i = removeElement(nums, target);
        Assert.assertEquals(i, 8);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test3() {
        int[] nums = new int[]{};
        int target = 0;
        int i = removeElement(nums, target);
        Assert.assertEquals(i, 0);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test4() {
        int[] nums = new int[]{3, 3};
        int target = 3;
        int i = removeElement(nums, target);
        Assert.assertEquals(i, 0);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test5() {
        int[] nums = new int[]{2, 2, 2};
        int target = 2;
        int i = removeElement(nums, target);
        Assert.assertEquals(i, 0);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }
    @Test
    public void test6() {
        int[] nums = new int[]{2, 2, 3};
        int target = 2;
        int i = removeElement(nums, target);
        Assert.assertEquals(i, 1);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

}