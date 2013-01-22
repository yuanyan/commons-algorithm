package commons.algorithm.sort;

/**
 * Interface for sort algorithms accepting {@link Sortable} items.
 *
 * A sort algorithm implementing this interface may only
 * {@link Sortable#compare} and {@link Sortable#swap} items
 * for a range of indices to effect a sort across that range.
 */
public interface Sorter<T>{

  /**
   * Sort the items accessed through the given IndexedSortable over the given
   * range of logical indices. From the perspective of the sort algorithm,
   * each index between l (inclusive) and r (exclusive) is an addressable
   * entry.
   * @see Sortable#compare
   * @see Sortable#swap
   */
  void sort(T[] x);
  
  void sort(T[] x, int off, int len);

}
