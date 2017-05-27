package com.atcoder.indeed20170513;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lirui on 17/5/13.
 * <p>
 * B - Mixing
 * Time limit : 2sec / Memory limit : 256MB
 * <p>
 * Score : 100 points
 * <p>
 * Problem Statement
 * We have N ingredients, numbered 1 through N, used in making medicines. We will compound two medicines
 * using these ingredients. Each medicine will be made by mixing K ingredients chosen from the N ingredients we have.
 * Here, it is not possible to use an ingredient in both medicines at the same time.
 * <p>
 * There are M rules that decide the efficacy of a medicine. The i-th rule is represented by a tuple of three integers (ai,bi,ui).
 * Based on these rules, the efficacy of a medicine is calculated as below:
 * <p>
 * (efficacy) = (the sum of ui over all i such that both ingredients ai and bi are used in the medicine)
 * Here, if there does not exist i such that both ingredients ai and bi are used in the medicine, the efficacy of the medicine is 0.
 * <p>
 * Find the maximum possible sum of the efficacies of the two medicines that we will compound.
 * <p>
 * Constraints
 * All input values are integers.
 * 4≤N≤8
 * 2≤K≤N⁄2
 * 1≤M≤N(N−1)⁄2
 * 1≤ai<bi≤N
 * All pairs (ai,bi) are distinct.
 * 1≤ui≤100
 * Input
 * Input is given from Standard Input in the following format:
 * <p>
 * N K M
 * a1 b1 u1
 * a2 b2 u2
 * :
 * aM bM uM
 * Output
 * Print the maximum possible sum of the efficacies of the two medicines that will be compounded.
 * <p>
 * Sample Input 1
 * Copy
 * 5 2 4
 * 1 2 20
 * 1 3 10
 * 2 4 10
 * 2 5 15
 * Sample Output 1
 * Copy
 * 25
 * The efficacy of the medicine compounded from ingredients 1 and 3 is 10, and the efficacy of the medicine compounded
 * from ingredients 2 and 5 is 15. These two medicine can be compounded at the same time for a total efficacy of 25, which is the maximum possible sum.
 * <p>
 * Sample Input 2
 * Copy
 * 7 3 3
 * 1 2 10
 * 1 3 10
 * 2 3 10
 * Sample Output 2
 * Copy
 * 30
 * The efficacy of the medicine compounded from ingredients 1, 2 and 3 is 10+10+10=30. If this medicine is compounded,
 * no matter what ingredients is used to compound the other medicine, the efficacy of that other medicine will be 0.
 * The total efficacy will be 30 in this case, which is the maximum possible sum.
 * <p>
 * Sample Input 3
 * Copy
 * 8 4 8
 * 1 2 10
 * 2 3 20
 * 3 4 30
 * 4 5 40
 * 5 6 50
 * 6 7 60
 * 7 8 70
 * 1 8 80
 * Sample Output 3
 * Copy
 * 300
 */
public class B {

  public static void main(String args[]) {
    new B().solution();
  }

  private void solution() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int m = sc.nextInt();

//    ruleMatrix = new int[n + 1][n + 1];

    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int u = sc.nextInt();

      RulePare r = new RulePare();
      r.a = a;
      r.b = b;
      r.u = u;

      ruleSeq.add(r);

//      ruleMatrix[a][b] = u;

    }

    int chooseFrom[] = new int[n];
    for (int i = 0; i < n; i++) {
      chooseFrom[i] = i + 1;
    }
    makeSequence(new int[0], k * 2, chooseFrom);

    calMax(k, n);

    System.out.print(max);

  }


  private void calMax(int k, int chooseFromSize) {

    for (IntArrCell cell : seq) {

      int cur[] = cell.a;
      int tmpMax;
      int buckA[] = new int[chooseFromSize+1];
      int buckB[] = new int[chooseFromSize+1];
      for (int i = 0; i < k; i++) {
        buckA[cur[i]] = 1;
      }

      for (int i = k; i < k * 2; i++) {
        buckB[cur[i]] = 1;
      }

      tmpMax = calSubMax(buckA) + calSubMax(buckB);
      if (tmpMax > max) {
        max = tmpMax;
      }

    }
  }

  int calSubMax(int container[]) {
    int total = 0;

    for (RulePare r : ruleSeq) {
      if (container[r.a] != 0 && container[r.b] != 0) {
        total += r.u;
      }
    }
    return total;
  }


  class RulePare {
    int a;
    int b;
    int u;
  }

  static ArrayList<RulePare> ruleSeq = new ArrayList<>();


  static int max = 0;

  class IntArrCell {
    int a[];
  }

//  static int ruleMatrix[][];

  static ArrayList<IntArrCell> seq = new ArrayList<>();

  private void makeSequence(int current[], int requestSize, int chooseFrom[]) {
    // size 4, 6, 8
    //choose 4, 5, 6, 7, 8

    if (current.length == requestSize) {
      IntArrCell a = new IntArrCell();
      a.a = current;
      seq.add(a);

//      for (int i = 0; i <current.length ; i++) {
//        System.out.print(current[i]);
//      }
//      System.out.println();

    } else {
      for (int i = 0; i < chooseFrom.length; i++) {
        int pickUp = chooseFrom[i];
        int newCurrent[] = new int[current.length + 1];
        for (int j = 0; j < current.length; j++) {
          newCurrent[j] = current[j];
        }
        newCurrent[current.length] = pickUp;

        int newChooseFrom[];

        if (chooseFrom.length - 1 == 0) {
          newChooseFrom = new int[0];
        } else {
          newChooseFrom = new int[chooseFrom.length - 1];
          int count = 0;
          for (int j = 0; j < chooseFrom.length; j++) {
            if (chooseFrom[j] != pickUp) {
              newChooseFrom[count] = chooseFrom[j];
              count++;
            }
          }
        }
        makeSequence(newCurrent, requestSize, newChooseFrom);
      }
    }
  }


}
