package tr.edu.iyte.ceng112.traversaliterator;

import tr.edu.iyte.ceng112.queue.ArrayQueue;
import tr.edu.iyte.ceng112.queue.EmptyQueueException;
import tr.edu.iyte.ceng112.tree.BinaryNode;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class LevelOrderIterator<T> implements Iterator<T> {
	private ArrayQueue<BinaryNode<T>> nodeQueue;
	private BinaryNode<T> currentNode;

	public LevelOrderIterator(BinaryNode<T> root) {
		nodeQueue = new ArrayQueue<>();
		nodeQueue.enqueue(root);
	}

	@Override
	public boolean hasNext() {
		return !nodeQueue.isEmpty();
	}

	@Override
	public T next() {
		BinaryNode<T> nextNode = null;
		try {
			nextNode = nodeQueue.dequeue();
		} catch (EmptyQueueException e) {
			throw new RuntimeException(e);
		}
		if (nextNode.getLeftChild() != null)
			nodeQueue.enqueue(nextNode.getLeftChild());
		if (nextNode.getRightChild() != null)
			nodeQueue.enqueue(nextNode.getRightChild());

		return nextNode.getData();

	}

	public void remove() {
		throw new UnsupportedOperationException();
	}


}