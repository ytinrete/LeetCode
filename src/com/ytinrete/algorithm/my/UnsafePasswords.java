package com.ytinrete.algorithm.my;

import java.util.Scanner;

/**
 * Created by lirui on 16/6/4.
 */
public class UnsafePasswords {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    unsafePasswords(sc.next());
  }


  private static boolean isUnsafe(String ori, String tar, int matchCount) {

    StringBuffer sb = new StringBuffer(ori);

    for (int c = 0; c < tar.length(); c++) {
      String oriS = sb.toString();
      char tC = tar.charAt(c);
      for (int i = 0; i < oriS.length(); i++) {
        if (tC == oriS.charAt(i)) {
          sb.setCharAt(i, '0');
          matchCount--;
          break;
        }
      }
    }

    if (matchCount > 0) {
      return false;
    } else {
      return true;
    }
  }

  private static char getNum(int i) {
    switch (i) {
      case 0:
        return 'a';
      case 1:
        return 'b';
      case 2:
        return 'c';
      case 3:
        return 'd';
      default:
        return '0';
    }
  }


  private static void unsafePasswords(String s) {


    if ("".equals(s) || s == null) {
      return;
    }

    switch (s.length()) {

      case 1:
        System.out.println('a');
        System.out.println('b');
        System.out.println('c');
        System.out.println('d');
        break;

      case 2:
        for (int i = 0; i < 4; i++) {
          for (int j = 0; j < 4; j++) {
            String newOne = "";
            newOne += getNum(i);
            newOne += getNum(j);
            if (isUnsafe(s, newOne, 1)) {
              System.out.println(newOne);
            }
          }
        }

        break;

      case 3:
        for (int i = 0; i < 4; i++) {
          for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++) {
              String newOne = "";
              newOne += getNum(i);
              newOne += getNum(j);
              newOne += getNum(k);
              if (isUnsafe(s, newOne, 2)) {
                System.out.println(newOne);
              }
            }
          }
        }


        break;


      default:
        break;

    }


  }


}
