package com.ytinrete.algorithm.medium;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * <p>
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

  public static void main(String a[]) {
    System.out.println(new LongestSubstringWithoutRepeatingCharacters()
        .lengthOfLongestSubstring("aaaa"));//abcdecfehijk

  }

  public int lengthOfLongestSubstring(String s) {

    int index = 0;
    int end = 0;
    int windowSize = 0;

    int[] matrix = new int[1000];
    for (int i = 0; i < matrix.length; i++) {
      matrix[i] = -1;
    }

    while (index < s.length()) {

      if (matrix[s.charAt(index)] != -1) {
        // exist

        //jump until no repeating characters in windowSize + 1

        int lastIndex = index;
        int hitPot = matrix[s.charAt(index)];
        end = index - windowSize;

        int targetIndex = hitPot + windowSize + 1;
        boolean jumpSuccess;
        while (targetIndex < s.length()) {
          jumpSuccess = true;
          for (int i = end; i <= hitPot; i++) {
            matrix[s.charAt(i)] = -1;
            //wipe dirty data
          }
          ///window move
          end = hitPot + 1;

          for (int i = lastIndex; i <= targetIndex; i++) {
            if (matrix[s.charAt(i)] == -1) {
              if (i != targetIndex) {
                //i==targetIndex leave to outside loop
                matrix[s.charAt(i)] = i;
              }

            } else {
              //this jump fail,jump again
              hitPot = matrix[s.charAt(i)];
              targetIndex = hitPot + windowSize + 1;
              lastIndex = i;
              jumpSuccess = false;
              break;
            }
          }
          if (jumpSuccess) {
            index = targetIndex;
            break;
          }

        }

        if (targetIndex >= s.length()) {
          //current answer is the best, can not go further
          return windowSize;
        }

      } else {
        // not esist
        matrix[s.charAt(index)] = index;
        windowSize++;
        index++;

      }


    }
    return windowSize;
  }


}
