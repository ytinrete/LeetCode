package com.atcoder.practice;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by lirui on 17/4/14.
 */
public class B {

  public static void main(String args[]) {

    solution();
  }

  static int q;
  static Scanner sc;

  private static void solution() {

    char cArr[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    sc = new Scanner(System.in);
    // get a integer
    int size = sc.nextInt();

    char arr[] = new char[size];

    for (int i = 0; i < size; i++) {
      arr[i] = cArr[i];
    }

//    makeTestChar(arr);

    q = sc.nextInt();

    if (size == 5 && q == 7) {
      enumSortChar(arr);

    } else if (q == 100) {
      mergeSortChar(arr, 0, arr.length-1);
    } else {
      quickSortChar(arr, 0, arr.length - 1);
    }

    System.out.print("! ");
    for (char c : arr) {
      System.out.print(c);
    }
    System.out.println();

  }

  //A B C D E
  //0 1 2 3 4

  private static void enumSortChar(char[] arr) {
    char pair1[] = new char[2];
    char pair2[] = new char[2];

    if (isBigger(arr[0], arr[1])) {
      pair1[0] = arr[0];
      pair1[1] = arr[1];
    } else {
      pair1[0] = arr[1];
      pair1[1] = arr[0];
    }

    if (isBigger(arr[2], arr[3])) {
      pair2[0] = arr[2];
      pair2[1] = arr[3];
    } else {
      pair2[0] = arr[3];
      pair2[1] = arr[2];
    }

    char trip[] = new char[3];
    char left;
    if (isBigger(pair1[0], pair2[0])) {
      //p1(0)-p2(0)-p2(1)
      trip[0] = pair1[0];
      trip[1] = pair2[0];
      trip[2] = pair2[1];
      left = pair1[1];
    } else {
      //p2(0)-p1(0)-p1(1)
      trip[0] = pair2[0];
      trip[1] = pair1[0];
      trip[2] = pair1[1];
      left = pair2[1];
    }

    char quart[] = new char[4];
    int eTakeUp;
    if (isBigger(arr[4], trip[1])) {
      //e>trp(1)
      if (isBigger(arr[4], trip[0])) {
        //e-tip(0)-tip(1)-tip(2)
        eTakeUp = 0;
      } else {
        //tip(0)-e-tip(1)-tip(2)
        eTakeUp = 1;
      }
    } else {
      //e<trp(1)
      if (isBigger(arr[4], trip[2])) {
        //tip(0)-tip(1)-e-tip(2)
        eTakeUp = 2;
      } else {
        //tip(0)-tip(1)-tip(2)-e
        eTakeUp = 3;
      }
    }

    int tmpCount = 0;
    for (int i = 0; i < 4; i++) {
      if (i == eTakeUp) {
        quart[i] = arr[4];
      } else {
        quart[i] = trip[tmpCount];
        tmpCount++;
      }
    }

    //left mark must not on first so just need to compare to quart[1,2,3]

    if (isBigger(left, quart[2])) {
      //l>q2
      if (isBigger(left, quart[1])) {
        // q0-l-q1-q2-q3
        arr[0] = quart[0];
        arr[1] = left;
        arr[2] = quart[1];
        arr[3] = quart[2];
        arr[4] = quart[3];

      } else {
        // q0-q1-l-q2-q3
        arr[0] = quart[0];
        arr[1] = quart[1];
        arr[2] = left;
        arr[3] = quart[2];
        arr[4] = quart[3];

      }
    } else {
      //l<q2
      if (isBigger(left, quart[3])) {
        // q0-q1-q2-l-q3
        arr[0] = quart[0];
        arr[1] = quart[1];
        arr[2] = quart[2];
        arr[3] = left;
        arr[4] = quart[3];

      } else {
        // q0-q1-q2-q3-l
        arr[0] = quart[0];
        arr[1] = quart[1];
        arr[2] = quart[2];
        arr[3] = quart[3];
        arr[4] = left;

      }
    }

    //从小到大
    swap(arr, 0, 4);
    swap(arr, 1, 3);
  }

  private static void mergeSortChar(char[] arr, int left, int right) {
//    System.out.println("leftL" + left + " right:" + right);

    if (left < right) {
      int center = (left + right) / 2;
      mergeSortChar(arr, left, center);
      mergeSortChar(arr, center + 1, right);
      mergeSortMerge(arr, left, center, right);
    }
  }

  private static void mergeSortMerge(char[] arr, int left, int center, int right) {
    char merge[] = new char[right - left + 1];
    int indexLeft = left;
    int indexRight = center + 1;
    for (int i = 0; i < merge.length; i++) {
      if (indexLeft > center && indexRight > right) {
        throw new IllegalStateException();
      } else {
        if (indexLeft > center) {
          merge[i] = arr[indexRight];
          indexRight++;
        } else if (indexRight > right) {
          merge[i] = arr[indexLeft];
          indexLeft++;
        } else {
          if (isBigger(arr[indexLeft], arr[indexRight])) {
            merge[i] = arr[indexRight];
            indexRight++;
          } else {
            merge[i] = arr[indexLeft];
            indexLeft++;
          }
        }
      }
    }
    for (int i = left; i <= right; i++) {
      arr[i] = merge[i - left];
    }
  }


  private static void swap(char[] arr, int a, int b) {
    char tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }


  private static void quickSortChar(char[] arr, int left, int right) {

    if (left <= right) {
      //正常情况
      char target = arr[left];
      int i = left;
      int j = right;
      char tmp = 0;

      while (i < j) {
        while (i < j && isBigger(arr[j], target)) {
          j--;
        }
        if (i == j) {
          break;
        }
        swap(arr, i, j);
        i++;

        while (i < j && !isBigger(arr[i], target)) {
          i++;
        }
        if (i == j) {
          break;
        }
        swap(arr, i, j);
        j--;
      }

      //排左边
      quickSortChar(arr, left, i - 1);

      //排右边
      quickSortChar(arr, i + 1, right);

    }
  }

  private static boolean isBigger(char a, char b) {

//    if(true){
//      return a>b;
//    }

    if (q == 0) {
      throw new IllegalStateException();
    }
    q--;
    System.out.println("? " + a + " " + b);
    String s = sc.next();
    if (">".equals(s)) {
      return true;
    } else {
      return false;
    }

  }


  private static void makeTestChar(char arr[]) {
    int size = arr.length;
    for (int i = 0; i < 500; i++) {

      int randomNumA = ThreadLocalRandom.current().nextInt(0, size - 1 + 1);
      int randomNumB = ThreadLocalRandom.current().nextInt(0, size - 1 + 1);

      char tmp = arr[randomNumA];
      arr[randomNumA] = arr[randomNumB];
      arr[randomNumB] = tmp;
    }
  }

  private static boolean isBiggerTest(char a, char b) {
    System.out.println(a + " " + b + " " + (a > b));
    return a > b;
  }


  private static void test() {
    B b = new B();

    for (int i = 0; i < 100; i++) {
      int testCase[] = b.makeTestCase();
      b.quickSortReverse(testCase, 0, testCase.length - 1);

      for (int w : testCase) {
        System.out.print(w + " | ");
      }
      System.out.println();

      for (int j = 0; j < testCase.length - 1; j++) {
        if (testCase[j] < testCase[j + 1]) {
          throw new IllegalStateException();
        }
      }


    }
  }


  private void quickSort(int arr[], int left, int right) {
//    System.out.println("l" + left + " r" + right);
    if (left <= right) {
      //正常情况
      int target = arr[left];
      int i = left;
      int j = right;

      int tmp = 0;

      while (i < j) {


        while (arr[j] > target && i < j) {
          j--;
        }

        if (i == j) {
          break;
        }

        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

        i++;


        while (arr[i] < target && i < j) {
          i++;
        }

        if (i == j) {
          break;
        }

        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

        j--;


      }
      //到这里i和j应该相等
//      System.out.println("i:" + i + " j:" + j);
//
////      arr[left] = arr[i];
////      arr[i] = target;
//
//
//      System.out.println("------");
//      for (int test : arr) {
//        System.out.print(test + " | ");
//      }
//      System.out.println();
//      System.out.println("------");

      //排左边
      quickSort(arr, left, i - 1);

      //排右边
      quickSort(arr, i + 1, right);

    } else {
      //一个或没有元素
    }
  }


  private void quickSortReverse(int arr[], int left, int right) {
//    System.out.println("l" + left + " r" + right);
    if (left <= right) {
      //正常情况
      int target = arr[left];
      int i = left;
      int j = right;

      int tmp = 0;

      while (i < j) {


        while (arr[j] < target && i < j) {
          j--;
        }

        if (i == j) {
          break;
        }

        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

        i++;


        while (arr[i] > target && i < j) {
          i++;
        }

        if (i == j) {
          break;
        }

        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

        j--;


      }
      //到这里i和j应该相等
//      System.out.println("i:" + i + " j:" + j);
//
////      arr[left] = arr[i];
////      arr[i] = target;
//
//
//      System.out.println("------");
//      for (int test : arr) {
//        System.out.print(test + " | ");
//      }
//      System.out.println();
//      System.out.println("------");

      //排左边
      quickSortReverse(arr, left, i - 1);

      //排右边
      quickSortReverse(arr, i + 1, right);

    } else {
      //一个或没有元素
    }
  }


  private int[] makeTestCase() {

    int size = 26;

    int arr[] = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = i;
    }

    for (int i = 0; i < 500; i++) {

      int randomNumA = ThreadLocalRandom.current().nextInt(0, size - 1 + 1);
      int randomNumB = ThreadLocalRandom.current().nextInt(0, size - 1 + 1);

      int tmp = arr[randomNumA];
      arr[randomNumA] = arr[randomNumB];
      arr[randomNumB] = tmp;
    }

    for (int i : arr) {
//      System.out.print(i + " | ");
    }

    System.out.println();

    return arr;
  }


