/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawordament;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Vector;

/**
 *
 * @author Johan
 */
public class Tree {
    private static class GameStatusComparator implements Comparator<Status> {
		public int compare(Status x, Status y) {
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
    private final PriorityQueue<Status> Repository = new PriorityQueue<>(1,MyComp);
    private final Vector<Status> ClaimedDetail;
    
    public Tree(Matrix M, Dictionary D) {
    	Dictionary Claimed = new Dictionary();
    	ClaimedDetail = new Vector<>();
    	
    	for(int i=0; i<4; i++) {
    	    for(int j=0; j<4; j++) {
    		Cell pos = new Cell(i,j);
    		
    		Vector<Cell> Way = new Vector<>();
    		Way.add(pos);
    		Dictionary SubDict = D.getSubPrefix(Character.toString(M.GetChar(pos)));

    		if(!SubDict.isEmpty()) Repository.add(new Status(M, Claimed, ClaimedDetail, Way, SubDict));
    		
    	    }
    	}
    }
    
    public void begin() {
    	while(!Repository.isEmpty()) {
    	    Repository.addAll(Repository.remove().makeChild());
    	}
    }
    
    public Vector<Status> getResult() {
    	return ClaimedDetail;
    }
}
