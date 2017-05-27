package com.atcoder.indeed20170527;

/**
 * D - Move Pieces
 Time limit : 2sec / Memory limit : 256MB

 Score : 100 points

 Problem Statement
 You are given a sequence of N integers, a. Each element in a is an integer between 1 and N (inclusive).

 Based on this sequence, we will conduct the following simulation using N boxes and N pieces:

 At time 0, put piece i in box i, for all i (1≤i≤N).
 During the transition from time t to time t+1, move all the pieces in box i to box ai, for all i (1≤i≤N).
 For each piece, what box contains it at time T?

 Constraints
 1≤N≤105
 1≤ai≤N
 0≤T≤1018
 All input values are integers.
 Partial Score
 30 points will be awarded for passing all the test cases satisfying 1≤N≤1000 and 0≤T≤1000.
 Input
 Input is given from Standard Input in the following format:

 N T
 a1
 :
 aN
 Output
 Print N lines. The i-th line (1≤i≤N) should contain the index of the box that contains piece i.

 Sample Input 1
 Copy
 5 7
 2
 3
 4
 5
 2
 Sample Output 1
 Copy
 4
 5
 2
 3
 4
 Each piece moves as follows:

 Piece 1: box 1 → box 2 → box 3 → box 4 → box 5 → box 2 → box 3 → box 4
 Piece 2: box 2 → box 3 → box 4 → box 5 → box 2 → box 3 → box 4 → box 5
 Piece 3: box 3 → box 4 → box 5 → box 2 → box 3 → box 4 → box 5 → box 2
 Piece 4: box 4 → box 5 → box 2 → box 3 → box 4 → box 5 → box 2 → box 3
 Piece 5: box 5 → box 2 → box 3 → box 4 → box 5 → box 2 → box 3 → box 4
 Sample Input 2
 Copy
 8 1000
 2
 3
 4
 5
 6
 7
 8
 8
 Sample Output 2
 Copy
 8
 8
 8
 8
 8
 8
 8
 8
 Sample Input 3
 Copy
 10 1000000000000000000
 1
 6
 4
 6
 9
 7
 8
 3
 5
 4
 Sample Output 3
 Copy
 1
 4
 3
 4
 5
 6
 7
 8
 9
 3
 This test case is not included in the test set for the partial score.
 */
public class D {
}
