package FrameListStudentMain;

public class ListOfStudents {
	public Node head, tail;

	public ListOfStudents() {
		head = tail = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addToHead(Student s) {
		if (isEmpty()) {
			head = tail = new Node(s);
		} else {
			head = new Node(s, null, head);
			head.next.prev = head;
		}
	}

	public void addToTail(Student s) {
		if (isEmpty()) {
			head = tail = new Node(s);
		} else {
			tail = new Node(s, tail, null);
			tail.prev.next = tail;
		}
	}

	public Student deleteFromHead() {
		if (isEmpty()) {
			System.out.println("List is empty.");
			return null;
		} else {
			Student s = head.info;
			if (head == tail) {
				head = tail = null;
			} else {
				head = head.next;
				head.prev = null;
			}
			return s;
		}

	}

	public Student deleteFromTail() {
		if (isEmpty()) {
			System.out.println("List is empty.");
			return null;
		} else {
			Student s = tail.info;
			if (head == tail) {
				head = tail = null;
			} else {
				tail = tail.prev;
				tail.next = null;
			}
			return s;
		}
	}

	public Node getElementAtPosition(int position) {
		int pos = 1;
		Node tmp = head;
		while (pos != position) {
			tmp = tmp.next;
			pos++;
		}
		return tmp;
	}

	public int numberOfElement() {
		int c = 0;
		for (Node tmp = head; tmp != null; tmp = tmp.next) {
			c++;
		}
		return c;
	}

	public Student deleteElement(int position) {
		if (position == 1) {
			return this.deleteFromHead();
		} else if (position == this.numberOfElement()) {
			return this.deleteFromTail();
		} else {
			int br = 2;
			Node tmp = head.next;
			while (br < position) {
				tmp = tmp.next;
				br++;
			}
			Node prev = tmp.prev;
			Node next = tmp.next;
			prev.next = next;
			next.prev = prev;
			return tmp.info;
		}
	}
	
	public int getIndexNumber(int position) {
		if(position == 1) {
			return Integer.parseInt(head.info.getIndexNumber());
		}else if(position == this.numberOfElement()) {
			return Integer.parseInt(tail.info.getIndexNumber());
		}else {
			int num = 2;
			Node tmp = head.next;
			while(num < position) {
				tmp = tmp.next;
				num++;
			}
			return Integer.parseInt(tmp.info.getIndexNumber());
		}
	}

	public int getNumberOfElementsOfType(String levelOfStud) {
		if (levelOfStud.equals("")) {
			return this.numberOfElement();
		}
		int num = 0;
		for (Node tmp = head; tmp != null; tmp = tmp.next) {
			if (levelOfStud.equals(tmp.info.getLevelOfStudies())) {
				num++;
			}
		}
		return num;
	}
}
