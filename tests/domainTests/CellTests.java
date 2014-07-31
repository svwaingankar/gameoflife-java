package domainTests;

import java.util.HashSet;

import domain.Cell;
import junit.framework.Assert;

import org.junit.Test;

/**
 * @shantaram waingankar
 * 30/7/2014
 */
public class CellTests {
	
	@Test
	public void testCellEquality()
	{
		Cell cell1 = new Cell(0,0);
		Cell cell2 = new Cell(1,2);
		Cell cell3 = new Cell(1,2);
		
		Assert.assertTrue(cell2.equals(cell3));
		Assert.assertFalse(cell1.equals(cell2));
		Assert.assertFalse(cell1.equals(cell3));
	}
	
	@Test
	public void testCellNeighboursPositions()
	{
		Cell topLeft =  new Cell(4,4);
		Cell top = new Cell(4,5);
		Cell topRight = new Cell(4,6);
		Cell left = new Cell(5,4);
		Cell right = new Cell(5,6);
		Cell bottomLeft = new Cell(6,4);
		Cell bottom = new Cell(6,5);
		Cell bottomRight = new Cell(6,6);
		
		HashSet<Cell> expectedNeighboursPosition =  new HashSet<Cell>();
		
		expectedNeighboursPosition.add(topLeft);
		expectedNeighboursPosition.add(top);
		expectedNeighboursPosition.add(topRight);
		expectedNeighboursPosition.add(left);
		expectedNeighboursPosition.add(right);
		expectedNeighboursPosition.add(bottomLeft);
		expectedNeighboursPosition.add(bottom);
		expectedNeighboursPosition.add(bottomRight);
		
		Cell cell1 =  new Cell(5,5);
		HashSet<Cell> actualNeighboursPosition =  cell1.getNeighboursPositions();
		Assert.assertTrue(expectedNeighboursPosition.equals(actualNeighboursPosition));
	}
}
