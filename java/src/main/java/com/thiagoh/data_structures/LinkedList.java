package com.thiagoh.data_structures;

public class LinkedList {

	private int size;
	private Node head;
	private Node last;

	public Node head() {
		return head;
	}
	
	public Node last() {
		return last;
	}

	public Object get(int index) {

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		Node cur = head;

		for (int i = 0; i < index && cur != null; i++, cur = cur.next) {
			;
		}

		if (cur == null) {
			return null;
		}
		return cur.value;
	}

	public Node getNode(int index) {

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		Node cur = head;

		for (int i = 0; i < index && cur != null; i++, cur = cur.next) {
			;
		}

		if (cur == null) {
			return null;
		}
		return cur;
	}

	public LinkedList add(Object value) {

		if (head == null) {
			head = new Node(value);
			last = head;
			++size;

		} else {

			Node node = head;

			while (node.next != null) {
				node = node.next;
			}

			node.next = new Node(value);
			last = node.next;
			++size;
		}

		return this;
	}

	public boolean remove(Object value) {

		if (value == null || size == 0) {
			return false;
		}

		if (value.equals(head.value)) {
			Node oldHead = head;
			head = head.next;
			if (last == oldHead) {
				last = head;
			}
			--size;
			return true;
		}

		Node node = head;

		while (node.next != null) {
			if (value.equals(node.next.value)) {
				Node oldNode = node.next;
				node.next = node.next.next;
				if (last == oldNode) {
					last = node;
				}
				--size;
				return true;
			}
			node = node.next;
		}
		return false;
	}

	public boolean contains(Object value) {

		if (value == null || size == 0) {
			return false;
		}

		Node node = head;

		while (node != null) {
			if (value.equals(node.value)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public static class Node {

		public Object value;
		public Node next;

		public Node(Object value) {
			this.value = value;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			return this == obj;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}
	}
}
