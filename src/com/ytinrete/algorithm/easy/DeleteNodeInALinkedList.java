package com.ytinrete.algorithm.easy;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * <p>
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
 * the linked list should become 1 -> 2 -> 4 after calling your function.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Linked List
 * Hide Similar Problems (E) Remove Linked List Elements
 */
public class DeleteNodeInALinkedList {

  public static void main(String args[]) {
    DeleteNodeInALinkedList instace = new DeleteNodeInALinkedList();
  }

  public void deleteNode(ListNode node) {

    ListNode curNode = node;

    while (curNode.next != null && curNode.next.next != null) {
      curNode.val = curNode.next.val;
      curNode = curNode.next;
    }

    curNode.val = curNode.next.val;
    curNode.next = null;

  }

}


class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

