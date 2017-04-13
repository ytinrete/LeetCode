package com.ytinrete.algorithm.easy;


/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

public class TwoSum {

  public static void main(String args[]) {

    int test[] = {3, 2, 4};
    int target = 6;

    int res[] = new TwoSum().twoSum(test, target);

    System.out.println(res[0] + " " + res[1]);

  }

  public int[] twoSum(int[] nums, int target) {
    int count = nums.length;
    for (int i = 0; i < count; i++) {
      for (int j = i + 1; j < count; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return new int[]{0, 0};
  }


}
