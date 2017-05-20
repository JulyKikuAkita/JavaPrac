package chp2_Math;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class ReverseIntegerTest {
	ReverseInteger solution = new ReverseInteger();
	int t1 = 123;
	int t2 = 0;
	int t3 = -321;
	int t4 = Integer.MAX_VALUE;
	int t5 = Integer.MIN_VALUE;

	@Test
	public final void testReverse() {
		Assert.assertEquals(321, solution.reverse(t1));
		Assert.assertEquals(0, solution.reverse(t2));
		Assert.assertEquals(-123, solution.reverse(t3));
		Assert.assertEquals(0, solution.reverse(t4));
		Assert.assertEquals(0, solution.reverse(t5));
	}

}
