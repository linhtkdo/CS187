package sets;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


@SuppressWarnings("unused")
public class PublicLinkedSetTest {
	  Set<String> set0;
	  Set<String> set1;
	  Set<String> set2;
	  Set<String> set3;
	  Set<String> set4;
  @Before
  public void before() {
    set0 = new LinkedSet<String>();
    set1 = new LinkedSet<String>();
    for (String e : new String[]{"c", "a", "d", "b", "e"}) {
      set1 = set1.adjoin(e);
    }
    set2 = new LinkedSet<String>();
    for (String e : new String[]{"b", "d", "a", "e", "c"}) {
      set2 = set2.adjoin(e);
    }
    set3 = new LinkedSet<String>();
    for (String e : new String[]{"a", "d", "b"}) {
      set3 = set3.adjoin(e);
    }
    set4 = new LinkedSet<String>();
    for (String e : new String[]{"x", "y", "z", "a", "b", "d"}) {
      set4 = set4.adjoin(e);
    }
  }

  @Test
  
  public void testEmptySet() {
    assertEquals(0, set0.size());
    assertTrue(set0.isEmpty());
    assertFalse(set0.contains("a"));
    assertTrue(set0.isSubset(set0));
    assertTrue(set0.isSubset(set1));
    assertTrue(set0.isSubset(set2));
    assertTrue(set0.isSubset(set3));
    assertTrue(set0.isSuperset(set0));
    assertFalse(set0.isSuperset(set1));
    assertFalse(set0.isSuperset(set2));
    assertFalse(set0.isSuperset(set3));
  }

  @Test
  
  public void testIterator0() {
    int count = 0;
    for (String e : set0) {
      count += 1;
    }
    assertEquals(0, count);
  }

  @Test
  
  public void testIterator1() {
    int count = 0;
    for (String e : set1) {
      count += 1;
    }
    assertEquals(5, count);
  }

  @Test
  
  public void testIterator2() {
    int count = 0;
    for (String e : set2) {
      count += 1;
    }
    assertEquals(5, count);
  }

  @Test
  
  public void testIterator3() {
    int count = 0;
    for (String e : set3) {
      count += 1;
    }
    assertEquals(3, count);
  }

  @Test
  
  public void testIterator4() {
    int count = 0;
    for (String e : set4) {
      count += 1;
    }
    assertEquals(6, count);
  }

  @Test
  
  public void testUnorderedEquality() {
    assertTrue(set1.equals(set2));
    assertFalse(set1.equals(set3));
    assertFalse(set2.equals(set3));
    assertTrue(set2.equals(set1));
    assertFalse(set3.equals(set1));
    assertFalse(set3.equals(set2));
  }

  @Test
  
  public void testContains() {
    assertFalse(set0.contains("a"));
    assertTrue(set1.contains("a"));
    assertTrue(set2.contains("a"));
    assertTrue(set3.contains("a"));
    assertTrue(set1.contains("e"));
    assertTrue(set2.contains("e"));
    assertFalse(set3.contains("e"));
  }

  @Test
  
  public void testIsSubset() {
    assertTrue(set1.isSubset(set1));
    assertTrue(set1.isSubset(set2));
    assertFalse(set1.isSubset(set3));
    assertFalse(set1.isSubset(set4));
    assertTrue(set2.isSubset(set1));
    assertTrue(set2.isSubset(set2));
    assertFalse(set2.isSubset(set3));
    assertFalse(set2.isSubset(set4));
    assertTrue(set3.isSubset(set1));
    assertTrue(set3.isSubset(set2));
    assertTrue(set3.isSubset(set3));
    assertTrue(set3.isSubset(set4));
  }

  @Test
  
  public void testIsSuperset() {
    assertTrue(set1.isSuperset(set1));
    assertTrue(set2.isSuperset(set1));
    assertFalse(set3.isSuperset(set1));
    assertFalse(set4.isSuperset(set1));
    assertTrue(set1.isSuperset(set2));
    assertTrue(set2.isSuperset(set2));
    assertFalse(set3.isSuperset(set2));
    assertFalse(set4.isSuperset(set2));
    assertTrue(set1.isSuperset(set3));
    assertTrue(set2.isSuperset(set3));
    assertTrue(set3.isSuperset(set3));
    assertTrue(set4.isSuperset(set3));
  }

  @Test
  
  public void testUnionWithSelf() {
    assertEquals(set1, set1.union(set1));
  }

  @Test
  
  public void testUnionWithEqual() {
    assertEquals(set1, set1.union(set2));
  }

  @Test
  
  public void testUnionWithSubset() {
    assertEquals(set1, set1.union(set3));
  }

  @Test
  
  public void testUnionWithOther() {
    assertEquals(8, set1.union(set4).size());
  }

  @Test
  
  public void testIntersectWithSelf() {
    assertEquals(set1, set1.intersect(set1));
  }

  @Test
  
  public void testIntersectWithEqual() {
    assertEquals(set1, set1.intersect(set2));
  }

  @Test
  
  public void testIntersectWithSubset() {
    assertEquals(set3, set1.intersect(set3));
  }

  @Test
  
  public void testIntersectWithOther() {
    assertEquals(set3, set1.intersect(set4));
  }

  @Test
  
  public void testSubtractSelf() {
    assertEquals(set0, set1.subtract(set1));
  }

  @Test
  
  public void testSubtractEqual() {
    assertEquals(set0, set1.subtract(set2));
  }

  @Test
  
  public void testSubtractWithSubset() {
    assertEquals(set0.adjoin("c").adjoin("e"), set1.subtract(set3));
  }

  @Test
  
  public void testSubtractWithOther() {
    assertEquals(set0.adjoin("z").adjoin("y").adjoin("x"), set4.subtract(set1));
  }

  @Test
  
  public void testRemove() {
    assertEquals(set3.adjoin("e"), set1.remove("c"));
  }
}
