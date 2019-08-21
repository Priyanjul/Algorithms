/*
* Minimum steps needed to cover a sequence of points on an infinite grid
*/
import java.util.*;
class Point{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class MinSteps
{
    public static int shortestPath(Point source, Point dest){
        //SOURCE = DESTINATION
        if(source.x == dest.x && source.y == dest.y)
            return 0;
        //SOURCE IN STRAIGHT LINE W.R.T. DESTINATION 
        if(source.x == dest.x || source.y == dest.y)
            return Math.abs(source.x - dest.x + source.y - dest.y);
        //OFFSET OF DESTINATION FROM DIAGONAL PATH 
        int offset = Math.abs(Math.abs(source.x - dest.x) - Math.abs(source.y - dest.y));
        
        //SOURCE ON DIAGONAL W.R.T DESTINATION
        if(offset == 0)
            return Math.abs(source.x - dest.x);
        
        //SOURCE AT AN OFFSET FROM NEAREST DIAGONAL POINT W.R.T. DESTINATION
        int length = Math.min(Math.abs(source.x - dest.x), Math.abs(source.y - dest.y)) + offset;
        return length;
        
    }
    
    public static int coverPoints(Point points[]){
        if(points.length<=1)
            return 0;
        int length = 0;
        for(int i = 0; i<points.length-1 ; i++){
            length += shortestPath(points[i], points[i+1]);
        }
        return length;
    }
    
	public static void main(String[] args) {
	 // arr stores sequence of points 
    // that are to be visited 
    Point points[] = new Point[4];
    points[0] = new Point(4,6);
    points[1] = new Point(1,2);
    points[2] = new Point(4,5);
    points[3] = new Point(10,12);
    System.out.print(coverPoints(points)); 
	}
}
