package commons.algorithm.sort;

import java.util.Comparator;

/**
 * 堆排序
 * <pre>
基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。
有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序，
最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。
基数排序基于分别排序，分别收集，所以其是稳定的排序算法。

堆是一种完全二叉树，一般使用数组来实现。 
堆主要有两种核心操作: 
1）从指定节点向上调整(shiftUp) 
2）从指定节点向下调整(shiftDown) 
建堆，以及删除堆定节点使用shiftDwon,而在插入节点时一般结合两种操作一起使用。 
堆排序借助最大值堆来实现，第i次从堆顶移除最大值放到数组的倒数第i个位置，
然后shiftDown到倒数第i+1个位置,一共执行N此调整，即完成排序。 
显然，堆排序也是一种选择性的排序，每次选择第i大的元素。 
 * </pre>
 * @author yuanyan.cao@gmail.com
 *
 * @param <T>
 */
public final class HeapSort<T> extends AbstractSorter<T> {

  public HeapSort() { }

  private static void downHeap(final Comparator s, final int b,
      int i, final int N) {
    for (int idx = i << 1; idx < N; idx = i << 1) {
      if (idx + 1 < N && s.compare(b + idx, b + idx + 1) < 0) {
        if (s.compare(b + i, b + idx + 1) < 0) {
          swap(b + i, b + idx + 1);
        } else return;
        i = idx + 1;
      } else if (s.compare(b + i, b + idx) < 0) {
        swap(b + i, b + idx);
        i = idx;
      } else return;
    }
  }
  
  /**
   * Sort the given range of items using heap sort.
   * {@inheritDoc}
   */
  public void sort(final Comparator s, final int p, final int r) {
    final int N = r - p;
    // build heap w/ reverse comparator, then write in-place from end
    final int t = Integer.highestOneBit(N);
    for (int i = t; i > 1; i >>>= 1) {
      for (int j = i >>> 1; j < i; ++j) {
        downHeap(s, p-1, j, N + 1);
      }
    }
    for (int i = r - 1; i > p; --i) {
      swap(p, i);
      downHeap(s, p - 1, 1, i - p + 1);
    }
  }

	public void sort(T[] x) {
		// TODO Auto-generated method stub
		
	}
	
	public void sort(T[] src, int off, int len) {
		// TODO Auto-generated method stub
		
	}


}
