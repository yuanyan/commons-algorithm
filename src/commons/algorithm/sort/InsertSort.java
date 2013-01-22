package commons.algorithm.sort;

/**
 * 插入排序
 * <p>
 * 该算法在数据规模小的时候十分高效，
 * 该算法每次插入第K+1到前K个有序数组中一个合适位置， K从0开始到N-1,从而完成排序
 * </p>
 * @author yuanyan.cao@gmail.com
 *
 * @param <T>
 */
public class InsertSort<T> extends AbstractSorter<T>{
	
	 public void sort(int[] data) {
	        int temp;
	        for(int i=1;i<data.length;i++){
	            for(int j=i;(j>0)&&(data[j]<data[j-1]);j--){
	                swap(data,j,j-1);
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
