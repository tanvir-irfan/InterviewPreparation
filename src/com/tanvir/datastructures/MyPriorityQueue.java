package com.tanvir.datastructures;

import java.util.ArrayList;

public class MyPriorityQueue {

	private ArrayList<Integer> heap;
	private int size;

	MyPriorityQueue() {
		heap = new ArrayList<>();
		size = 0;
	}

	public int peek() {
		if (isEmpty())
			throw new IllegalArgumentException();

		return heap.get(0);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public int deleteMin() {
		if (isEmpty())
			throw new IllegalArgumentException();
		
		int min = heap.get(0);
		
		heap.set(0, heap.get(size - 1));
		heap.remove(size - 1);
		size--;
		
		bubbleDown(0);
		
		return min;
	}
	
	private void bubbleDown(int pos) {
		int leftChildIndex = 2 * pos + 1;
		int rightChildIndex = 2 * pos + 2;
		
		// there is no left child of the parent.
		if(leftChildIndex >= size) return;
		
		// there is left child, but no right child
		// and if that is the case then check whether 
		// left child needs to swap or not.
		if(rightChildIndex >= size) {
			if(heap.get(pos) <= heap.get(leftChildIndex)) {
				return;
			} else {
				swap(leftChildIndex, pos);
				bubbleDown(leftChildIndex);
			}
		} else {
			int posToSwap = heap.get(leftChildIndex) <= heap.get(rightChildIndex) ? leftChildIndex : rightChildIndex;
			
			if(heap.get(posToSwap) < heap.get(pos)) {
				swap(posToSwap, pos);
				bubbleDown(posToSwap);
			}
		}
		
	}
	
	public boolean insert(int value) {

		heap.add(value);
		size++;

		bubbleUp(value, size - 1);

		return true;
	}

	private void bubbleUp(int value, int pos) {
		if (pos == 0)
			return;

		while (true) {
			int parent = (pos - 1) / 2;

			if (heap.get(parent) > value) {
				swap(parent, pos);
				pos = parent;
			} else {
				return;
			}

			if (pos == 0)
				return;
		}
	}

	private void swap(int x, int y) {
		int temp = heap.get(x);
		
		heap.set(x, heap.get(y));
		heap.set(y, temp);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyPriorityQueue mpq = new MyPriorityQueue();

//		mpq.insert(10);
//
//		testQueue(mpq);
//
//		mpq.insert(5);
//
//		testQueue(mpq);
//
//		mpq.insert(15);
//
//		testQueue(mpq);
//
//		mpq.insert(2);
//
//		testQueue(mpq);
//		
//		System.out.println(mpq.deleteMin());
//
//		testQueue(mpq);
		
		for(int i = 100; i > 0; i--) {
			mpq.insert(i);
		}
		
		int [] sortedArray = new int[100];
		int index = 0;
		while(!mpq.isEmpty()) {
			sortedArray[index++] = mpq.deleteMin();
		}
		
		for(int i = 0; i <100; i++) {
			System.out.println(sortedArray[i] + " ");
		}
	}

	public static void testQueue(MyPriorityQueue mpq) {

		System.out.println("###############################################");
		System.out.println(mpq.size());
		System.out.println(mpq.isEmpty());

		System.out.println(mpq.peek());
	}

}
