package edu.smith.cs.csc212.sorting;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class MergeSort {
	
	
	
	public static ListADT<Integer> RecursiveMergeSort(ListADT<Integer> input) {
		ListADT<Integer> output = new JavaList<Integer>();
		if (input.size() > 1) {
			
		}
		return output;
	}
	
	private static ListADT<Integer> Combine(ListADT<Integer> input1, ListADT<Integer> input2) {
		ListADT<Integer> output = new JavaList<Integer>();
		while (true) {
			if (input1.size() > 0 && input2.size() > 0) {
				if (input1.getFront() >= input2.getFront()) {
					output.addBack(input1.removeFront());
				} else {
					output.addBack(input2.removeFront());
				}
			} else if (input1.size() == 0) {
				for (int i = 0; i < input2.size(); i++) {
					output.addBack(input2.removeFront());
				}
				break;
			} else if (input2.size() == 0) {
				for (int i = 0; i < input1.size(); i++) {
					output.addBack(input1.removeFront());
				}
				break;
			}
		}
		return output;
	}
}
