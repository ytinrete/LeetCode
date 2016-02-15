package com.ytinrete.algorithm.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {

  public static void main(String args[]) {

    LongestCommonPrefix instance = new LongestCommonPrefix();

    String strs[] = new String[]{"aa", "a", "abc"};

    System.out.println(instance.longestCommonPrefix(strs));

  }


  public String longestCommonPrefix(String[] strs) {

    if (strs == null || strs.length == 0)
      return "";

    int l = strs.length;
    int pos = 0;
    char tmp;
    boolean isContinue = true;

    while (isContinue) {

      if (pos < strs[0].length()) {
        tmp = strs[0].charAt(pos);
        for (int i = 1; i < l; i++) {
          if (pos >= strs[i].length() || strs[i].charAt(pos) != tmp) {
            isContinue = false;
            break;
          }
        }
      } else
        isContinue = false;


      if (isContinue)
        pos++;
    }

    return strs[0].substring(0, pos);

  }

}
