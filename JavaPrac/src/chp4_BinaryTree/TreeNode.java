/**
Generic examples: http://math.hws.edu/javanotes/c10/s5.html
Java generic turtorial : http://www.tutorialspoint.com/java/java_generics.htm
 */
package chp4_BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author iflee
 *
 */
public class TreeNode<T> {
	int val;
	TreeNode<T> left;
	TreeNode<T> right;

	public TreeNode (int x) {
		val = x;
	}
	
	public static TreeNode createTreeUsingArr(Integer[] x){
		return sortedArrayToBST(x, 0, x.length - 1);
	}
	
	private static TreeNode sortedArrayToBST(Integer[] arr, int start, int end) {
		if (start > end) return null;
		int mid = (start +end) / 2;
		TreeNode cur = new TreeNode(arr[mid]);
		cur.left  = sortedArrayToBST(arr, start, mid - 1);
		cur.right  = sortedArrayToBST(arr, mid + 1, end);
		return cur;
	}
	
	

}
