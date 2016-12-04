package structures;

import java.util.Iterator;

public class ScapegoatTree<T extends Comparable<T>> extends
		BinarySearchTree<T> {
	private int upperBound;


	@Override
	public void add(T t) {
		// TODO
		if (t == null) throw new NullPointerException();
		upperBound++;
		BSTNode<T> nn = new BSTNode<T>(t, null, null);
		root = addToSubtree(root, nn);
		if (height() > Math.log(upperBound) / Math.log((double)3/2)) {
			BSTNode<T> child = nn;
			BSTNode<T> w = nn.parent;
			while ((double)subtreeSize(child)/ subtreeSize(w) <= (double)2/3) {
				w = w.parent;
				child = child.parent;
			}
			ScapegoatTree<T> subtree = new ScapegoatTree<T>();
			subtree.root = w;
			BSTNode<T> orgParent = w.parent;
			subtree.balance();
			if (orgParent.getLeft() == w) orgParent.setLeft(subtree.root);
			else orgParent.setRight(subtree.root);
		}
	}
	
	@Override
	public boolean remove(T t) {
		// TODO
		if (t == null) {
			throw new NullPointerException();
		}
		boolean result = contains(t);
		if (result) {
			root = removeFromSubtree(root, t);
		}
		if (upperBound > 2*size()) {
			balance();
			upperBound = size();
		}
		return result;
	}
}
