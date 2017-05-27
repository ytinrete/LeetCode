package com.atcoder.indeed20170527;

/**
 * A - Room Number
 * Time limit : 2sec / Memory limit : 256MB
 * <p>
 * Score : 100 points
 * <p>
 * Problem Statement
 * There is an N-story building that has ai rooms on the i-th floor (1≤i≤N). In order to distinguish the rooms on each floor,
 * we will assign a positive integer called the room number to each room. Two rooms on the same floor must be assigned different room numbers,
 * but rooms on different floors may have the same room number. However, for cultural reasons,
 * there are M integers that cannot be used as room numbers. These forbidden numbers are bj (1≤i≤M).
 * <p>
 * For each floor, we would like to assign room numbers so that the largest room number on the floor would be as small as possible.
 * Find the smallest possible value of the largest room number on each floor.
 * <p>
 * Constraints
 * 1≤N≤100
 * 1≤ai≤100(1≤i≤N)
 * 1≤M≤100
 * 1≤bj≤100(1≤j≤M)
 * bj<bj+1(1≤j<M)
 * All input values are integers.
 * Input
 * Input is given from Standard Input in the following format:
 * <p>
 * N M
 * a1
 * :
 * aN
 * b1
 * :
 * bM
 * Output
 * Print N lines. The i-th line (1≤i≤N) should contain the largest room number on the i-th floor when it is minimized.
 * <p>
 * Sample Input 1
 * Copy
 * 5 2
 * 1
 * 2
 * 3
 * 4
 * 5
 * 2
 * 4
 * Sample Output 1
 * Copy
 * 1
 * 3
 * 5
 * 6
 * 7
 * The room number of a room in this building is 1, 3, 5, 6 or 7.
 * <p>
 * Sample Input 2
 * Copy
 * 5 5
 * 5
 * 10
 * 15
 * 20
 * 25
 * 2
 * 4
 * 6
 * 8
 * 10
 * Sample Output 2
 * Copy
 * 9
 * 15
 * 20
 * 25
 * 30
 */
public class A {
}
