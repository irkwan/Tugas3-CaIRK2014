package model;

import java.util.Vector;

public class GameStatus {
    
    /** Game board */
    private final WordamentMatrix Board;
    
    /** List of taken tiles in the board */
    private final Vector<Point> CurrPath;
    
    /** List of possible words (with the prefix of currpath) */
    private final Dictionary Possibility;
    
    
    public GameStatus(WordamentMatrix Boa, Dictionary Pos, Vector<Point> Cur) {
	Board = Boa;
	Possibility = Pos;
	CurrPath = Cur;
    }
    
    /**
     * @return The word formed by currpath in board
     */
    public String getWord() {
	
	StringBuilder res = new StringBuilder();
	for(Point p : CurrPath) {
	    res.append(Board.getChar(p));
	}
	return res.toString();
	
    }
    
    /**
     * @return All posible game status that can be generated with one move from 
     * the current one with an unempty Possibility dictionary 
     */
    public Vector<GameStatus> generateChild() {
	
	Vector<Point> PossibleMove = CurrPath.lastElement().getValidAdjacentPoint(CurrPath);
	Vector<GameStatus> GoodMove = new Vector<>();
	
	for(Point newP : PossibleMove) {
	    Dictionary tempD = Possibility.getSubDictPrefix(getWord()+Board.getChar(newP));
	    
	    if(!tempD.isEmpty()) {
		Vector<Point> tempP = new Vector<>(CurrPath);
		tempP.add(newP);
		GoodMove.add(new GameStatus(Board,tempD,tempP));
	    }
	}
	
	return GoodMove;
    }
    
    @Override
    public String toString() {
	StringBuilder res = new StringBuilder();
	res.append(Board.toString());
	res.append(CurrPath.toString());
	res.append("\n");
	res.append(Possibility.toString());
	res.append("\n");
	return res.toString();
    }
    
}
