package com.ytinrete.algorithm;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * <p>
 * click to show spoilers.
 * <p>
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * <p>
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * <p>
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer",
 * you know that the reversed integer might overflow. How would you handle such case?
 * <p>
 * There is a more generic way of solving this problem.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Math
 * Hide Similar Problems (E) Palindrome Linked List
 */
public class PalindromeNumber {

  public static void main(String args[]) {

    PalindromeNumber instance = new PalindromeNumber();

    System.out.println(instance.isPalindrome1(11));

  }

  public boolean isPalindrome1(int x) {

    if (x < 0)
      return false;

    if (x < 10)
      return true;

    int tmp = x;

    int res = 0;

    int pos = 0;

    while (tmp > 0) {
      pos = tmp % 10;
      if (res > (Integer.MAX_VALUE - pos) / 10)
        return false;
      res = res * 10 + pos;
      tmp /= 10;
    }

    if (res == x)
      return true;

    return false;

  }
}
