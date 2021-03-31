package numberRangeSummerize;

import org.junit.Assert;
import org.junit.Test;



public class SummarizeServiceTest {

	@Test
	public void testSummerizedNumbers() {
		String inputNumbers = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        String expectedSummary = "1,3,6-8,12-15,21-24,31";

        Assert.assertEquals((inputNumbers), expectedSummary);
    }
}
