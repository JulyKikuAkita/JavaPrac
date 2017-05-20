package chp4_BinaryTree;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class ValidateBinarySearchTreeTest {
	ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
	//TreeNode root1 = TreeNode.createTreeUsingArr(new Integer[]{0,1,2,3,4,5,6});
	TreeNode root2 = TreeNode.createTreeUsingArr(new Integer[]{9,8,7,6,5,4,3,2,1});
	TreeNode root3 = TreeNode.createTreeUsingArr(new Integer[]{1,2,3});
	//TreeNode root4 = TreeNode.createTreeUsingArr(new Integer[]{0});
	
	
	public TreeNode createScrewTree(){
		TreeNode screwed = new TreeNode(3);
		screwed.right = new TreeNode(14); 
		screwed.right.right = new TreeNode(15);
		screwed.right.right.right = new TreeNode(9);
		screwed.right.right.right.right = new TreeNode(26);
		
		return screwed;
	}

	@Test
	public final void testIsValidBSTBruteForce() {
	//	Assert.assertTrue(solution.isValidBSTBruteForce(root3));
	}

	@Test
	public final void testIsValidBSTCheckRange() {
	//	Assert.assertTrue(solution.isValidBSTCheckRange(root3));
	}

	@Test
	public final void testIsValidBSTInOrder() {
		Assert.assertTrue(solution.isValidBSTInOrder(root3));
		Assert.assertFalse(solution.isValidBSTInOrder(root2));
	}

	@Test
	public final void testIsValidBSTMorris() {
		Assert.assertTrue(solution.isValidBSTMorris(root3));
		Assert.assertFalse(solution.isValidBSTMorris(root2));
		Assert.assertFalse(solution.isValidBSTMorris(createScrewTree()));
	}

}
