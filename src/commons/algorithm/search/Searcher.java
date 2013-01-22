package commons.algorithm.search;

/**
 * 搜索算法接口
 *
 */
public interface Searcher<T>{


  void search(T[] x, T key);
  
  
  void search(T[] x, int off, int len, T key);

}
