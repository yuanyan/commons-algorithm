package commons.algorithm.search;
/**
 * 二叉树查找算法
 * <pre>
总结： 
一 线性查找 
又称顺序查找，是从数组的第一个元素开始查找，直到找到待查找元素的位置，直到查找到结果。 
最佳的状况时间是1 ，就是第一个就是待查找的远射，最差的查找状况是O（n），就是最后一个是待查找的元素。 

二 折半查找 
折半查找是将待查找的数组元素不断的分为两部分，每次淘汰二分之一，但是有个大前提是，元素必须是有序的，如果是无序的则要先进行排序操作，这种查找的方法，类似于找英文字典的Java，我们可以一下子找到字母J开头的，再仔细找。 
最佳的状况时间是1，就是第一次分开就查找到了，最差的查找状态是O（n），便是待查找的数据出现在最后一次。 

三 费氏查找 
费氏查找主要是根据费氏数列1 1 2 3 5 8 13 ...... 来确定范围，然后再进行查找 

四 插补查找 
插补查找是一种类似折半查找的查找方法，插补查找是以比例的概念，求出待查找数据的可能位置，然后进行比较，如果该值比待查找的小，表示待查找的值可能出现在该值之前的范围，就这样一直缩小范围来确定最终的目标。  

五 二叉查找树 
二叉查找树是先对待查找的数据进行生成树，确保树的左分支的值小于右分支的值，然后在就行和每个节点的父节点比较大小，查找最适合的范围。 

这个算法的查找效率很高，但是如果使用这种查找方法要首先创建树。 
 * </pre>
 * @author yuanyan.cao@gmail.com
 *
 */
@SuppressWarnings("unchecked")
public abstract class BTreeSearch extends AbstractSearcher{
	 public static int Max  = 10;
	 public static int[] Data = { 15, 2, 13, 6, 17, 25, 37, 7, 3, 18 }; // 数据数组
	 public static int Counter = 1;

	 public static void main(String args[])
	 {
	  int i; // 循环计数变量
	  BNTreeArray BNTree = new BNTreeArray(); // 声明二叉树数组

	  BNTree.TreeData[0] = Data[0];

	  for (i = 1; i < Max; i++)
	   BNTree.Create(Data[i]); // 建立二叉查找树

	  int KeyValue = 25;
	  // 调用二叉查找法
	  if (BNTree.BinarySearch(KeyValue) > 0)
	   // 输出查找次数
	   System.out
	     .println("Search Time = " + BNTree.BinarySearch(KeyValue));
	  else
	   // 输出没有找到数据
	   System.out.println("No Found!!");
	 }
	}

	class BNTreeArray
	{
	 public static int MaxSize  = 20;
	 public static int[] TreeData = new int[MaxSize];
	 public static int[] RightNode = new int[MaxSize];
	 public static int[] LeftNode = new int[MaxSize];

	 public BNTreeArray()
	 {
	  int i; // 循环计数变量

	  for (i = 0; i < MaxSize; i++)
	  {
	   TreeData[i] = 0;
	   RightNode[i] = -1;
	   LeftNode[i] = -1;
	  }
	 }

	 // ----------------------------------------------------
	 // 建立二叉树
	 // ----------------------------------------------------
	 public void Create(int Data)
	 {
	  int i; // 循环计数变量
	  int Level = 0; // 树的阶层数
	  int Position = 0;

	  for (i = 0; TreeData[i] != 0; i++)
	   ;

	  TreeData[i] = Data;
	  while (true) // 寻找节点位置
	  {
	   // 判断是左子树或是右子树
	   if (Data > TreeData[Level])
	   {
	    // 右树是否有下一阶层
	    if (RightNode[Level] != -1)
	     Level = RightNode[Level];
	    else
	    {
	     Position = -1; // 设定为右树
	     break;
	    }
	   }
	   else
	   {
	    // 左树是否有下一阶层
	    if (LeftNode[Level] != -1)
	     Level = LeftNode[Level];
	    else
	    {
	     Position = 1; // 设定为左树
	     break;
	    }
	   }
	  }

	  if (Position == 1) // 建立节点的左右连结
	   LeftNode[Level] = i; // 连结左子树
	  else
	   RightNode[Level] = i; // 连结右子树
	 }

	 // ---------------------------------------------------------
	 // 二叉查找法
	 // ---------------------------------------------------------
	 public static int BinarySearch(int KeyValue)
	 {
	  int Pointer; // 现在的节点位置
	  int Counter; // 查找次数

	  Pointer = 0;
	  Counter = 0;
	  while (Pointer != -1)
	  {
	   Counter++;
	   // 找到了欲寻找之节点
	   if (TreeData[Pointer] == KeyValue)
	    return Counter; // 传回查找次数
	   else if (TreeData[Pointer] > KeyValue)
	    Pointer = LeftNode[Pointer]; // 往左子树找
	   else
	    Pointer = RightNode[Pointer];// 往右子树找
	  }
	  return 0; // 该节点不在此二叉树中
	 }
}
