/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawordament;

import java.util.Vector;

/**
 *
 * @author Johan
 */
public class Cell {
    public int x;
    public int y;

    public Cell(){
        x=0; y=0;
    }

    public Cell(int _x, int _y){
        x=_x; y=_y;
    }

    private boolean outOfBounds() {
            return ((x<0)||(y<0)||(x>3)||(y>3));
    }

    private Vector<Cell> getAdjacentCell() {

        Vector<Cell> V = new Vector<>();
        V.add(new Cell(x,y+1));
        V.add(new Cell(x+1,y+1));
        V.add(new Cell(x+1,y));
        V.add(new Cell(x+1,y-1));
        V.add(new Cell(x,y-1));
        V.add(new Cell(x-1,y-1));
        V.add(new Cell(x-1,y));
        V.add(new Cell(x-1,y+1));

        for(int i=0; i<V.size(); i++) {
            if(V.get(i).outOfBounds()) {
                V.remove(i);
                i--;
            }
        }
        return V;
    }

    public Vector<Cell> getValidAdjacentPoint(Vector<Cell> Taken) {
            Vector<Cell> res = getAdjacentCell();
            res.removeAll(Taken);
            return res;
    }
    public String toString() {
	return "("+x+","+y+")";
    }
}
