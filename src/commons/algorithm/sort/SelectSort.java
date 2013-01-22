package commons.algorithm.sort;
/**
 * 选择排序
 * <p>
 * 选择排序相对于冒泡来说，它不是每次发现逆序都交换，
 * 而是在找到全局第i小的时候记下该元素位置，最后跟第i个元素交换，从而保证数组最终的有序。 
 * 相对与插入排序来说，选择排序每次选出的都是全局第i小的，不会调整前i个元素了。
 * </p>
 * @author yuanyan.cao@gmail.com
 *
 * @param <T>
 */
public class SelectSort<T> extends AbstractSorter<T> {
	
	public void sort(int[] data) {
        int temp;
        for (int i = 0; i < data.length; i++) {
            int lowIndex = i;
            for (int j = data.length - 1; j > i; j--) {
                if (data[j] < data[lowIndex]) {
                    lowIndex = j;
                }
            }
            swap(data,i,lowIndex);
        }
    }

	public void sort(T[] x) {
		// TODO Auto-generated method stub
		
	}

	public void sort(T[] x, int off, int len) {
		// TODO Auto-generated method stub
		
	}

}
