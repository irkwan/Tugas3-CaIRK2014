
package controller;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Vector;
import model.Dictionary;
import model.GameStatus;
import model.Point;
import model.WordamentMatrix;

/**
 *
 * @author USER
 */
public class GameTree {
    
    private static class GameStatusComparator implements Comparator<GameStatus> {
	@Override
	public int compare(GameStatus x, GameStatus y) {
	    if (x.getCost() < y.getCost())
	    {
		return -1;
	    }
	    if (x.getCost() > y.getCost())
	    {
		return 1;
	    }
	    return 0;
	}
    }
    
    private final GameStatusComparator MyComp = new GameStatusComparator();
    private final PriorityQueue<GameStatus> Repository = new PriorityQueue<>(1,MyComp);

    /** Game board */
    private final WordamentMatrix Board;
    /** List of words that is already made */
    private final Dictionary Claimed;
    /** List of Final-state GameStatus that is already made */
    private final Vector<GameStatus> ClaimedDetail;
    /** List of possible words) */
    private final Dictionary MasterDict;
    
    public GameTree(WordamentMatrix M, Dictionary W) {
	
	Board = M;
	Claimed = new Dictionary();
	ClaimedDetail = new Vector<>();
	MasterDict = W; 
	
	for(int i=0; i<4; i++) {
	    for(int j=0; j<4; j++) {
		
		Point pos = new Point(i,j);
		
		Vector<Point> Way = new Vector<>();
		Way.add(pos);
		Dictionary SubDict = MasterDict.getSubDictPrefix(Character.toString(M.getChar(pos)));

		if(!SubDict.isEmpty()) Repository.add(new GameStatus(Board, Claimed, ClaimedDetail, Way, SubDict));
		
	    }
	}
	
    }
    
    public void Begin() {
	while(!Repository.isEmpty()) {
	    Repository.addAll(Repository.remove().generateChild());
	}
    }
    
    public Vector<GameStatus> getResult() {
	return ClaimedDetail;
    }
}
