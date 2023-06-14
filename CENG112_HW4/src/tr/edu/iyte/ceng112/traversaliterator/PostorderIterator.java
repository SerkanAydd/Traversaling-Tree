package tr.edu.iyte.ceng112.traversaliterator;

import java.util.Iterator;

import tr.edu.iyte.ceng112.stack.ArrayStack;
import tr.edu.iyte.ceng112.stack.StackInterface;
import tr.edu.iyte.ceng112.tree.BinaryNode;

public class  PostorderIterator<T> implements Iterator<T> {

	private StackInterface<BinaryNode<T>> nodeStack;
	private BinaryNode<T> currentNode;
	private BinaryNode<T> prevNode;

	public PostorderIterator(BinaryNode<T> root) {
		nodeStack = new ArrayStack<>();
		currentNode = (BinaryNode<T>) root;
		prevNode = null;
	}

	@Override
	public boolean hasNext() {
		return !nodeStack.isEmpty() || (currentNode != null);
	}

	@Override
	public T next() {
		BinaryNode<T> nextNode = null;

		while (true) {
			while (currentNode != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			}

			if (nodeStack.isEmpty()) {
				break;
			}

			BinaryNode<T> peekNode = nodeStack.peek();

			if (peekNode.getRightChild() != null && peekNode.getRightChild() != prevNode) {
				currentNode = peekNode.getRightChild();
			} else {
				prevNode = nodeStack.pop();
				nextNode = prevNode;
				break;
			}
		}

		assert nextNode != null;
		return nextNode.getData();
	}


	public void remove() {
		throw new UnsupportedOperationException();
	}
}