  private static char[] enumSortCharTest(char[] arr) {
    if (isBigger(arr[0], arr[1])) {
      //a>b
      if (isBigger(arr[2], arr[3])) {
        //c>d
        if (isBigger(arr[0], arr[2])) {
          //a>c : a-c-d
          if (isBigger(arr[4], arr[2])) {
            //e>c
            if (isBigger(arr[4], arr[0])) {
              //e>a: e-a-c-d
              if (isBigger(arr[1], arr[2])) {
                //b>c -> e-a-b-c-d
                return new char[]{'D', 'C', 'B', 'A', 'E'};
              } else {
                //b<c
                if (isBigger(arr[1], arr[3])) {
                  //b>d -> e-a-c-b-d
                  return new char[]{'D', 'B', 'C', 'A', 'E'};
                } else {
                  //b<d -> e-a-c-d-b
                  return new char[]{'B', 'D', 'C', 'A', 'E'};
                }
              }
            } else {
              //e<a: a-e-c-d
              if (isBigger(arr[1], arr[2])) {
                //b>c
                if (isBigger(arr[1], arr[4])) {
                  //b>e -> a-b-e-c-d
                  return new char[]{'D', 'C', 'E', 'B', 'A'};
                } else {
                  //b<e -> a-e-b-c-d
                  return new char[]{'D', 'C', 'B', 'E', 'A'};
                }
              } else {
                //b<c
                if (isBigger(arr[1], arr[3])) {
                  //b>d -> a-e-c-b-d
                  return new char[]{'D', 'B', 'C', 'E', 'A'};
                } else {
                  //b<d -> a-e-c-d-b
                  return new char[]{'B', 'D', 'C', 'E', 'A'};
                }
              }
            }
          } else {
            //e<c
            if (isBigger(arr[4], arr[3])) {
              //e>d : a-c-e-d
              if (isBigger(arr[1], arr[4])) {
                //b>e
                if (isBigger(arr[1], arr[2])) {
                  //b>c -> a-b-c-e-d
                } else {
                  //b<c -> a-c-b-e-d
                }
              } else {
                //b<e
                if (isBigger(arr[1], arr[3])) {
                  //b>d -> a-c-e-b-d
                } else {
                  //b<d -> a-c-e-d-b
                }
              }
            } else {
              //e<d : a-c-d-e
              if (isBigger(arr[1], arr[3])) {
                //b>d
                if (isBigger(arr[1], arr[2])) {
                  //b>c -> a-b-c-d-e
                } else {
                  //b<c -> a-c-b-d-e
                }
              } else {
                //b<d
                if (isBigger(arr[1], arr[4])) {
                  //b>e -> a-c-d-b-e
                } else {
                  //b<e -> a-c-d-e-b
                }
              }
            }
          }
        } else {
          //c>a : c-a-b
        }
      } else {
        //c<d
      }


    } else {
      //b>a
      if (isBigger(arr[2], arr[3])) {
        //c>d

      } else {
        //c<d
      }

    }

    return null;

  }


}
