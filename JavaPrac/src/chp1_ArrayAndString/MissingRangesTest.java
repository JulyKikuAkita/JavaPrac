package chp1_ArrayAndString;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class MissingRangesTest {
	MissingRanges solution = new MissingRanges();
	int[] t1 = {0, 1, 3, 50, 75};
	int[] t2 = {0,1,2,3,4,5};
	int[] t3 = {0,1,2,3,4,5,6,7,8,9,10};
	List<String> ans1 = new ArrayList<String>(Arrays.asList("2", "4->49", "51->74", "76->99"));
	List<String> ans2 = new ArrayList<String>();
	List<String> ans3 = Arrays.asList("11->1000");

	@Test
	public final void testFindMissingRanges() {
		Assert.assertEquals(ans1, solution.findMissingRanges(t1, 0, 99));
		Assert.assertEquals(ans2, solution.findMissingRanges(t2, 0, 5));
		Assert.assertEquals(ans3, solution.findMissingRanges(t3, 1, 1000));
	}

}
