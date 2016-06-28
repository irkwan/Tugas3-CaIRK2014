package controller;

import java.util.Vector;
import model.Dictionary;
import model.Point;
import model.WordamentMatrix;

public class GameStatus {
    
    /** Game board */
    private final WordamentMatrix Board;
    /** List of words that is already made */
    private final Dictionary Claimed;
    /** List of Final-state GameStatus that is already made */
    private final Vector<GameStatus> ClaimedDetail;
    
    /** List of taken tiles in the board */
    private final Vector<Point> CurrPath;
    /** List of possible words (with the prefix of currpath) */
    private final Dictionary Possibility;
    
    
    public GameStatus(WordamentMatrix B, Dictionary C, Vector<GameStatus> CD, Vector<Point> CP, Dictionary P) {
	Board = B;
	Claimed = C;
	ClaimedDetail = CD;
	CurrPath = CP;
	Possibility = P;
    }
    
    /**
     * Return the word formed by currpath in board
     */
    public String getWord() {
	
	StringBuilder res = new StringBuilder();
	for(Point p : CurrPath) {
	    res.append(Board.getChar(p));
	}
	return res.toString();
	
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
    public Vector<GameStatus> generateChild() {
	
	String name = getWord();
	if(name.equals(Possibility.getFirstWord()) && !Claimed.isExist(name)) {
	    Claimed.addWord(name);
	    ClaimedDetail.add(this);
	}
	
	Vector<Point> PossibleMove = CurrPath.lastElement().getValidAdjacentPoint(CurrPath);
	Vector<GameStatus> GoodMove = new Vector<>();
	
	for(Point newP : PossibleMove) {
	    Dictionary tempD = Possibility.getSubDictPrefix(name+Board.getChar(newP));
	    
	    if(!tempD.isEmpty()) {
		Vector<Point> tempP = new Vector<>(CurrPath);
		tempP.add(newP);
		GoodMove.add(new GameStatus(Board, Claimed, ClaimedDetail, tempP, tempD));
	    }
	}
	
	return GoodMove;
    }
    
    
    @Override
    public String toString() {
	
	StringBuilder res = new StringBuilder();
	
	res.append("CurrPath : ");
	res.append(CurrPath.toString());
	res.append("\n");
	
	res.append("Word : ");
	res.append(getWord());
	res.append("\n");
	
	return res.toString();
    }
    
}
