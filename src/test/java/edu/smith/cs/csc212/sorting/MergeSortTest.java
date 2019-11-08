package edu.smith.cs.csc212.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.sorting.MergeSort;

import edu.smith.cs.csc212.sorting.SortTestingHelpers;
import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class MergeSortTest {

	@Test
	public void testRecursiveMergeSort() {
		ListADT<Integer> sortMe = SortTestingHelpers.getData();
		int originalSize = sortMe.size();
		ListADT<Integer> sorted = MergeSort.RecursiveMergeSort(sortMe);
		Assert.assertEquals(originalSize, sorted.size());
		Assert.assertEquals(true, SortTestingHelpers.checkSorted(sorted, originalSize));
	}
	
	@Test
	public void testMergeSort() {
		ListADT<Integer> sortMe = SortTestingHelpers.getData();
		int originalSize = sortMe.size();
		ListADT<Integer> sorted = MergeSort.IterativeMergeSort(sortMe);
		Assert.assertEquals(originalSize, sorted.size());
		Assert.assertEquals(true, SortTestingHelpers.checkSorted(sorted, originalSize));
	}
}
