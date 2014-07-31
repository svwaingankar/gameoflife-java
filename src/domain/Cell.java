package domain;
import java.util.HashSet;


public class Cell {

	private final int x;
	private final int y;

	public Cell(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
        int hash = 23;
        hash = hash * 31 + x;
        hash = hash * 31 + y;
        return hash;
	}

	@Override
	public boolean equals(Object otherObject) {
		if (!(otherObject instanceof Cell)){
			return false;
		}
		Cell otherCell = (Cell)otherObject;
		return haveSamePosition(this, otherCell);
	}

	public HashSet<Cell> getNeighboursPositions() {
		HashSet<Cell> neighboursPositions =  new HashSet<Cell>();
		
		neighboursPositions.add(getTopLeftPosition());
		neighboursPositions.add(getTopPosition());
		neighboursPositions.add(getTopRightPosition());
		neighboursPositions.add(getLeftPosition());
		neighboursPositions.add(getRightPosition());
		neighboursPositions.add(getBottomLeftPosition());
		neighboursPositions.add(getBottomPosition());
		neighboursPositions.add(getBottomRightPosition());
		
		return neighboursPositions;
	}

		private boolean haveSamePosition(Cell firstCell, Cell secondCell)
	{
		boolean haveSamePosition =
				(firstCell.x == secondCell.x) &&
				(firstCell.y == secondCell.y);
		return haveSamePosition;
	};
	
	private Cell getTopLeftPosition()
	{
		return getPosition(-1, -1);
	}

	private Cell getTopPosition()
	{
		return getPosition(0,-1);
	}

	private Cell getTopRightPosition() {
		return getPosition(+1, -1);
	}

	private Cell getRightPosition() {
		return getPosition(+1, 0);
	}

	private Cell getBottomRightPosition() {
		return getPosition(+1, +1);
	}

	private Cell getBottomPosition() {
		return getPosition(0, +1);
	}

	private Cell getBottomLeftPosition() {
		return getPosition(-1, +1);
	}

	private Cell getLeftPosition() {
		return getPosition(-1, 0);
	}
	
	private Cell getPosition(int xOffset, int yOffset)
	{
		int x =  this.x + xOffset;
		int y =  this.y + yOffset;
		Cell position =  new Cell(x, y);
		return position;
	}



}
