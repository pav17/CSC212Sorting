package edu.smith.cs.csc212.sorting;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class SimpleSorts {
	
	
	public static ListADT<Integer> SelectionSort(ListADT<Integer> input) {
		ListADT<Integer> output = new JavaList<Integer>();
		while (input.size() > 0) {
			int indexSmallest = 0;
			for (int i = 0; i < input.size(); i++) {
				if (input.size() == 1) {
					indexSmallest = 0;
					break;
				}
				if (input.getIndex(i) <= input.getIndex(indexSmallest)) {
					indexSmallest = i;
				}
			}
			output.addBack(input.removeIndex(indexSmallest));
		}
		return output;
	}
	
	public static ListADT<Integer> InsertionSort(ListADT<Integer> input) {
		ListADT<Integer> output = new JavaList<Integer>();
		while (input.size() > 0) {
			Integer value = input.removeFront();
			if (output.size() == 0) {
				System.out.println("adding " + value + " to the front of the empty list");
				output.addFront(value);
			} else {
				int outputSize = output.size();
				for (int i = 0; i <= outputSize; i++) {
					if (value > output.getIndex(i)) {
						System.out.println(value +" > "+output.getIndex(i)+", continuing");
						continue;
					} else {
						System.out.println("adding "+value+" to index "+i);
						output.addIndex(i, value);
						break;
					}
				}
			}
		}
		return output;
	}
}
