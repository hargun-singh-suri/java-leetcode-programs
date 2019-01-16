/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstLinkedList = l1;
        ListNode secondLinkedList = l2;
        int firstLinkedListLength = getLength(firstLinkedList);
        int secondLinkedListLength = getLength(secondLinkedList);

        //Get length of each Linked List
        if (firstLinkedListLength == 0) {
            return secondLinkedList;
        } else if (secondLinkedListLength == 0) {
            return firstLinkedList;
        }

        //Check for master linked list and child linked list based on the length of linked list
        if (firstLinkedListLength >= secondLinkedListLength) {
            return createLinkList(firstLinkedList, secondLinkedList);
        } else {
            return createLinkList(secondLinkedList, firstLinkedList);
        }

    }
    int getLength(ListNode linkedList) {
        int length = 0;
        while (linkedList != null) {
            linkedList = linkedList.next;
            length++;
        }
        return length;
    }

    ListNode createLinkList(ListNode masterLinkedList, ListNode childLinkedList) {
        ListNode head = null; // Head of newly created linked list this will be returned
        ListNode tail = null; // Tail of newly created linked list this will be used for iteration
        int remainder = 0; //Value which will be set as node in linked list
        int carry = 0; // Value which will be used as carry

        while (masterLinkedList != null) {
            //Linked list with smaller length can be part of iteration under linked list with greater length
            if (childLinkedList != null) {
                int sum = masterLinkedList.val + childLinkedList.val + carry;
                carry = (sum) / 10;
                remainder = (sum) % 10;
                childLinkedList = childLinkedList.next;
            } else {
                int sum = masterLinkedList.val + carry;
                carry = (sum) / 10;
                remainder = (sum) % 10;
            }

            //Create node here
            if (head != null) {
                ListNode temp = new ListNode(remainder);
                tail.next = temp;
                tail = temp;
            } else {
                ListNode temp = new ListNode(remainder);
                temp.next = null;
                tail = temp;
                head = temp;
            }

            masterLinkedList = masterLinkedList.next;

            //Check if there is no node from greater linked list and there exists a carry create node and break
            if (masterLinkedList == null && carry != 0) {
                ListNode temp = new ListNode(carry);
                tail.next = temp;
                tail = temp;
                break;
            }
        }

        return head;

    }


}