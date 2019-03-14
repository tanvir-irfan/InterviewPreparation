// https://leetcode.com/problems/merge-two-sorted-lists/description/
// Merge two sorted linked lists and return it as a new list. 
// The new list should be made by splicing together the nodes of the first two lists.

// Input: 1->2->4, 1->3->4
// Output: 1->1->2->3->4->4

public class _MergeSortedLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);

		ListNode l2 = new ListNode(1);
		l1.next = new ListNode(3);
		l1.next.next = new ListNode(4);

		_MergeSortedLinkedList m = new _MergeSortedLinkedList();
		m.mergeTwoLists(l1, l2);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}

		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		ListNode head = null;
		ListNode cur = null;

		// 1->2->4, 1->3->4
		// iter : 1; l1(1), l2(1)
		// temp = l1 (1); l1 = 2
		// head = (1); cur (1); 1 -> null

		// iter : 2; l1(2), l2(1)
		// temp = l2 (2); l2 = 3
		// head = (1); cur (2); 1 -> 2 -> null

		while (l1 != null && l2 != null) {
			ListNode temp = (l1.val <= l2.val) ? l1 : l2;

			if (l1 == temp) {
				l1 = l1.next;
			} else if (l2 == temp) {
				l2 = l2.next;
			}

			if (head == null) {
				head = temp;
				cur = temp;
				temp.next = null;
			} else {
				cur.next = temp;
				cur = cur.next;
				cur.next = null;
			}
		}

		if (l1 == null && l2 == null) {
			return head;
		}

		if (l1 == null) {
			cur.next = l2;
		}

		if (l2 == null) {
			cur.next = l1;
		}

		return head;
	}

}
