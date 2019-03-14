package com.tanvir.datastructures;

import java.util.PriorityQueue;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

class MergeKList {
    public ListNode mergeKLists(ListNode[] lists) {
        
        
        if(lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<PQNode> pq = new PriorityQueue<>();
        addallFirstNode(lists, pq);
        
        ListNode head = null;
        ListNode curResNode = null;
        
        while(!pq.isEmpty()) {
            PQNode curNode = pq.poll();
            
            if(head == null) {
                head = curNode.node;
                curResNode = head;
            } else {
                curResNode.next = curNode.node;
                curResNode = curResNode.next;
            }
            
            
            if(lists[curNode.listId] != null) {
                
                ListNode nextNode = lists[curNode.listId];
                lists[curNode.listId] = lists[curNode.listId].next;
                
                PQNode nextPQNode = new PQNode( curNode.listId, nextNode);
                
                pq.offer( nextPQNode );
            }
        }             
                         
        return head;
    }
    
    private void addallFirstNode(ListNode[] lists, PriorityQueue<PQNode> pq) {
    	if(lists == null || lists.length == 0 || pq == null) {
    		return;
    	}
    	
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                pq.offer(new PQNode( i, lists[i]));
                lists[i] = lists[i].next;
            }
        }
    }
    
    class PQNode implements Comparable<PQNode>{
        int listId;
        ListNode node;
        
        PQNode(int listId, ListNode node) {
            this.listId = listId;
            this.node = node;
        }
        
        public int compareTo(PQNode other) {
        	return this.node.val - other.node.val;
        }
    }
}