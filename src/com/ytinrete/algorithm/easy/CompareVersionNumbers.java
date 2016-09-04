package com.ytinrete.algorithm.easy;

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * <p>
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three",
 * it is the fifth second-level revision of the second first-level revision.
 * <p>
 * Here is an example of version numbers ordering:
 * <p>
 * 0.1 < 1.1 < 1.2 < 13.37
 */
public class CompareVersionNumbers {

  public static void main(String args[]) {
    CompareVersionNumbers instance = new CompareVersionNumbers();
    System.out.println(instance.compareVersion("3", "5"));

    System.out.println();

    label1:
    for (int i = 1; i < 5; i++) {
      System.out.println("i:" + i);
      for (int j = 10; j < 30; j += 5) {
        System.out.println("j:" + j);
        if (i == 2) {
          continue label1;
        }
        System.out.println("lalala j:" + j);

      }
    }


  }


  public int compareVersion(String version1, String version2) {

    if (version1 == null || version2 == null)
      return 0;

    String v1[] = version1.split(".");
    String v2[] = version2.split(".");

    return 1;

  }

}
