package commons.algorithm.search;

public abstract class AbstractSearcher<T> implements Searcher<T>{

    /**
     * Check that fromIndex and toIndex are in range, and throw an
     * appropriate exception if they aren't.
     */
	protected static void rangeCheck(int arrayLen, int fromIndex, int toIndex) {
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex +
                       ") > toIndex(" + toIndex+")");
        if (fromIndex < 0)
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        if (toIndex > arrayLen)
            throw new ArrayIndexOutOfBoundsException(toIndex);
    }
	

    
}
