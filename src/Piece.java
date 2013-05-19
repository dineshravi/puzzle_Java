import java.awt.Point;


public abstract class Piece {
	private Point currentPosition;
	
	public Piece (int x, int y) throws InvalidInputException{
		try{
			if((int)x<=0 || (int)y<=0)throw new InvalidInputException("Error: Invalid Piece Parameters");
			currentPosition = new Point(x,y);
		}catch (Exception e){
			System.out.println("Error: Invalid Piece Parameters");
		}
	}
		
	public Point getPosition(){
		return this.currentPosition;
	}
	
	public void setPosition(Point p){
		try{
			if(p.x<=0 || p.y<=0)throw new InvalidInputException("Error: Invalid Piece Parameters");
			else{
				currentPosition = p;
			}
		}catch (Exception e){
			System.out.println("Error: Invalid Piece Parameters");
		}
	}
	
	public abstract Point[] nextStep();
}
