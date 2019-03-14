
public class ListNode/* implements Comparable<ListNode>*/{
	int key;
	int val;
	ListNode next;
	ListNode prev;
	ListNode() {
		this(0);
	}

	ListNode(int val) {
		this.val = val;
		this.next = null;
		this.prev = null;
	}
	
	ListNode (int key, int val) {
		this.key = key;
		this.val = val;
		this.next = null;
		this.prev = null;
	}

	public String toString() {
		return this.val + "";
	}

}
