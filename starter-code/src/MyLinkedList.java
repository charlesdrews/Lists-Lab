import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
	
	private Node<T> head;
	private int size = 0;
	
	public int getSize() {
		return size;
	}
	
	public void add(T obj) {
		Node<T> lastNode = head;
		if (head == null) {
			head = new Node<T>(obj);
			size = 1;
			return;
		}
		while (lastNode.getNext() != null) {
			lastNode = lastNode.getNext();
		}
		lastNode.setNext(new Node<T>(obj));
		size++;
	}
	
	public boolean remove(int index) {
		if (index < 0 || index > size - 1) { return false; }

		Node<T> priorNode = head;
		for (int i = 0; i < index - 1; i++) {
			priorNode = priorNode.getNext();
		}
		priorNode.setNext(priorNode.getNext().getNext());
		size--;
		return true;
	}
	
	public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException();
		}

		Node<T> currentNode = head;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.getNext();
		}
		return currentNode.getData();
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>(head);
	}
	
	private class MyIterator<T> implements Iterator<T> {

		private Node<T> node;
		
		public MyIterator(Node<T> node) {
			this.node = node;
		}
		@Override
		public boolean hasNext() {
			return (node.getNext() != null);
		}

		@Override
		public T next() {
			node = node.getNext();
			return node.getData();
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
