package com.wqy.面试题整理;

import java.util.Arrays;

/**
 * 升序排列 数组 num[]{5,1,1,2,0,0}
 */
public class Test1 {
    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
        //用数组工具排序
//        Arrays.sort(nums);
//        Arrays.stream(nums).forEach(a -> System.out.print(a + " "));

        bubble(nums);
    }

    /**
     * 冒泡排序
     *
     * @param nums
     */
    public static void bubble(int[] nums) {
        for (int j = 0; j < nums.length - 1; j++) {
            for (int i = 0; i < nums.length - 1; i++) {
                int a = nums[i];
                if (nums[i] > nums[i + 1]) {
                    nums[i] = nums[i + 1];
                    nums[i + 1] = a;
                }
            }
        }
        Arrays.stream(nums).forEach(a -> System.out.print(a + " "));
    }
}
