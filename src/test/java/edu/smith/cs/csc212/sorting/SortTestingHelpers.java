package edu.smith.cs.csc212.sorting;

import java.util.Random;

import org.junit.Assert;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

/**
 * No tests in this file -- just some data & methods you might want to use!
 * @author jfoley
 */
public class SortTestingHelpers {

	/**
	 * This is useful for testing whether sort algorithms work!
	 * @param items - the list of integers.
	 * @param originalSize - what size the list should be!
	 * @return true if it is sorted, false if not.
	 */
	public static boolean checkSorted(ListADT<Integer> items, int originalSize) {
		Assert.assertEquals(originalSize, items.size());
		for (int i=0; i<items.size()-1; i++) {
			if (items.getIndex(i) > items.getIndex(i+1)) {
				System.err.println("items out of order: "+items.getIndex(i)+", "+items.getIndex(i+1) + " at index="+i);
				return false;
			}
		}
		return true;
	}

	/**
	 * Here's some data!
	 */
	public static int[] data = {9,8,4,7,6,5,4,3,2,1};

	/**
	 * Get the static data as a ListADT!
	 * @return [9,8,4,7,6,5,4,3,2,1]
	 */
	public static ListADT<Integer> getData() {
		ListADT<Integer> sortMe = new JavaList<>();
		for (int y : SortTestingHelpers.data) {
			sortMe.addBack(y);
		}
		return sortMe;
	}
}
