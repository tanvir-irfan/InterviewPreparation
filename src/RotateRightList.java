
public class RotateRightList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		
		RotateRightList r = new RotateRightList();
		
		r.rotateRight(l1, 2);
	}
	
	public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }
        
        int len = findLen(head);
        
        k %= len;
        
        if (k == 0) {
            return head;
        }
        
        int forward = len - k;
        
        ListNode newHead = head;
        
        while(--forward >= 0) {
        	if(forward == 0) {
        		ListNode temp = newHead.next;
        		newHead.next = null;
        		newHead = temp;
        	} else {
        		newHead = newHead.next;
        	}
            
        }
        
        
        ListNode firstNext = newHead;
        
        while(firstNext.next != null) {
            firstNext = firstNext.next;
        }
        
        firstNext.next = head;
        
        return newHead;
    }
    
    private int findLen(ListNode head) {
        if(head == null) {
            return 0;
        }
        
        int len = 1;
        
        while(head.next != null) {
            len++;
            head = head.next;
        }
        
        return len;
    }

}
