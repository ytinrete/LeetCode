package com.ytinrete.algorithm.easy;

/**
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Math String
 * Hide Similar Problems (M) Integer to Roman
 * <p>
 * Roman numerals, as used today, are based on seven symbols:[1]
 * <p>
 * Symbol	Value
 * I	1
 * V	5
 * X	10
 * L	50
 * C	100
 * D	500
 * M	1,000
 * Numbers are formed by combining symbols and adding the values, so II is two (two ones)
 * and XIII is thirteen (a ten and three ones). There is no zero in this system and characters do not represent tens,
 * hundreds and so on according to position as in 207 or 1066;
 * those numbers are written as CCVII (two hundreds, a five and two ones)
 * and MLXVI (a thousand, a fifty, a ten, a five and a one).
 * <p>
 * <p>
 * Symbols are placed from left to right in order of value, starting with the largest.
 * However, in a few specific cases,[2] to avoid four characters being repeated in succession (such as IIII or XXXX),
 * subtractive notation is often used as follows:[3][4]
 * <p>
 * I placed before V or X indicates one less, so four is IV (one less than five) and nine is IX (one less than ten)
 * X placed before L or C indicates ten less, so forty is XL (ten less than fifty) and ninety is XC (ten less than a hundred)
 * C placed before D or M indicates a hundred less, so four hundred is CD (a hundred less than five hundred)
 * and nine hundred is CM (a hundred less than a thousand)[5]
 * For example, MCMIV is one thousand nine hundred and four, 1904 (M is a thousand, CM is nine hundred and IV is four).
 * <p>
 * Some examples of the modern use of Roman numerals include:
 * <p>
 * 1954 as MCMLIV, as in the trailer for the movie The Last Time I Saw Paris[6]
 * 1990 as MCMXC, used as the title of musical project Enigma's debut album MCMXC a.D., named after the year of its release.
 * 2014 as MMXIV, the year of the games of the XXII (22nd) Olympic Winter Games (in Sochi)
 */
public class RomanToInteger {

  public static void main(String args[]) {

    RomanToInteger instance = new RomanToInteger();
    System.out.println();

  }

  public int romanToInt(String s) {

    int res = 0;
    char tmp;
    int l = s.length();
    for (int i = 0; i < l; i++) {
      tmp = s.charAt(i);

      switch (tmp) {
        case 'M':
          res += 1000;
          break;
        case 'D':
          res += 500;
          break;
        case 'C':
          if (i + 1 < l && (s.charAt(i + 1) == 'D' || (s.charAt(i + 1) == 'M')))
            res -= 100;
          else
            res += 100;
          break;
        case 'L':
          res += 50;
          break;
        case 'X':
          if (i + 1 < l && (s.charAt(i + 1) == 'L' || (s.charAt(i + 1) == 'C')))
            res -= 10;
          else
            res += 10;
          break;
        case 'V':
          res += 5;
          break;
        case 'I':
          if (i + 1 < l && (s.charAt(i + 1) == 'V' || (s.charAt(i + 1) == 'X')))
            res -= 1;
          else
            res += 1;
          break;
        default:
          break;
      }
    }

    return res;

  }


}
