package commons.algorithm.sort;
/**
 * 冒泡排序 复杂度为O(n*n)。当数据为正序，将不会有交换。复杂度为O(0)。
 * 
 * <p>
 * 每次从数组末端开始比较相邻两元素，把第i小的冒泡到数组的第i个位置。i从0一直到N-1从而完成排序。
 * 当然也可以从数组开始端开始比较相邻两元素，把第i大的冒泡到数组的第N-i个位置。i从0一直到N-1从而完成排序。 
 * </p>
 * @author yuanyan.cao@gmail.com
 *
 * @param <T>
 */
public class BubbleSort<T> extends AbstractSorter<T> {
	
	public void sort(int[] data) {
        int temp;
        for(int i=0;i<data.length;i++){
            for(int j=data.length-1;j>i;j--){
                if(data[j]<data[j-1]){
                    swap(data,j,j-1);
                }
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
