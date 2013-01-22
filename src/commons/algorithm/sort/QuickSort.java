package commons.algorithm.sort;
/**
 * 快速排序 平均时间复杂度log2(n)*n
<pre>
快速排序是目前使用可能最广泛的排序算法了。 一般分如下步骤： 
1）选择一个枢纽元素（有很对选法，我的实现里采用去中间元素的简单方法） 
2）使用该枢纽元素分割数组，使得比该元素小的元素在它的左边，比它大的在右边。并把枢纽元素放在合适的位置。 
3）根据枢纽元素最后确定的位置，把数组分成三部分，左边的，右边的，枢纽元素自己，
   对左边的，右边的分别递归调用快速排序算法即可。 

快速排序的核心在于分割算法，也可以说是最有技巧的部分。
</pre>
 * @author yuanyan.cao@gmail.com
 *
 * @param <T>
 */
public abstract class QuickSort<T> extends AbstractSorter<T>{

	/**
	 * @param x ָ
	 */
	public static void sort(int[] x){
		sort(x, 0, x.length);		
	}
	
    /**
     * Sorts the specified sub-array of integers into ascending order.
     * 
	 * @param x
	 * @param off
	 * @param len
     */
    public static void sort(int x[], int off, int len) {
	// Insertion sort on smallest arrays
	if (len < 7) {
	    for (int i=off; i<len+off; i++)
		for (int j=i; j>off && x[j-1]>x[j]; j--)
		    swap(x, j, j-1);
	    return;
	}

	// Choose a partition element, v
	int m = off + (len >> 1);       // Small arrays, middle element
	if (len > 7) {
	    int l = off;
	    int n = off + len - 1;
	    if (len > 40) {        // Big arrays, pseudomedian of 9
		int s = len/8;
		l = med3(x, l,     l+s, l+2*s);
		m = med3(x, m-s,   m,   m+s);
		n = med3(x, n-2*s, n-s, n);
	    }
	    m = med3(x, l, m, n); // Mid-size, med of 3
	}
	int v = x[m];

	// Establish Invariant: v* (<v)* (>v)* v*
	int a = off, b = a, c = off + len - 1, d = c;
	while(true) {
	    while (b <= c && x[b] <= v) {
		if (x[b] == v)
		    swap(x, a++, b);
		b++;
	    }
	    while (c >= b && x[c] >= v) {
		if (x[c] == v)
		    swap(x, c, d--);
		c--;
	    }
	    if (b > c)
		break;
	    swap(x, b++, c--);
	}

	// Swap partition elements back to middle
	int s, n = off + len;
	s = Math.min(a-off, b-a  );  vecswap(x, off, b-s, s);
	s = Math.min(d-c,   n-d-1);  vecswap(x, b,   n-s, s);

	// Recursively sort non-partition-elements
	if ((s = b-a) > 1)
	    sort(x, off, s);
	if ((s = d-c) > 1)
	    sort(x, n-s, s);
    }

    /**
     * Swaps x[a .. (a+n-1)] with x[b .. (b+n-1)].
     */
    private static void vecswap(int x[], int a, int b, int n) {
	for (int i=0; i<n; i++, a++, b++)
	    swap(x, a, b);
    }

    /**
     * Returns the index of the median of the three indexed integers.
     */
    private static int med3(int x[], int a, int b, int c) {
	return (x[a] < x[b] ?
		(x[b] < x[c] ? b : x[a] < x[c] ? c : a) :
		(x[b] > x[c] ? b : x[a] > x[c] ? c : a));
    }

 
}
