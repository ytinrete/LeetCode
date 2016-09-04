package com.ytinrete.algorithm.my;

import java.util.Scanner;

/**
 * Created by lirui on 16/6/4.
 */
public class Numbers {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String a = sc.next();
    long b = sc.nextLong();
    int size = a.length();

    int[] arr = new int[size + 1];

    for (int i = 0; i < size; i++) {
      arr[i + 1] = a.charAt(i) - '0';
    }

    if (arr[1] == 1) {
      System.out.println(a);
      return;
    }

    int tmp = 0;

    while (b > 0) {
      tmp = arr[1];

      for (int i = 1; i < tmp; i++) {
        arr[i] = arr[i + 1];
      }

      arr[tmp] = tmp;

      b--;
    }

    for (int i = 1; i <= size; i++) {
      System.out.print(arr[i]);
    }


  }


}
