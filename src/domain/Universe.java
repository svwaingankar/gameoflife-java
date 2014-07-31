package domain;
import java.util.HashSet;


public class Universe {

	private HashSet<Cell> _cells;
    final char aliveCellChar = 'X';
    final char deadCellChar = '.';
    final char lineSeparator = '\n';
	
	public Universe() {
		_cells =  new HashSet<Cell>();
	}
	
	public void addCellAt(int x, int y) {
        Cell cell = new Cell(x,y);
		_cells.add(cell);
	}
	
	public void addCellAt(Cell position) {
		addCellAt(position.getX(), position.getY());
	}

	public void addCellAtSamePositionOf(Cell cell) {
		_cells.add(cell);
	}

	public boolean containsCellAt(int x, int y)
	{
		Cell cell = new Cell(x,y);
		return _cells.contains(cell);
	}

	public int cellCount() {
		return _cells.size();
	}

	public Universe evolve() {
        Universe nextUniverse =  new Universe();

    	deathCycle(nextUniverse);
		birthCycle(nextUniverse);
        return nextUniverse;
		
	}

	private void birthCycle(Universe nextUniverse) {
		for (Cell cell :_cells)
		{
			for (Cell position: cell.getNeighboursPositions())
			{
				int neighboursCount =  neighboursCount(position);
				if (neighboursCount == 3)
				{
					nextUniverse.addCellAt(position);
				}
			}
		}
	}

	private void deathCycle(Universe nextUniverse) {
		for (Cell cell :_cells)
		{
			int neighboursCount =  neighboursCount(cell);
			if (neighboursCount == 2 || neighboursCount == 3)
			{
				nextUniverse.addCellAtSamePositionOf(cell);
			}
		}
	}
	
	private int neighboursCount(Cell cellPosition)
	{
		HashSet<Cell> neighboursPositions = cellPosition.getNeighboursPositions();
		int neighbours = 0;
		for(Cell position:neighboursPositions)
		{
			if (containsCellAt(position.getX(), position.getY()))
			{
				neighbours += 1;
			}
		}
		return neighbours;
	}


    public void populateFromString(String asciiWorldRepresentation) {
        int x = 0;
        int y = 0;

        for (char currentChar:asciiWorldRepresentation.toCharArray())
        {
            if (currentChar == aliveCellChar){
                addCellAt(x, y);
            }
            x++;
            if (currentChar == lineSeparator){
                x = 0;
                y += 1;
            }
        }
    }

    public String toString(){

        int minRow=0,minCol=0,maxRow=0,maxCol=0;

        for(Cell cell : _cells){
            if(cell.getY()<minRow){
                minRow = cell.getY();
            }
            if(cell.getY()>maxRow){
                maxRow = cell.getY();
            }
            if(cell.getX()<minCol){
                minCol = cell.getX();
            }
            if(cell.getX()>maxCol){
                maxCol = cell.getX();
            }
        }
        String stringRepresentation = "";

        for(int i=minRow;i<=maxRow;i++){
            for(int j=minCol;j<=maxCol;j++){
                if(containsCellAt(j,i)){
                    stringRepresentation+=aliveCellChar;
                }else{
                    stringRepresentation+=deadCellChar;
                }

            }
            stringRepresentation+=lineSeparator;
        }

        return stringRepresentation;

    }
}
