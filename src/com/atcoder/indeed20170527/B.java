package com.atcoder.indeed20170527;

/**
 * B - Candy Order
 * Time limit : 2sec / Memory limit : 256MB
 * <p>
 * Score : 100 points
 * <p>
 * Problem Statement
 * You are an owner of a candy shop. There are N candies in stock at time 0.
 * <p>
 * You will receive 3T requests from time 1 through time T, all of which needs to be handled.
 * On each time i, there are three request that ask for Ai, Bi and Ci candies, respectively.
 * <p>
 * The requests needs to be handled in the order they are received. The three requests received at the same time may be handled in any order of your choice.
 * The handling of a request is as follows:
 * <p>
 * Let K be the number of candies ordered.
 * If there are K or more candies in stock, the request will be accepted. The number of candies in stock will be decreased by K.
 * Otherwise, the request will be denied. The number of candies in stock will remain unchanged.
 * You would like to maximize the number of accepted requests by handling the requests in the optimal order.
 * Find the maximum possible number of accepted requests.
 * <p>
 * Constraints
 * 1≤N≤20
 * 1≤T≤5
 * 1≤Ai,Bi,Ci≤N(1≤i≤T)
 * All input values are integers.
 * Input
 * Input is given from Standard Input in the following format:
 * <p>
 * N T
 * A1 B1 C1
 * :
 * AT BT CT
 * Output
 * Find the maximum possible number of accepted requests.
 * <p>
 * Sample Input 1
 * Copy
 * 10 2
 * 2 4 6
 * 1 1 1
 * Sample Output 1
 * Copy
 * 5
 * You can accept 5 requests as follows:
 * <p>
 * Time 1: handle the requests in the order of A1=2, B1=4 and C1=6. The first and second requests are accepted, and the third is denied.
 * The number of candies in stock becomes 4.
 * Time 2: handle the requests in the order of A1=1, B1=1 and C1=1. All three requests are accepted. The number of candies in stock becomes 1.
 * Sample Input 2
 * Copy
 * 20 1
 * 6 7 7
 * Sample Output 2
 * Copy
 * 3
 * Sample Input 3
 * Copy
 * 10 3
 * 6 7 10
 * 10 4 10
 * 1 1 1
 * Sample Output 3
 * Copy
 * 4
 */
public class B {
}
