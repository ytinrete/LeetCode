package com.ytinrete.algorithm.easy;

/**
 * Implement atoi to convert a string to an integer.
 * <p>
 * Hint: Carefully consider all possible input cases.
 * If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * <p>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
 * You are responsible to gather all the input requirements up front.
 * <p>
 * Update (2015-02-10):
 * The signature of the C++ function had been updated.
 * If you still see your function signature accepts a const char * argument,
 * please click the reload button  to reset your code definition.
 * <p>
 * spoilers alert... click to show requirements for atoi.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Math String
 * Hide Similar Problems (E) Reverse Integer (H) Valid Number
 * <p>
 * <p>
 * <p>
 * int atoi (const char * str);
 * Convert string to integer
 * Parses the C-string str interpreting its content as an integral number, which is returned as a value of type int.
 * <p>
 * The function first discards as many whitespace characters (as in isspace) as necessary until the first non-whitespace
 * character is found. Then, starting from this character, takes an optional initial plus or minus sign
 * followed by as many base-10 digits as possible, and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number,
 * which are ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters,
 * no conversion is performed and zero is returned.
 */
public class StringToInteger {

  public static void main(String args[]) {
    StringToInteger instance = new StringToInteger();

    System.out.println(instance.myAtoi("-2147483648"));


  }


  public int myAtoi(String str) {

    //preproduce mode
    int type = 1;
    int res = 0;
    boolean isPositive = true;
    char tmp;
    for (int i = 0; i < str.length(); i++) {
      tmp = str.charAt(i);
      switch (type) {
        case 1:

          if (!isSpace(tmp)) {
            if (tmp == '-' || tmp == '+') {
              type = 2;
              if (tmp == '-')
                isPositive = false;
            } else if ('0' <= tmp && tmp <= '9') {
              type = 2;
              res += tmp - '0';
            } else {
              //invalid input
              return 0;
            }
          }

          break;

        case 2:
          // digital mode
          if (isSpace(tmp)) {
            type = 3;
          } else if ('0' <= tmp && tmp <= '9') {

            if (isPositive) {
              if (res > (Integer.MAX_VALUE - (tmp - '0')) / 10)
                return Integer.MAX_VALUE;
              else {
                res *= 10;
                res += tmp - '0';
              }
            } else {
              if (-res < (Integer.MIN_VALUE + (tmp - '0')) / 10)
                return Integer.MIN_VALUE;
              else {
                res *= 10;
                res += tmp - '0';
              }
            }

          } else
            type = 3;

          break;
        case 3:
          break;

      }

      if (type == 3)
        break;


    }

    if (!isPositive)
      res = -res;

    return res;

  }

  private boolean isSpace(char input) {
    if (input == ' ' || input == '\0' || input == '\n')
      return true;
    else
      return false;
  }
}
