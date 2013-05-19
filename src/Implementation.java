import java.awt.Point;
import java.util.LinkedList;


public class Implementation {

	private static LinkedList<LinkedList<Point>> finalResult = new LinkedList<LinkedList<Point>>();
	
	private static void print(LinkedList<LinkedList<Point>> input){
		int c=1;
		if(input.isEmpty()){
			System.out.println("No Solution Exist");
		}else{
			
			int minList = input.peekFirst().size();
			int minHops = minList-1;
			
			int maxList = input.peekLast().size();
			int maxHops = maxList-1;
			
			System.out.println("Shortest Paths includes :"+minHops+" hops ");
			
			for(LinkedList<Point> list : input){
				if(list.size()==minList){
					System.out.print("Solution # "+c+" :");
					c++;
					for(Point point: list){
						System.out.print("("+point.x+","+point.y+")"+" ");
					}
					System.out.println("");
				}
			}
			
			System.out.println("Longest Path includes :"+maxHops+" hops ");
			System.out.print("Example : ");
			for(Point point: input.peekLast()){
				System.out.print("("+point.x+","+point.y+")"+" ");
			}
			System.out.println("");
			
		}
	}
	
	public static void main(String[] args) {
		int x =0;
		int y =0;
		
		try{
			Board chessBoard = new Board(8,8);
			
			x = Integer.parseInt(args[0]);
			y = Integer.parseInt(args[1]);
			
			if(x<=0 || y<=0) throw new InvalidInputException("Error: Input-Not Valid ");
			
			Piece knight = new Knight(x,y);
			
			chessBoard.setPiece(knight);
					
			finalResult = chessBoard.pieceTravel();
			System.out.println("Total Possible Paths are :"+finalResult.size());
			print(finalResult);
			
		}catch(Exception e){
			System.out.println("Error: Input-Not Valid ");
		}
		
		
		/*Board parameter check
		System.out.println("********BoardSize*********");
		System.out.println(chessBoard.getSize());
		System.out.println("********CurrentPositions*********");
		System.out.println(chessBoard.getPiece().getPosition());
		System.out.println("********NextPositions*********");
		chessBoard.test();
		*//**********************************/
		
		

		
	}
	
	

}
