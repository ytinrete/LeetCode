package com.ytinrete.algorithm;


/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * <p>
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

public class ZigZagConversion {

  public static void main(String args[]) {

    ZigZagConversion instance = new ZigZagConversion();

    System.out.println(instance.convert1("PAYPALISHIRING", 3));


  }

  /*
  lowest sln
   */
  public String convert1(String s, int numRows) {

    if (numRows < 2)
      return s;


    char matrix[][] = new char[s.length() / 2 + 2][numRows + 1];

    boolean forward = true;
    int row = 0;
    int column = 1;

    for (int i = 1; i <= s.length(); i++) {

      if (forward)
        row++;
      else {
        row--;
        column++;
      }

      if (row == numRows + 1) {
        row = numRows - 1;
        forward = false;
        column++;
      }

      if (row == 1) {
        forward = true;
      }

      matrix[column][row] = s.charAt(i - 1);


    }

    StringBuffer res = new StringBuffer("");

    for (int i = 1; i < numRows+1; i++) {
      for (int j = 1; j < s.length() / 2 + 2; j++) {

        if (matrix[j][i] > 0)
          res.append(matrix[j][i]);
      }
    }


    return res.toString();

  }

}
