package tr.edu.iyte.ceng112.traversaliterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import tr.edu.iyte.ceng112.stack.ArrayStack;
import tr.edu.iyte.ceng112.stack.StackInterface;
import tr.edu.iyte.ceng112.tree.BinaryNode;

public class PreorderIterator<T> implements Iterator<T> {

	private StackInterface<BinaryNode<T>> nodeStack;

	public PreorderIterator(BinaryNode<T> root) {
		nodeStack = new ArrayStack<>();
		nodeStack.push(root);
	}

	@Override
	public boolean hasNext() {
		return !nodeStack.isEmpty();
	}

	@Override
	public T next() {
		if (!hasNext())
			throw new NoSuchElementException();

		BinaryNode<T> nextNode = nodeStack.pop();
		if (nextNode.getRightChild() != null)
			nodeStack.push(nextNode.getRightChild());
		if (nextNode.getLeftChild() != null)
			nodeStack.push(nextNode.getLeftChild());

		return nextNode.getData();
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}