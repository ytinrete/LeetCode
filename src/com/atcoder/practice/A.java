package com.atcoder.practice;

/**
 * Created by lirui on 17/4/14.
 */

import java.util.Scanner;

/**
 * A - はじめてのあっとこーだー（Welcome to AtCoder）
 * Time limit : 2sec / Memory limit : 256MB
 * <p>
 * Problem
 * Your task is to process some data.
 * You are given 3 integers a , b , c and a string s. Output result of a+b+c and string s with a half-width break.
 * <p>
 * Input
 * Input will be given in the following format from Standard Input:
 * <p>
 * a
 * b c
 * s
 * On the first line, you will be given a integer a(1≦a≦1,000).
 * The second line, two integers b and c (1≦b,c≦1,000) will be given to you with a half-width break.
 * And the final line, a string s will given to you. If we define the length of string s as |s| , it is guaranteed 1≦|s|≦100.
 * Output
 * Output the result of a+b+c and string s with a half-width break in one line.
 * <p>
 * Also, make sure to insert a line break at the end of the output.
 */
public class A {

  public static void main(String args[]) {
    new A().solution();
  }

  private void solution() {
    Scanner sc = new Scanner(System.in);
    // get a integer
    int a = sc.nextInt();
    // get two integers separated with half-width break
    int b = sc.nextInt();
    int c = sc.nextInt();
    // get a string
    String s = sc.next();
    // output
    System.out.println((a + b + c) + " " + s);
  }

}

/*
 *


import java.util.*;
public class Main {
	public static void main(String[] args){



	}
}


 *
 *
 */
