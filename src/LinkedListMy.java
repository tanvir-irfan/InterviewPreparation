import java.util.HashSet;
import java.util.Stack;

public class LinkedListMy {

	public static void main(String[] s) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(7);

		// head = new LinkedList().oddEvenList(head);
		//
		// System.out.println(head.val);

		System.out.println(new LinkedListMy().reverseBetween(head, 1, 4));
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode mMinusOne = null;
		ListNode cur = head;

		while (--m > 0) {
			mMinusOne = cur;
			cur = cur.next;
			n--;
		}

		ListNode mNode = cur;

		// cutting off the list;
		// mMinusOne.next = null;

		ListNode prev = null;
		ListNode next = null;

		while (--n >= 0) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}

		mNode.next = next;
		if (mMinusOne != null) {
			mMinusOne.next = prev;
			return mMinusOne;
		} else {
			return prev;
		}

	}

	boolean isPalindrome(ListNode head) {
		// Your code here
		if (head == null || head.next == null) {
			return true;
		}
		// at this point we know there at least two nodes are there.
		// 1 -> 2 ->
		ListNode middle = head;
		ListNode fast = head;
		ListNode middlePrev = null;

		// finding the middle point of the linked list
		while (fast != null) {
			fast = fast.next;

			middlePrev = middle;
			middle = middle.next;

			if (fast == null) {
				break;
			}
			fast = fast.next;
		}

		// System.out.println(prev.data);
		// System.out.println(middle.data);
		// reverse the linked list from the middle point
		ListNode prev = null;
		ListNode cur = middle;
		fast = cur.next;

		while (cur != null) {
			fast = cur.next;

			cur.next = prev;
			prev = cur;
			cur = fast;
		}
		// linking the reversed list with the original list
		middlePrev.next = prev;
		boolean res = true;

		ListNode curH = head;
		while (prev != null) {
			if (curH.val != prev.val) {
				res = false;
				break;
			}
			prev = prev.next;
			curH = curH.next;
		}
		return res;
	}

	public ListNode rev(ListNode root) {
		if (root == null || root.next == null) {
			return root;
		}

		ListNode headNext = root.next;

		ListNode newRoot = rev(root.next);
		root.next = null;
		headNext.next = root;

		return newRoot;
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		HashSet<ListNode> memory = new HashSet<>();
		ListNode cur = headA;
		while (cur != null) {
			memory.add(cur);
			cur = cur.next;
		}

		cur = headB;
		while (cur != null) {
			if (memory.contains(cur)) {
				return cur;
			}
			cur = cur.next;
		}

		return null;
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode evenH = null, evenC = null, oddH = null, oddC = null;

		int count = 0;

		ListNode cur = head;

		while (cur != null) {
			if (count % 2 == 1) {
				if (evenH == null) {
					evenH = cur;
					cur = cur.next;

					evenC = evenH;
					evenC.next = null;

				} else {
					evenC.next = cur;
					cur = cur.next;
					evenC = evenC.next;
					evenC.next = null;
				}
			} else {
				if (oddH == null) {
					oddH = cur;
					cur = cur.next;

					oddC = oddH;
					oddC.next = null;
				} else {
					oddC.next = cur;
					cur = cur.next;
					oddC = oddC.next;
					oddC.next = null;
				}
			}

			count++;
		}

		oddC.next = evenH;
		return oddH;
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		Stack<ListNode> stack = new Stack<>();
		ListNode headN = null;
		ListNode headNCur = null;

		ListNode cur = head;

		while (cur != null) {

			if (stack.isEmpty() || stack.peek().val == cur.val) {
				stack.push(cur);
			} else {
				if (stack.size() > 1) {
					stack.clear();
					stack.push(cur);
				} else {
					// that means only one element was in the stack
					if (headN == null) {
						headN = stack.pop();
						headN.next = null;
						headNCur = headN;
						stack.push(cur);
					} else {
						headNCur.next = stack.pop();
						headNCur = headNCur.next;
						headNCur.next = null;
						stack.push(cur);
					}
				}
			}
			cur = cur.next;
		}

		if (stack.size() == 1) {
			if (headN == null) {
				headN = stack.pop();
			} else {
				headNCur.next = stack.pop();
			}
		}

		return headN;
	}

	static ListNode reverseR(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = reverseR(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}

	static ListNode Reverse(ListNode head) {
		ListNode prev = null; // Previous Pointer
		ListNode cur = head; // Current Node
		ListNode nxt = null; // Next Pointer
		while (cur != null) {
			nxt = cur.next;
			cur.next = prev;
			prev = cur;
			cur = nxt;
		}
		head = prev;
		return head;
	}

	static int FindMergeNode(ListNode headA, ListNode headB) {

		ListNode cA = countNodeAndReturnLast(headA);
		ListNode cB = countNodeAndReturnLast(headB);

		if (cA.next != cB.next)
			return 0;

		ListNode curA = headA;
		ListNode curB = headB;
		int diff = Math.abs(cA.val - cB.val);

		while (diff-- > 0) {
			if (cA.val > cB.val) {
				curA = curA.next;
			} else {
				curB = curB.next;
			}
		}

		while (curA != curB) {
			curA = curA.next;
			curB = curB.next;
		}

		return curA != null ? curA.val : null;
	}

	static ListNode countNodeAndReturnLast(ListNode head) {
		ListNode res = new ListNode();
		if (head == null)
			return res;

		int count = 1;
		while (head.next != null) {
			head = head.next;
			count++;
		}
		res.next = head;
		res.val = count;

		return res;
	}

	boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}
		}

		return false;
	}

	ListNode ReverseDubly(ListNode head) {
		ListNode cur = head;
		ListNode newHead = head;
		while (cur != null) {
			ListNode prev = cur.prev;
			cur.prev = cur.next;
			cur.next = prev;
			newHead = cur;
			cur = cur.prev;
		}
		return newHead;
	}

}
