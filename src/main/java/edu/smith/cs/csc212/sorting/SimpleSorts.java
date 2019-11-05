package edu.smith.cs.csc212.sorting;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class SimpleSorts {
	
	
	public static ListADT<Integer> SelectionSort(ListADT<Integer> input) {
		ListADT<Integer> output = new JavaList<Integer>();
		while (input.size() > 0) {
			int indexSmallest = 0;
			for (int i = 0; i < input.size(); i++) {
				if (input.getIndex(i) <= input.getIndex(indexSmallest)) {
					indexSmallest = i;
				}
			}
			output.addBack(input.removeIndex(indexSmallest));
		}
		return output;
	}
}
