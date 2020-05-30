package cn.zero.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 */
public class $1$TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int temp = target - num;
            Integer integer = map.get(temp);
            if (integer != null) {
                result = new int[]{integer, i};
            }
            map.put(num, i);
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = new int[]{-1, -2, -3, -4, -5};
        int target = -8;
        int[] ints = twoSum(nums, target);
        Assert.assertArrayEquals(ints, new int[]{2, 4});
        System.out.println(Arrays.toString(ints));
    }
}