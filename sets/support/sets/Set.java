package sets;

import java.util.Iterator;

/**
 * A collection that contains no duplicate elements.  More formally,
 * sets contain no pair of elements <code>e1</code> and
 * <code>e2</code> such that <code>e1.equals(e2)</code>, and at most
 * one null element. As implied by its name, this interface models the
 * mathematical set abstraction.
 *
 * @author John Ridgway <ridgway@cs.umass.edu>
 * @version 1.0
 */
public interface Set<E> extends Iterable<E> {

  /** 
   * Returns the number of elements in this set (its cardinality).  If
   * this set contains more than <code>Integer.MAX_VALUE</code>
   * elements, returns <code>Integer.MAX_VALUE</code>.
   *
   * @return the number of elements in this set (its cardinality)
   */
  int size();

  /**
   * Returns true if this set contains no elements.
   *
   * @return true if this set contains no elements.
   */
  boolean isEmpty();

  /**
   * Returns an iterator over the elements in this set. The elements
   * are returned in no particular order.
   *
   * @return an iterator over the elements in this set
   */
  Iterator<E> iterator();

  /**
   * Returns true if this set contains the specified element.  More
   * formally, returns true if and only if this set contains an
   * element <code>e</code> such that <code>(o==null ? e==null :
   * o.equals(e))</code>.
   *
   * @param  o the element whose presence in this set is to be tested
   * @return   true if this set contains the specified element
   */
  boolean contains(Object o);

  /**
   * Returns true if this set is a subset (or equal to) the given
   * set.  More formally, returns true if and only if every member of
   * this set is also a member of <code>that</code>.
   *
   * @param  that  the set to check whether this is a subset of
   * @return true  if every member of <code>this</code> set is also a
   *               member of <code>that</code> 
   */
  boolean isSubset(Set<E> that);

  /**
   * Returns true if this set is a superset (or equal to) the given
   * set.  This is equivalent to <code>that.isSubset(this)</code>.
   *
   * @param  that  the set to check whether this is a superset of
   * @return true  if every member of <code>that</code> is also a member of
   *               <code>this</code> set
   */
  boolean isSuperset(Set<E> that);

  /**
   * Returns a new Set containing all of the elements of this set and
   * also the specified new element.  If the specified element is
   * already in the set then returns the original Set.
   * 
   * @param  e the element to be added
   * @return   a Set containing all of the elements of this set that
   * also contains <code>e</code>
   */
  Set<E> adjoin(E e);

  /**
   * Returns a new <code>Set</code> that is the union of <code>this
   * Set</code> and <code>that Set</code>.  This is intended to be the
   * mathematical operation of union on sets.
   *
   * @param  other  the other <code>Set</code> to take the union with
   * @return        a <code>Set</code> containing the union of the two
   *                input <code>Set</code>s
   */
  Set<E> union(Set<E> other);

  /**
   * Returns a new <code>Set</code> that is the intersection of
   * <code>this Set</code> and <code>that Set</code>.  This is
   * intended to be the mathematical operation of intersection on
   * sets.
   *
   * @param  other  the other <code>Set</code> to take the
   *                intersection with 
   * @return        a <code>Set</code> containing the intersection of
   *                the two input <code>Set</code>s
   */
  Set<E> intersect(Set<E> other);

  /**
   * Returns a new <code>Set</code> that is the difference of
   * <code>this Set</code> and <code>that Set</code>, i.e., <code>
   * this - that</code>.  This is intended to be the mathematical
   * operation of difference on sets.  Formally, the returned set
   * contains every element <code>e</code> of <code>this</code> that
   * is not an element of <code>that</code>.
   *
   * @param  that  the <code>Set</code> to subtract from this one
   * @return        a <code>Set</code> containing the difference of
   *                the two input <code>Set</code>s
   */
  Set<E> subtract(Set<E> other);

  /**
   * Returns a new <code>Set</code> that is the same as
   * <code>this</code> except that it does not contain the specified
   * element.  If <code>this</code> does not contain the specified
   * element then the returned <code>Set</code> is the same as
   * <code>this</code>. 
   *
   * @param  e  the element to be removed
   * @return    a set similar to <code>this</code> but without
   * <code>e</code>
   */
  Set<E> remove(E e);

  /**
   * Compares the specified object with this set for equality. Returns
   * true if the specified object is also a set, the two sets have the
   * same size, and every member of the specified set is contained in
   * this set (or equivalently, every member of this set is contained
   * in the specified set).
   *
   * @param  o  object to be compared for equality with this set
   * @return    true if the specified object is equal to this set
   * @see java.lang.Object#hashCode()
   */
  boolean equals(Object o);

  /**
   * Returns the hash code value for this set. The hash code of a set
   * is defined to be the sum of the hash codes of the elements in the
   * set, where the hash code of a null element is defined to be
   * zero. This ensures that <code>s1.equals(s2)</code> implies that
   * <code>s1.hashCode() == s2.hashCode()</code> for any two sets
   * <code>s1</code> and <code>s2</code>, as
   * required by the general contract of <code>Object.hashCode()</code>.
   *
   * @return the hash code value for this set
   * @see java.lang.Object#equals(Object)
   * @see equals(Object)
   * @see java.lang.Object#hashCode()
   */
  int hashCode();
}
