package commons.algorithm.sort;

public abstract class AbstractSorter<T> implements Sorter<T>{

    /**
     * Swaps x[a] with x[b].
     */
    protected static void swap(int x[], int a, int b) {
		int t = x[a];
		x[a] = x[b];
		x[b] = t;
    }
    
    /**
     * Swaps x[a] with x[b].
     */
    protected static void swap(Object[] x, int a, int b) {
		Object t = x[a];
		x[a] = x[b];
		x[b] = t;
    }
    
    /**
     * Swaps a with b.
     */
    protected static void swap(Object a, Object b) {
		Object t = a;
		a = b;
		b = t;
    }
    
    
}
