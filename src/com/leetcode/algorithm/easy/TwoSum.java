package com.leetcode.algorithm.easy;


import java.util.HashMap;
import java.util.Map;

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

  public int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < numbers.length; i++) {
      if (map.containsKey(target - numbers[i])) {
        result[1] = i + 1;
        result[0] = map.get(target - numbers[i]);
        return result;
      }
      map.put(numbers[i], i + 1);
    }
    return result;
  }


}
