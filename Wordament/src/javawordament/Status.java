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
public class Status {
    private final Matrix Board;
    private final Dictionary Claimed;
    private final Vector<Status> ClaimedDetail;
    
    private final Vector<Cell> CurrPath;
    private final Dictionary Possibility;
    
    public Status(Matrix B, Dictionary C, Vector<Status> CD, Vector<Cell> CP, Dictionary P) {
    	Board = B;
    	Claimed = C;
    	ClaimedDetail = CD;
    	CurrPath = CP;
    	Possibility = P;
        }
        
        
    public String getWord() {
    	
    	StringBuilder res = new StringBuilder();
    	for(Cell p : CurrPath) {
    	    res.append(Board.GetChar(p));
    	}
    	return res.toString();
    }
    
    public Vector<Cell> getPath() {
    	return CurrPath;
    }
    
    public int getCost() {
    	return Possibility.getSize();
    }
        
        
        /**
         * Also checked if the current state is a final state with word that is not
         * claimed yet; if so, add it to the claimed list
         * @return All posible game status that can be generated with one move from 
         * the current one with an unempty Possibility dictionary 
         */
    public Vector<Status> generateChild() {
    	
    	String name = getWord();
    	if(name.equals(Possibility.getFirstWord()) && !Claimed.isExist(name)) {
    	    Claimed.addWord(name);
    	    ClaimedDetail.add(this);
    	}
    	
    	Vector<Cell> PossibleMove = CurrPath.lastElement().getValidAdjacentPoint(CurrPath);
    	Vector<Status> GoodMove = new Vector<>();
    	
    	for(Cell newC : PossibleMove) {
    	    Dictionary tempD = Possibility.getSubPrefix(name+Board.GetChar(newC));
    	    
    	    if(!tempD.isEmpty()) {
    		Vector<Cell> tempP = new Vector<>(CurrPath);
    		tempP.add(newC);
    		GoodMove.add(new Status(Board, Claimed, ClaimedDetail, tempP, tempD));
    	    }
    	}
    	
    	return GoodMove;
    }
    
    public String toString() {
	
        String word = getWord();
	StringBuilder res = new StringBuilder();
	
        res.append("Word : ");
	res.append(getWord() + "(" + word.length() +")");
        
	res.append("\n");
        
        
	res.append("Path : ");
	res.append(CurrPath.toString());
	res.append("\n");
	
	return res.toString();
    }
}
