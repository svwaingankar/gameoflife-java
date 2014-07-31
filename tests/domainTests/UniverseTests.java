package domainTests;
import domain.Universe;
import junit.framework.Assert;

import org.junit.Test;

/**
 * @shantaram waingankar
 * 30/7/2014
 */
public class UniverseTests {


	@Test
	public void testWorldCellCount()
	{
		Universe universe =  new Universe();
		Assert.assertTrue(universe.cellCount() == 0);
		universe.addCellAt(1,3);
		Assert.assertTrue(universe.cellCount() == 1);
		universe.addCellAt(2,3);
		Assert.assertTrue(universe.cellCount() == 2);
		universe.addCellAt(3,3);
		Assert.assertTrue(universe.cellCount() == 3);
		universe.addCellAt(4,3);
		Assert.assertTrue(universe.cellCount() == 4);
		universe.addCellAt(1,3);
		Assert.assertTrue(universe.cellCount() == 4);
	}

    @Test
    public void testWorldCellAdd()
    {
        Universe universe =  new Universe();
        Assert.assertTrue(universe.cellCount() == 0);
        universe.addCellAt(1,3);
        Assert.assertTrue(universe.cellCount() == 1);
        Assert.assertTrue(universe.containsCellAt(1,3));
    }

}
