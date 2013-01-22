package commons.algorithm.sort;

import java.util.Comparator;

/**
 * 归并排序
 * 每次把待排序列分成两部分，分别对这两部分递归地用归并排序，完成后把这两个子部分合并成一个序列。 
 * 归并排序借助一个全局性临时数组来方便对子序列的归并，该算法核心在于归并。
 * @author yuanyan.cao@gmail.com
 *
 * @param <T>
 */
public class MergeSort<T> extends AbstractSorter<T>{
	
    /**
     * Tuning parameter: list size at or below which insertion sort will be
     * used in preference to mergesort or quicksort.
     */
	  private static final int INSERTIONSORT_THRESHOLD = 7;
	  
	  //Reusable Integers
	  Integer I = new Integer(0);
	  Integer J = new Integer(0);
	  
	  //the comparator that the algo should use
	  private Comparator comparator;
	  
	  public MergeSort(Comparator  comparator) {
	    this.comparator = comparator;
	  }
	  
	  public void sort(int src[], int dest[], int low, int high) {
	    int length = high - low;

	    // Insertion sort on smallest arrays
	    if (length < INSERTIONSORT_THRESHOLD) {
	      for (int i=low; i<high; i++) {
	        for (int j=i;j > low; j--) {
	          I=(dest[j-1]);
	          J=(dest[j]);
	          if (comparator.compare(I, J)>0)
	            swap(dest, j, j-1);
	        }
	      }
	      return;
	    }

	    // Recursively sort halves of dest into src
	    int mid = (low + high) >>> 1;
	    sort(dest, src, low, mid);
	    sort(dest, src, mid, high);

	    I=(src[mid-1]);
	    J=(src[mid]);
	    // If list is already sorted, just copy from src to dest.  This is an
	    // optimization that results in faster sorts for nearly ordered lists.
	    if (comparator.compare(I, J) <= 0) {
	      System.arraycopy(src, low, dest, low, length);
	      return;
	    }

	    // Merge sorted halves (now in src) into dest
	    for (int i = low, p = low, q = mid; i < high; i++) {
	      if (q < high && p < mid) {
	        I=(src[p]);
	        J=(src[q]);
	      }
	      if (q>=high || p<mid && comparator.compare(I, J) <= 0)
	        dest[i] = src[p++];
	      else
	        dest[i] = src[q++];
	    }
	  }

	
	  
	  /**
	     * @param Src  the source array that starts at index 0
	     * @param Dest  the (possibly larger) array destination with a possible offset
	     * @param low  the index in dest to start sorting
	     * @param high  the end index in dest to end sorting
	     * @param off  the offset to generate corresponding low, high in src
	     */
	    public static void sort(Object[] src, Object[] dest,  int low,  int high,
					  int off) {
	    	
		int length = high - low;

		// Insertion sort on smallest arrays
	        if (length < INSERTIONSORT_THRESHOLD) {
	            for (int i=low; i<high; i++)
	                for (int j=i; j>low &&
				 ((Comparable) dest[j-1]).compareTo(dest[j])>0; j--)
	                    swap(dest, j, j-1);
	            return;
	        }

	        // Recursively sort halves of dest into src
	        int destLow  = low;
	        int destHigh = high;
	        low  += off;
	        high += off;
	        int mid = (low + high) >>> 1;
	        sort(dest, src, low, mid, -off);
	        sort(dest, src, mid, high, -off);

	        // If list is already sorted, just copy from src to dest.  This is an
	        // optimization that results in faster sorts for nearly ordered lists.
	        if (((Comparable)src[mid-1]).compareTo(src[mid]) <= 0) {
	            System.arraycopy(src, low, dest, destLow, length);
	            return;
	        }

	        // Merge sorted halves (now in src) into dest
	        for(int i = destLow, p = low, q = mid; i < destHigh; i++) {
	            if (q >= high || p < mid && ((Comparable)src[p]).compareTo(src[q])<=0)
	                dest[i] = src[p++];
	            else
	                dest[i] = src[q++];
	        }
	    }

	public void sort(T[] x) {
		// TODO Auto-generated method stub
		
	}

	public void sort(T[] x, int off, int len) {
		// TODO Auto-generated method stub
		
	}
	    
	    
}
