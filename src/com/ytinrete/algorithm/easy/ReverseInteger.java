package com.ytinrete.algorithm.easy;

/**
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p>
 * click to show spoilers.
 * <p>
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * <p>
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * <p>
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 * <p>
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {

  public static void main(String args[]) {
    ReverseInteger a = new ReverseInteger();
    System.out.println(a.reverse(123456789));
  }

  public int reverse(int x) {

    boolean isNegtive = false;

    if (x < 0) {
      isNegtive = true;
      x = -x;
    }

    int res = 0;
    int currentPos = 0;

    while (x > 0) {
      currentPos = x % 10;

      if (res > (Integer.MAX_VALUE - currentPos) / 10) {
        return 0;
      }

      res = res * 10 + currentPos;

      x = x / 10;

    }

    if (isNegtive) {
      res = -res;
    }

    return res;

  }


}
