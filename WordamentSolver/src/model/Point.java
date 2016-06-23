package model;

import java.util.Vector;

public final class Point {
    
    public int x;
    public int y;
    
    public Point() {
	x = 0;
	y = 0;
    } 
    public Point(int _x, int _y) {
	x = _x;
	y = _y;
    }
    
    /**
     * @return Whether or not the coord is within the Wordament Matrix limit
     */
    private boolean outOfBounds() {
	return ((x<0)||(y<0)||(x>3)||(y>3));
    }
    
    /**
     * @return All possible coord in the 8 cardinal direction of this point that
     * is not outOfBounds
     */
    private Vector<Point> getAdjacentPoint() {
	
	Vector<Point> temp = new Vector<>();
	temp.add(new Point(x,y+1));
	temp.add(new Point(x+1,y+1));
	temp.add(new Point(x+1,y));
	temp.add(new Point(x+1,y-1));
	temp.add(new Point(x,y-1));
	temp.add(new Point(x-1,y-1));
	temp.add(new Point(x-1,y));
	temp.add(new Point(x-1,y+1));
	
	for(int i=0; i<temp.size(); i++) {
	    if(temp.get(i).outOfBounds()) {
		temp.remove(i);
		i--;
	    }
	}
	
	return temp;
    }
    
    /**
     * @param Taken a vector of points
     * @return All possible adjacent point that is not in the Taken vactor
     */
    public Vector<Point> getValidAdjacentPoint(Vector<Point> Taken) {
	Vector<Point> res = getAdjacentPoint();
	res.removeAll(Taken);
	return res;
    }
    
    
    @Override
    public boolean equals(Object p) {
	
	if (p == null) {
	    return false;
	}
	if (!Point.class.isAssignableFrom(p.getClass())) {
	    return false;
	}
	
	Point p2 = (Point) p;
	return !((x != p2.x)||(y != p2.y));
	
    }

    @Override
    public int hashCode() {
	int hash = 3;
	hash = 97 * hash + this.x;
	hash = 97 * hash + this.y;
	return hash;
    }
    
    @Override
    public String toString() {
	return "("+x+","+y+")";
    }
    
}
