package edu.smith.cs.csc212.sorting;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class MergeSort {
	
	
	
	public static ListADT<Integer> RecursiveMergeSort(ListADT<Integer> input) {
		if (input.size() == 1) {
			return input;
		}
		ListADT<Integer> slice1 = input.slice(0, input.size()/2);
		System.out.println("slice 1 = "+slice1);
		ListADT<Integer> slice2 = input.slice(input.size()/2, input.size());
		System.out.println("slice 2 = "+slice2);
		
		slice1 = RecursiveMergeSort(slice1);
		slice2 = RecursiveMergeSort(slice2);
		
		ListADT<Integer> combined = Combine(slice1, slice2);
		System.out.println("combined = "+combined);
		return combined;
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
