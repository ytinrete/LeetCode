package com.ytinrete.algorithm.my;

/**
 * Created by ytinrete on 16/2/10.  92
 */
public class EightQueenProblem {

  public static final int SIZE = 8;
  public static int totalQueen = 0;

  public static void main(String s[]) {

    EightQueenProblem instance = new EightQueenProblem();

    instance.printSuccessEightQueen(0, new int[SIZE][SIZE]);

    System.out.println("Total Queen:" + totalQueen);

  }


  void printSuccessEightQueen(int currentLevel, int currentMap[][]) {

    if (currentLevel == SIZE) {
      //got the answer on current map
      printMap(currentMap);
      totalQueen++;
      return;
    }

    int currentLevelPlus = currentLevel + 1;

    // choose everyPos that might be fitted
    for (int choosePos : getSuccessPosList(currentLevel, currentMap)) {
      printSuccessEightQueen(currentLevelPlus, getNewMap(choosePos, currentLevel, currentMap));
    }

  }


  //return the posList that may fit the new queen, return empty array if the pos not exist
  int[] getSuccessPosList(int currentLevel, int currentMap[][]) {

    //making mask map to cover all pos that is not available

    int maskMap[][] = new int[SIZE][SIZE];

    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        if (currentMap[i][j] == 1) {
          maskMapOnPos(i, j, maskMap);

        }
      }
    }

    int currentLevelLine[] = maskMap[currentLevel];
    int resCount = 0;
    for (int value : currentLevelLine) {
      if (value == 0)
        resCount++;
    }

    if (resCount == 0)
      return new int[0];
    else {
      int res[] = new int[resCount];
      int i = 0;
      for (int j = 0; j < SIZE; j++) {

        if (currentLevelLine[j] == 0) {
          res[i] = j;
          i++;
        }

      }
      return res;
    }

  }

  //mark all unavailable pos with current pos
  void maskMapOnPos(final int line, final int pos, int[][] maskMap) {
    //self
    maskMap[line][pos] = 1;
    //line
    for (int i = 0; i < SIZE; i++) {
      maskMap[line][i] = 1;
    }
    //pos
    for (int i = 0; i < SIZE; i++) {
      maskMap[i][pos] = 1;
    }

    //left up
    int i = line, j = pos;
    while (i >= 0 && j >= 0) {
      maskMap[i][j] = 1;
      i--;
      j--;
    }

    //right up
    i = line;
    j = pos;
    while (i >= 0 && j < SIZE) {
      maskMap[i][j] = 1;// !!!!!!!!!!!!
      i--;
      j++;
    }

    //left down
    i = line;
    j = pos;
    while (i < SIZE && j >= 0) {
      maskMap[i][j] = 1;
      i++;
      j--;
    }

    //right down
    i = line;
    j = pos;
    while (i < SIZE && j < SIZE) {
      maskMap[i][j] = 1;
      i++;
      j++;
    }




  }


  //make a new map and mark it with choosePos, return newMap
  int[][] getNewMap(int choosePos, int currentLevel, int currentMap[][]) {

    int newMap[][] = new int[SIZE][SIZE];
    mapCopy(newMap, currentMap);
    newMap[currentLevel][choosePos] = 1;
//    printMap(newMap);
    return newMap;
  }

  //copy two maps
  void mapCopy(int[][] newMap, int[][] oldMap) {

    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        newMap[i][j] = oldMap[i][j];
      }
    }
  }

  void printMap(int[][] map) {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        System.out.print(map[i][j]);
      }
      System.out.println();
    }

    System.out.println();
  }


}
