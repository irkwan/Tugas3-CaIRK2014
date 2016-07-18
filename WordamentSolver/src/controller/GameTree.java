
package controller;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Vector;

import model.Dictionary;
import model.Point;
import model.WordamentMatrix;

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

    private final Vector<GameStatus> ClaimedDetail;
    
    public GameTree(WordamentMatrix M, Dictionary W) {
	
	Dictionary Claimed = new Dictionary();
	ClaimedDetail = new Vector<>();
	
	for(int i=0; i<4; i++) {
	    for(int j=0; j<4; j++) {
		
		Point pos = new Point(i,j);
		
		Vector<Point> Way = new Vector<>();
		Way.add(pos);
		Dictionary SubDict = W.getSubDictPrefix(Character.toString(M.getChar(pos)));

		if(!SubDict.isEmpty()) Repository.add(new GameStatus(M, Claimed, ClaimedDetail, Way, SubDict));
		
	    }
	}
	
    }
    
    public void Begin(boolean[] Stop) {
	while((!Repository.isEmpty())&&(!Stop[0])) {
	    Repository.addAll(Repository.remove().generateChild());
	}
    }
    
    public Vector<GameStatus> getResult() {
	return ClaimedDetail;
    }
}

