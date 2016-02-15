package com.ytinrete.algorithm.easy;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * For example:
 * <p>
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * <p>
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * <p>
 * Hint:
 * <p>
 * A naive implementation of the above process is trivial. Could you come up with other methods?
 * What are all the possible results?
 * How do they occur, periodically or randomly?
 * You may find this Wikipedia article useful.
 * <p>
 * https://en.wikipedia.org/wiki/Digital_root
 */
public class AddDigits {

  public static void main(String args[]) {

    AddDigits instance = new AddDigits();

    System.out.println(instance.addDigits1(562462));

  }

  public int addDigits(int num) {
    return (num - 9 * ((num - 1) / 9));
  }


  public int addDigits1(int num) {

    int res = num;
    int tmp = 0;

    while (res > 9) {

      tmp = res;
      res = 0;

      while (tmp > 0) {
        res += tmp % 10;
        tmp /= 10;
      }


    }

    return res;

  }

}
