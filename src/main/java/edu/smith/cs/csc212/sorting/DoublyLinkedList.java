package edu.smith.cs.csc212.sorting;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.errors.BadIndexError;
import me.jjfoley.adt.errors.TODOErr;

/**
 * A Doubly-Linked List is a list based on nodes that know of their successor and predecessor.
 * @author jfoley
 *
 * @param <T>
 */
public class DoublyLinkedList<T> extends ListADT<T> {
	/**
	 * This is a reference to the first node in this list.
	 */
	private Node<T> start;
	/**
	 * This is a reference to the last node in this list.
	 */
	private Node<T> end;
	
	private int fill;
	
	/**
	 * A doubly-linked list starts empty.
	 */
	public DoublyLinkedList() {
		this.start = null;
		this.end = null;
		this.fill = 0;
	}
	

	@Override
	public T removeFront() {
		checkNotEmpty();
		T removedValue = start.value;
		if (fill == 1) {
			start = end = null;
		} else {
			start = start.after;
			start.before = null;
		}
		fill--;
		return removedValue;
	}

	@Override
	public T removeBack() {
		checkNotEmpty();
		T removedValue = end.value;
		if (fill == 1) {
			start = end = null;
		} else {
			end = end.before;
			end.after = null;
		}
		fill--;
		return removedValue;
	}

	@Override
	public T removeIndex(int index) {
		checkNotEmpty();
		if (index >= fill || index < 0) {
			throw new BadIndexError(index);
		} else if (index == 0) {
			return removeFront();
		} else if (index == fill-1) {
			return removeBack();
		}
		
		//see if index is closer to the back or front, and then iterate from there. (Yay efficiency)
		T removedValue = null;
		if (index <= (fill-1)/2) {
			int trackLoops = 0;
			for (Node<T> current = this.start; trackLoops < index ; current = current.after) {
				if (trackLoops == index-1) {
					removedValue = current.after.value;
					current.after = current.after.after;
					current.after.before = current;
				}
				trackLoops++;
			}
		} else {
			int trackLoops = fill-1;
			for (Node<T> current = this.end; trackLoops > index-2 ; current = current.before) {
				if (trackLoops == index-1) {
					removedValue = current.after.value;
					current.after = current.after.after;
					current.after.before = current;
				}
				trackLoops--;
			}
		}
		fill--;
		return removedValue;
	}

	@Override
	public void addFront(T item) {
		if (start == null) {
			start = end = new Node<T>(item);
		} else {
			Node<T> second = start;
			start = new Node<T>(item, null, second);
			second.before = start;
		}
		fill++;
	}

	@Override
	public void addBack(T item) {
		if (end == null) {
			start = end = new Node<T>(item);
		} else {
			Node<T> secondLast = end;
			end = new Node<T>(item, secondLast, null);
			secondLast.after = end;
		}
		fill++;
	}

	@Override
	public void addIndex(int index, T item) {
		if (index > fill || index < 0) {
			throw new BadIndexError(index);
		} else if (isEmpty() || index == 0) {
			addFront(item);
			return;
		} else if (index == fill) {
			addBack(item);
			return;
		}
		
		//see if index is closer to the back or front, and then iterate from there. (Yay efficiency)
		
		if (index <= (fill-1)/2) {
			int trackLoops = 0;
			for (Node<T> current = this.start; trackLoops < index ; current = current.after) {
				if (trackLoops == index-1) {
					Node<T> next = current.after;
					current.after = new Node<T>(item, current, next);
					current.after.after.before = current.after;
				}
				trackLoops++;
			}
		} else {
			int trackLoops = fill-1;
			for (Node<T> current = this.end; trackLoops > index-2 ; current = current.before) {
				if (trackLoops == index-1) {
					Node<T> next = current.after;
					current.after = new Node<T>(item, current, next);
					current.after.after.before = current.after;
				}
				trackLoops--;
			}
		}
		fill++;
	}

	@Override
	public T getFront() {
		checkNotEmpty();
		return start.value;
	}

	@Override
	public T getBack() {
		checkNotEmpty();
		return end.value;
	}
	
	@Override
	public T getIndex(int index) {
		checkNotEmpty();
		if (index >= fill || index < 0) {
			throw new BadIndexError(index);
		} else if (index == 0) {
			return start.value;
		} else if (index == fill-1) {
			return end.value;
		}
		
		T retrievedValue = null;
		//see if index is closer to the back or front, and then iterate from there. (Yay efficiency)
		
		if (index <= (fill-1)/2) {
			int trackLoops = 0;
			for (Node<T> current = this.start; trackLoops < index ; current = current.after) {
				if (trackLoops == index-1) {
					retrievedValue = current.after.value;
				}
				trackLoops++;
			}
		} else {
			int trackLoops = fill-1;
			for (Node<T> current = this.end; trackLoops > index ; current = current.before) {
				if (trackLoops == index+1) {
					retrievedValue = current.before.value;
				}
				trackLoops--;
			}
		}
		return retrievedValue;
	}
	
	public void setIndex(int index, T value) {
		checkNotEmpty();
		if (index >= fill || index < 0) {
			throw new BadIndexError(index);
		} else if (isEmpty()) {
			addFront(value);
			return;
		}
		
		//see if index is closer to the back or front, and then iterate from there. (Yay efficiency)
		
		if (index <= (fill-1)/2) {
			int trackLoops = 0;
			for (Node<T> current = this.start; trackLoops <= index ; current = current.after) {
				if (trackLoops == index) {
					current.value = value;
				}
				trackLoops++;
			}
		} else {
			int trackLoops = fill-1;
			for (Node<T> current = this.end; trackLoops >= index ; current = current.before) {
				if (trackLoops == index) {
					current.value = value;
				}
				trackLoops--;
			}
		}
	}

	@Override
	public int size() {
		return this.fill;
	}

	@Override
	public boolean isEmpty() {
		if (this.start == null && this.end == null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * The node on any linked list should not be exposed.
	 * Static means we don't need a "this" of DoublyLinkedList to make a node.
	 * @param <T> the type of the values stored.
	 */
	private static class Node<T> {
		/**
		 * What node comes before me?
		 */
		public Node<T> before;
		/**
		 * What node comes after me?
		 */
		public Node<T> after;
		/**
		 * What value is stored in this node?
		 */
		public T value;
		/**
		 * Create a node with no friends.
		 * @param value - the value to put in it.
		 */
		public Node(T value) {
			this.value = value;
			this.before = null;
			this.after = null;
		}
		/**
		 * Create a node with a set before and after
		 * @param value - the value to put in it
		 * @param before - the proceeding node
		 * @param after - the next node
		 */
		public Node(T value, Node<T> before, Node<T> after) {
			this.value = value;
			this.before = before;
			this.after = after;
		}
	}
}
