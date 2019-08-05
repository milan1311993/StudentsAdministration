package FrameListStudentMain;

public class Node {
	public Student info;
	public Node next, prev;

	public Node() {
		info = null;
		next = prev = null;
	}

	public Node(Student s) {
		info = s;
		next = prev = null;
	}

	public Node(Student s, Node p, Node n) {
		info = s;
		prev = p;
		next = n;
	}

}
