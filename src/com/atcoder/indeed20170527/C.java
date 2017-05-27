package com.atcoder.indeed20170527;

/**
 * C - Binary Tree
 * Time limit : 2sec / Memory limit : 256MB
 * <p>
 * Score : 100 points
 * <p>
 * Problem Statement
 * You are given a binary tree with N vertices.
 * <p>
 * A binary tree is a data structure that represents hierarchical relationship.
 * Each vertex in a binary tree has at most one parent and at most two children.
 * Those two children are called the left child and the right child. There exists only one vertex that does not have a parent, which is called the root.
 * <p>
 * Figure 1 shows an example of a binary tree. In this figure, the black vertex is the root of the tree.
 * Each of the blue edges connects a vertex and its left child; each red edge connects a vertex and its right child.
 * <p>
 * <p>
 * Figure 1. an example of a binary tree
 * <p>
 * In the given binary tree, the left child of vertex i (1≤i≤N) is vertex li, and the right child is vertex ri.
 * Here, the value of li may be 0, which means that vertex i does not have a left child. Similarly,
 * the value of ri is 0 if vertex i does not have a right child. The root of the tree is vertex 1.
 * <p>
 * Find the path from vertex 1 to vertex K when it is possible to move from a vertex to its left or right child. (This path always exists.)
 * <p>
 * Constraints
 * 1≤N≤105
 * 1≤K≤N
 * 0≤li,ri≤N
 * All input values are integers.
 * The input corresponds to a valid binary tree.
 * Vertex 1 is the root of the tree.
 * Input
 * Input is given from Standard Input in the following format:
 * <p>
 * N K
 * l1 r1
 * :
 * lN rN
 * Output
 * Print a string S that represents a path starting at vertex 1 and ending at vertex K. The i-th character should correspond to the i-th move.
 * Use the following characters to represent a move:
 * <p>
 * L: a move to the left child
 * R: a move to the right child
 * Sample Input 1
 * Copy
 * 6 6
 * 2 3
 * 4 5
 * 6 0
 * 0 0
 * 0 0
 * 0 0
 * Sample Output 1
 * Copy
 * RL
 * The binary tree given in this input is shown in the following figure:
 * <p>
 * df506d00e9a3cf6d8d2cdabb5f977480.png
 * The path from vertex 1 to vertex K=6 is 1 → 3 → 6, and thus the output should be RL.
 * <p>
 * Sample Input 2
 * Copy
 * 7 2
 * 2 6
 * 3 4
 * 0 0
 * 0 0
 * 0 0
 * 5 7
 * 0 0
 * Sample Output 2
 * Copy
 * L
 * Sample Input 3
 * Copy
 * 10 10
 * 0 2
 * 3 0
 * 0 4
 * 5 0
 * 6 0
 * 0 7
 * 8 0
 * 0 9
 * 10 0
 * 0 0
 * Sample Output 3
 * Copy
 * RLRLLRLRL
 * Submit
 * <p>
 * Personal Information Tutorial Rules Glossary FAQ
 * Powered by AtCoder.
 */
public class C {
}
