//class Node {
//	int value;
//	Node next;
//	
//	public Node(int val) {
//		this.value = val;
//	}
//}

public class LastNthElement {
	
	public static void main(String[] args) {
		ListNode cur;
		ListNode head = new ListNode(1);
		cur = head;

		for (int i = 2; i <= 5; i++) {
			cur.next = new ListNode(i);
			cur = cur.next;
		}

		for (int i = 5; i >= -1; i--) {
			System.out.println("Iteration for = " + i);
			ListNode no = findNthLast2Pass(head, i);
			System.out.println(no);
			no = findNthLast(head, i);
			System.out.println(no);
		}

	}

	public static ListNode findNthLast2Pass(ListNode head, int n) {
		int count = 0;
		ListNode cur = head;
		while (cur != null) {
			count++;
			cur = cur.next;
		}

		if (n >= count)
			return null;

		cur = head;

		int index = count - n;

		for (int i = 1; i < index; i++) {
			cur = cur.next;
		}

		return cur;
	}

	public static ListNode findNthLast(ListNode head, int n) {
		if(n < 0) return null;
		ListNode cur = head;
		ListNode f = null;
		if (n == 0)
			f = head;

		int index = 0;

		while (cur != null) {
			cur = cur.next;
			index++;
			if (index == n && cur != null)
				f = head;
			if (index > n && cur != null) {
				f = f.next;
			}

		}

		return f;
	}

}
