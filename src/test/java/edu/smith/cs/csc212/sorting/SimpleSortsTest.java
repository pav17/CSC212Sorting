package edu.smith.cs.csc212.sorting;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.sorting.SimpleSorts;

import edu.smith.cs.csc212.sorting.SortTestingHelpers;
import me.jjfoley.adt.ListADT;

public class SimpleSortsTest {

	@Test
	public void testSelectionSort() {
		ListADT<Integer> sortMe = SortTestingHelpers.getData();
		int originalSize = sortMe.size();
		ListADT<Integer> sorted = SimpleSorts.SelectionSort(sortMe);
		
		Assert.assertEquals(originalSize, sorted.size());
		Assert.assertEquals(true, SortTestingHelpers.checkSorted(sorted, originalSize));
	}
	
	@Test
	public void testInsertionSort() {
		ListADT<Integer> sortMe = SortTestingHelpers.getData();
		int originalSize = sortMe.size();
		ListADT<Integer> sorted = SimpleSorts.InsertionSort(sortMe);
		
		Assert.assertEquals(originalSize, sorted.size());
		Assert.assertEquals(true, SortTestingHelpers.checkSorted(sorted, originalSize));
	}
}
