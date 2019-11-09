package edu.smith.cs.csc212.sorting;

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
		
		sorted.shuffle();
		sorted = MergeSort.RecursiveMergeSort(sorted);
		Assert.assertEquals(true, SortTestingHelpers.checkSorted(sorted, originalSize));
	}
	
	@Test
	public void stressTestRecursiveMergeSort () {
		Random rand = new Random();
		ListADT<Integer> sortMe = new JavaList<Integer>();
		for (int i = 0; i < 10000; i++) {
			sortMe.addBack(rand.nextInt());
		}
		ListADT<Integer> sorted = MergeSort.RecursiveMergeSort(sortMe);
		Assert.assertEquals(10000, sorted.size());
		Assert.assertEquals(true, SortTestingHelpers.checkSorted(sorted, 10000));
		
	}
	
	@Test
	public void testIterativeMergeSort() {
		ListADT<Integer> sortMe = SortTestingHelpers.getData();
		int originalSize = sortMe.size();
		ListADT<Integer> sorted = MergeSort.IterativeMergeSort(sortMe);
		
		Assert.assertEquals(originalSize, sorted.size());
		Assert.assertEquals(true, SortTestingHelpers.checkSorted(sorted, originalSize));
		
		sorted.shuffle();
		sorted = MergeSort.IterativeMergeSort(sorted);
		Assert.assertEquals(true, SortTestingHelpers.checkSorted(sorted, originalSize));
	}
	
	@Test
	public void stressTestIterativeMergeSort () {
		Random rand = new Random();
		ListADT<Integer> sortMe = new JavaList<Integer>();
		for (int i = 0; i < 10000; i++) {
			sortMe.addBack(rand.nextInt());
		}
		ListADT<Integer> sorted = MergeSort.IterativeMergeSort(sortMe);
		Assert.assertEquals(10000, sorted.size());
		Assert.assertEquals(true, SortTestingHelpers.checkSorted(sorted, 10000));
		
	}
}
