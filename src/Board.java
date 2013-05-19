import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;



public class Board {

	private Piece currentPiece;
	
	private int maxWidth;
	private int maxHeight;
	
	private Point destination;
	
	public Board(int maxX, int maxY) throws InvalidInputException {
		if(maxX<=0 || maxY<=0) throw new InvalidInputException("Error: Board dimension invalid");
		else{
			this.maxHeight = maxX;
			this.maxWidth = maxY;
			this.destination = new Point(maxX,maxY);
		}
	}
	
	public void setPiece(Piece userPiece) throws InvalidInputException{
		try{
			if(userPiece.getPosition().x<=0 || userPiece.getPosition().x>maxHeight || 
					userPiece.getPosition().y<=0 || 
					userPiece.getPosition().y>maxWidth) throw new InvalidInputException("Error: Piece not on Board");
			else{
			this.currentPiece = userPiece;
			}
		}catch (Exception e){
			System.out.println("Error: Invalid Piece Position");
		}
	}
	
	public Piece getPiece(){
		return currentPiece;
	}
	
	public int getSize(){
		return (maxHeight * maxWidth);
	}
	
	public LinkedList<LinkedList<Point>> pieceTravel(){
		//method returns a list of Points which signify the shortest path
		LinkedList<LinkedList<Point>> result = new LinkedList<LinkedList<Point>>();
		Queue<LinkedList<Point>> queue = new LinkedList<LinkedList<Point>>();
				
		int i = 0;
		LinkedList<Point> startPath = new LinkedList<Point>();
				
		startPath.add(currentPiece.getPosition());
				
		queue.add(startPath);
				
		while(!queue.isEmpty()){
			i++;
			LinkedList<Point> currentPath = queue.remove();
			Point currentPoint = currentPath.getLast();
			
			if(currentPoint.x == destination.x && currentPoint.y == destination.y){
				result.add(currentPath);
			}
			
			else {					//Change Made from if(!pathFound) - else 
				currentPiece.setPosition(currentPoint);
				for(Point nextPoint: currentPiece.nextStep()){
					if(isPointLegal(nextPoint)){
						if(!currentPath.contains(nextPoint)){
							LinkedList<Point> nextPath = new LinkedList<Point>();
							nextPath.addAll(currentPath);
							nextPath.add(nextPoint);
							queue.add(nextPath);
						}
					}
				}
				
			}
		}
		System.out.println("Number of iterations: "+i);
		return result;
	}
	
	public boolean isPointLegal(Point p){	
		if(p.x>=1 && p.x<=maxHeight && p.y>=1 && p.y<=maxWidth){
			return true;
		}else return false;
	}
	
	/* test for the nextStep array of Knight */
	public void test(){
		for(Point i: currentPiece.nextStep()){
			System.out.println(i);
		}
	}
}
