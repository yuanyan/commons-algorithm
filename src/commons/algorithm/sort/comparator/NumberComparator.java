package commons.algorithm.sort.comparator;

import java.math.BigInteger;
import java.util.Comparator;

public class NumberComparator implements Comparator<Number>{

    /**
     * 
     * @param   n1 <code>Number</code>
     * @param   n2 <code>Number</code>
     * 
     * @return  
	 */
	public int compare(Number n1, Number n2) {
		if(BigInteger.class.isInstance(n1)&&BigInteger.class.isInstance(n2)){
			return ((BigInteger)n1).compareTo((BigInteger) n2);
		} 
		return n1.doubleValue() < n2.doubleValue() ? -1 : (n1.doubleValue()==n2.doubleValue()? 0 : 1);
		
	}

}
