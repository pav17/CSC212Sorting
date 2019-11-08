package edu.smith.cs.csc212.sorting;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class MergeSort {
	
	
	
	public static ListADT<Integer> RecursiveMergeSort(ListADT<Integer> input) {
		if (input.size() == 1) {
			return input;
		}
		ListADT<Integer> slice1 = input.slice(0, input.size()/2);
		ListADT<Integer> slice2 = input.slice(input.size()/2, input.size());
		
		slice1 = RecursiveMergeSort(slice1);
		slice2 = RecursiveMergeSort(slice2);
		
		ListADT<Integer> combined = Combine(slice1, slice2);
		return combined;
	}
	
	public static ListADT<Integer> IterativeMergeSort(ListADT<Integer> input) {
		ListADT<ListADT<Integer>> workQueue = new DoublyLinkedList<ListADT<Integer>>();
		
		while (!input.isEmpty()) {
			ListADT<Integer> tempList = new JavaList<Integer>();
			tempList.addBack(input.removeFront());
			workQueue.addBack(tempList);
		}
		
		while (true) {
			ListADT<Integer> combined = Combine(workQueue.removeFront(), workQueue.removeFront());
			workQueue.addBack(combined);
			if (workQueue.size() == 1) {
				break;
			}
		}
		return workQueue.getFront();
	}
	
	private static ListADT<Integer> Combine(ListADT<Integer> input1, ListADT<Integer> input2) {
		ListADT<Integer> output = new JavaList<Integer>();
		while (true) {
			if (input1.size() > 0 && input2.size() > 0) {
				if (input1.getFront() >= input2.getFront()) {
					output.addBack(input2.removeFront());
				} else {
					output.addBack(input1.removeFront());
				}
			} else if (input1.size() == 0) {
				while (!input2.isEmpty()) {
					output.addBack(input2.removeFront());
				}
				break;
			} else if (input2.size() == 0) {
				while (!input1.isEmpty()) {
					output.addBack(input1.removeFront());
				}
				break;
			}
		}
		return output;
	}
}
