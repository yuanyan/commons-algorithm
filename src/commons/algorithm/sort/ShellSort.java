package commons.algorithm.sort;
/**
 * Shell排序
 * 
<pre>
希尔排序是按照不同步长对元素进行插入排序，当刚开始元素很无序的时候，步长最大，
所以插入排序的元素个数很少，速度很快；
当元素基本有序了，步长很小，插入排序对于有序的序列效率很高。
所以，希尔排序的时间复杂度会比o(n^2)好一些。
由于多次插入排序，我们知道一次插入排序是稳定的，不会改变相同元素的相对顺序，
但在不同的插入排序过程中，相同的元素可能在各自的插入排序中移动，
最后其稳定性就会被打乱，所以shell排序是不稳定的。

Shell排序可以理解为插入排序的变种，它充分利用了插入排序的两个特点： 
1）当数据规模小的时候非常高效 
2）当给定数据已经有序时的时间代价为O(N) 

所以，Shell排序每次把数据分成若个小块，来使用插入排序，
而且之后在这若个小块排好序的情况下把它们合成大一点的小块，
继续使用插入排序，不停的合并小块，知道最后成一个块，并使用插入排序。 

这里每次分成若干小块是通过“增量” 来控制的，开始时增量交大，接近N/2,
从而使得分割出来接近N/2个小块，逐渐的减小“增量“最终到减小到1。 

一直较好的增量序列是2^k-1,2^(k-1)-1,.....7,3,1,这样可使Shell排序时间复杂度达到O(N^1.5) 
所以我在实现Shell排序的时候采用该增量序列 
</pre>
 * @author yuanyan.cao@gmail.com
 *
 * @param <T>
 */
public class ShellSort<T> extends AbstractSorter<T> {
	
	 public void sort(int[] data) {
	        for(int i=data.length/2;i>2;i/=2){
	            for(int j=0;j<i;j++){
	                insertSort(data,j,i);
	            }
	        }
	        insertSort(data,0,1);
	    }

    /**
     * @param data
     * @param j
     * @param i
     */
    private void insertSort(int[] data, int start, int inc) {
        int temp;
        for(int i=start+inc;i<data.length;i+=inc){
            for(int j=i;(j>=inc)&&(data[j]<data[j-inc]);j-=inc){
                swap(data,j,j-inc);
            }
        }
    }

	public void sort(T[] x) {
		// TODO Auto-generated method stub
		
	}

	public void sort(T[] x, int off, int len) {
		// TODO Auto-generated method stub
		
	}

}
