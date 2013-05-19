import java.awt.Point;


public class Knight extends Piece {
	/* Constructor for Knight Object with position coordinates */	
	public Knight(int x, int y) throws InvalidInputException {
		super(x, y);
	}

	/* To get the next possible steps of Knight */
	@Override
	public Point[] nextStep() {
		Point currentPosition = this.getPosition();
		Point[] steps = new Point[8]; 
		
		steps[0] = new Point(currentPosition.x+1, currentPosition.y-2);
		steps[1] = new Point(currentPosition.x+1, currentPosition.y+2);
		steps[2] = new Point(currentPosition.x-1, currentPosition.y-2);
		steps[3] = new Point(currentPosition.x-1, currentPosition.y+2);
		steps[4] = new Point(currentPosition.x+2, currentPosition.y-1);
		steps[5] = new Point(currentPosition.x+2, currentPosition.y+1);
		steps[6] = new Point(currentPosition.x-2, currentPosition.y-1);
		steps[7] = new Point(currentPosition.x-2, currentPosition.y+1);
		
		return steps;
	}
}
